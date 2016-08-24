package com.cronosgroup.tinkerlink.view.dialog.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategory;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.CategoriesAdapter;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.viewholder.CategoryViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CategoryDialogScreen extends TLLinearLayout {

    public interface Listener {
        void onClosePressed();

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

    @BindView(R.id.titleDialog)
    protected TLTextView mTitleDialog;

    @BindView(R.id.containerCategories)
    protected View mContainerCategories;

    private CategoryViewHolder viewHolderSelected;

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context, StackCardType typeTinker, Listener listener) {
        super(context);
        setTypeTinker(typeTinker);
        setListener(listener);
    }

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CategoryDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CategoryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CategoryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_category;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        initUI();
        initRecyclerView();
    }

    private void initUI() {
        mTitleDialog.setText(getResources().getString(R.string.dialog_category_title));
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

    // Actions

    @OnClick(R.id.closeDialog)
    protected void onClosePressed() {
        listener.onClosePressed();
    }

    // Public method

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void show() {
        appear(mContainerCategories);
    }

    public StackCardType getTypeTinker() {
        return typeTinker;
    }

    public void setTypeTinker(StackCardType typeTinker) {
        this.typeTinker = typeTinker;
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

}
