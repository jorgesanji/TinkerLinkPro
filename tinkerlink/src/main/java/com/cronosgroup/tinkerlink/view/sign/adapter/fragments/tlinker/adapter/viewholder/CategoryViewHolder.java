package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.tlinker.adapter.viewholder;

import android.view.View;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
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
    CategoriesAdapter.IOCategoryListener listener;

    // Views
    @BindView(R.id.titleCategory)
    protected TLTextView mTitle;

    public CategoryViewHolder(View itemView, int type) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void configureItem(RestCategoria categoria) {
        mTitle.setText(categoria.getCategoria());
    }

    @OnClick(R.id.handlerExpand)
    protected void expandPressed() {
        if (isExpanded()) {
            collapseView();
        } else {
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

    public void collapse() {
        collapseView();
    }

    public CategoriesAdapter.IOCategoryListener getListener() {
        return listener;
    }

    public void setListener(CategoriesAdapter.IOCategoryListener listener) {
        this.listener = listener;
    }
}
