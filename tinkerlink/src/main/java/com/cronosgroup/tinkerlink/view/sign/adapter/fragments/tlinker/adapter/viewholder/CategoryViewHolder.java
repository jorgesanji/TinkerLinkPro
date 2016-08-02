package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.viewholder;

import android.view.View;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.CategoriesAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategoryViewHolder extends ParentViewHolder {

    // Vars
    private CategoriesAdapter.IOCategoryListener listener;
    private StackCard type;

    // Views
    @BindView(R.id.titleCategory)
    protected TLTextView mTitle;

    @BindView(R.id.containerText)
    protected LinearLayout mContainer;

    @BindView(R.id.dropDownCategory)
    protected TLImageView mDropDownCategory;

    public CategoryViewHolder(View itemView, StackCard type) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.type = type;
    }

    public void configureItem(RestCategoria categoria) {
        mTitle.setText(categoria.getCategoria());
        reset();
    }

    @OnClick(R.id.handlerExpand)
    protected void expandPressed() {
        if (isExpanded()) {
            collapseView();
            reset();
        } else {
            mDropDownCategory.animate().rotation(180).start();
            mContainer.setBackgroundResource(type.getStackSelectorColor());
            expandView();
            if (listener != null) {
                listener.onCategorySelected(this);
            }
        }
    }

    @Override
    public boolean shouldItemViewClickToggleExpansion() {
        return false;
    }

    private void reset() {
        mContainer.setBackgroundResource(android.R.color.transparent);
        mDropDownCategory.animate().rotation(0).start();
    }

    public void collapse() {
        collapseView();
        reset();
    }

    public CategoriesAdapter.IOCategoryListener getListener() {
        return listener;
    }

    public void setListener(CategoriesAdapter.IOCategoryListener listener) {
        this.listener = listener;
    }
}
