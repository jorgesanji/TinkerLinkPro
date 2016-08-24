package com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.tlinker;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.tlinker.adapter.CategoriesAdapter;
import com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.tlinker.adapter.viewholder.CategoryViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class TLinkerSelectorScreen extends TLBaseView {

    public interface Listener {
        void setCurrentCategorySelected(RestCategory categoria);

        void skillSelectAtPosition(int position);
    }

    // Vars
    private Listener listener;
    private CategoriesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private StackCardType typeTinker;

    // Views
    @BindView(R.id.categoriesList)
    protected TLRecyclerView mCategoriesList;

    @BindView(R.id.titleTLinker)
    protected TLTextView mTitleTLinker;

    @BindView(R.id.descriptionTLinker)
    protected TLTextView mDescriptionTLinker;

    private CategoryViewHolder viewHolderSelected;

    /**
     * @param context
     */
    public TLinkerSelectorScreen(Context context, StackCardType typeTinker) {
        super(context);
        setTypeTinker(typeTinker);
    }

    /**
     * @param context
     */
    public TLinkerSelectorScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLinkerSelectorScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLinkerSelectorScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLinkerSelectorScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_tlinker_selector;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mCategoriesList.setLayoutManager(mLayoutManager);
        mCategoriesList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initListeners() {
        mAdapter.setSkillListener(new CategoriesAdapter.IOSkillListener() {
            @Override
            public void onSkillSelected(int position) {
                listener.skillSelectAtPosition(position);
            }
        });

        mAdapter.setCategoryListener(new CategoriesAdapter.IOCategoryListener() {
            @Override
            public void onCategorySelected(CategoryViewHolder categoryViewHolder) {
                viewHolderSelected = categoryViewHolder;
            }
        });

        mAdapter.setExpandCollapseListener(new ExpandableRecyclerAdapter.ExpandCollapseListener() {
            @Override
            public void onListItemExpanded(int position) {
                if (viewHolderSelected != null) {
                    viewHolderSelected.collapse();
                }
                listener.setCurrentCategorySelected((RestCategory) mAdapter.getParentItemList().get(position));
            }

            @Override
            public void onListItemCollapsed(int position) {
                viewHolderSelected = null;
            }
        });
    }

    private void initUI() {
        String preferences = getContext().getResources().getString(R.string.sign_register_title_preferences);
        String tlinker;
        String description;
        int color;
        if (typeTinker == StackCardType.LINKER) {
            tlinker = getContext().getResources().getString(R.string.profile_services);
            description = getContext().getResources().getString(R.string.sign_register_title_linker);
            color = R.color.linkercolor;
        } else {
            tlinker = getContext().getResources().getString(R.string.profile_offers);
            description = getContext().getResources().getString(R.string.sign_register_title_tinker);
            color = R.color.tinkercolor;
        }

        setTextTitle(preferences + " " + tlinker, tlinker, color);
        setTextDescription(description);
    }

    // Actions

    // Public method

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public StackCardType getTypeTinker() {
        return typeTinker;
    }

    public void setTypeTinker(StackCardType typeTinker) {
        this.typeTinker = typeTinker;
        initUI();
    }

    public void setItems(List<RestCategory> restCategories) {
        mAdapter = new CategoriesAdapter(restCategories, getContext());
        mAdapter.setTypeTinker(getTypeTinker());
        mCategoriesList.setAdapter(mAdapter);
        initListeners();
    }

    public List<RestCategory> getItems() {
        return (List<RestCategory>) mAdapter.getParentItemList();
    }

    public void setTextTitle(String title, String textToPaint, int colorToPain) {
        mTitleTLinker.setText(title);
        mTitleTLinker.paintTextWithColor(textToPaint, colorToPain);
    }

    public void setTextDescription(String textDescription) {
        mDescriptionTLinker.setText(textDescription);
    }
}

