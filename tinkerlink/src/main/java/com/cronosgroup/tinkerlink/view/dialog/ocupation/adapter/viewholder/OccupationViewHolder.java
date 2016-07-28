package com.cronosgroup.tinkerlink.view.dialog.ocupation.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/28/16.
 */
public class OccupationViewHolder extends BaseViewHolder<String> {

    @BindView(R.id.title_item_dialog)
    protected TLTextView mTitle;

    public OccupationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void configureItem(String item) {
        super.configureItem(item);
        mTitle.setText(item);
    }
}
