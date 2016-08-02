package com.cronosgroup.tinkerlink.view.cardfilter.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.StackCard;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 8/1/16.
 */
public class FilterViewHolder extends BaseViewHolder<RestCategoria> {

    // Vars

    private StackCard type;

    // Views
    @BindView(R.id.imageCategory)
    protected TLImageView mCategoryImage;

    @BindView(R.id.colorItemSelected)
    protected View mBackground;

    @BindView(R.id.numberCardsByCategory)
    protected TLTextView mNumberCardsCategory;

    @BindView(R.id.categoryName)
    protected TLTextView mCategoryName;

    public FilterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void configureItem(RestCategoria item) {
        super.configureItem(item);
        mCategoryName.setText(item.getCategoria());
        mNumberCardsCategory.setVisibility(item.isSelected() ? View.VISIBLE : View.GONE);
        mBackground.setBackgroundResource(item.isSelected() ? (type == StackCard.LINKER) ? R.color.linkercolor_50 : R.color.tinkercolor_50 : R.drawable.background_black_gradient);
    }

    public StackCard getType() {
        return type;
    }

    public void setType(StackCard type) {
        this.type = type;
    }
}
