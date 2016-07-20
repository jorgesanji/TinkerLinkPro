package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category.adapter.CategoriesAdapter;
import com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category.adapter.viewholder.CategoryViewHolder;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionScreen extends LinearLayout {

    public interface Listener {
        void setCurrentCategorySelected(RestCategoria categoria);

        void skillSelectAtPosition(int position);
    }

    // Vars
    private Listener listener;
    private CategoriesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views
    @BindView(R.id.categoriesList)
    protected TLRecyclerView mCategoriesList;

    private CategoryViewHolder viewHolderSelected;

    public CategorySelectionScreen(Context context) {
        this(context, null);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.lay_categories_selection, this);
        ButterKnife.bind(this);
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
                listener.setCurrentCategorySelected((RestCategoria) mAdapter.getParentItemList().get(position));
            }

            @Override
            public void onListItemCollapsed(int position) {
                viewHolderSelected = null;
            }
        });
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<RestCategoria> restCategorias) {
        mAdapter = new CategoriesAdapter(restCategorias, getContext());
        mCategoriesList.setAdapter(mAdapter);
        initListeners();
    }

    public List<RestCategoria> getItems() {
        return (List<RestCategoria>) mAdapter.getParentItemList();
    }
}
