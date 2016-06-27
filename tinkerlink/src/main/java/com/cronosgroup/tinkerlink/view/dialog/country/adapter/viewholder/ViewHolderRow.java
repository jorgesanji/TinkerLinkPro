package com.cronosgroup.tinkerlink.view.dialog.country.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ViewHolderRow extends BaseViewHolder {

    private AppCountryManager appCountryManager;

    @BindView(R.id.title_item_dialog)
    protected TLTextView mTitle;

    /**
     * @param view
     */
    public ViewHolderRow(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    // Public methods

    public void configureItem(RestCountry country) {
        mTitle.setText(appCountryManager.getCurrentNameFromLocale(country));
    }

    public AppCountryManager getAppCountryManager() {
        return appCountryManager;
    }

    public void setAppCountryManager(AppCountryManager appCountryManager) {
        this.appCountryManager = appCountryManager;
    }
}