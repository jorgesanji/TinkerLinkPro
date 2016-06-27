package com.cronosgroup.tinkerlink.view.dialog.places.adapter.viewholder;

import android.location.Address;
import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.dialog.places.adapter.PlaceAutoCompleteAdapter;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ViewHolderPlace extends BaseViewHolder {

    @BindView(R.id.title_item_dialog)
    protected TLTextView mTitle;

    /**
     * @param view
     */
    public ViewHolderPlace(View view) {
        super(view);
    }

    // Public methods

    public void configureItem(Address address) {
        mTitle.setText(PlaceAutoCompleteAdapter.addFormattAddres(address));
    }

}