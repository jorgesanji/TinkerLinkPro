package com.cronosgroup.tinkerlink.view.dialog.category.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ViewHolderCategory extends BaseViewHolder {


    @BindView(R.id.title_item_dialog)
    protected TLTextView mTitle;

    /**
     * @param view
     */
    public ViewHolderCategory(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    // Public methods

    public void configItem(String name, boolean isLinkerCard) {
        mTitle.setText(name);
        itemView.setBackgroundResource((isLinkerCard) ? R.drawable.list_linker_states : R.drawable.list_tinker_states);
    }

}