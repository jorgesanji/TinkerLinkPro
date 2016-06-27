package com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.model.SectionItem;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 12/1/15.
 */
public class ViewHolderSection extends BaseViewHolder<SectionItem> {

    @BindView(R.id.sectionTitle)
    TLTextView mSectionTitle;

    public ViewHolderSection(View itemView) {
        super(itemView);
    }

    @Override
    public void configureItem(SectionItem item) {
        super.configureItem(item);
        mSectionTitle.setTextColor(itemView.getResources().getColor(R.color.tinkercolor));
        mSectionTitle.setText(item.getTitle());
    }
}
