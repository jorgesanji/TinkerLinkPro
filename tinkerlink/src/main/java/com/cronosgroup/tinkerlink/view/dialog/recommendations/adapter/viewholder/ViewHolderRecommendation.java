package com.cronosgroup.tinkerlink.view.dialog.recommendations.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class ViewHolderRecommendation extends BaseViewHolder {

    @BindView(R.id.recUserImage)
    protected TLImageView mUserImage;

    @BindView(R.id.recTitle)
    protected TLTextView mTitle;

    @BindView(R.id.recSubTitle)
    protected TLTextView mSubTitle;

    /**
     * @param view
     */
    public ViewHolderRecommendation(View view) {
        super(view);
        mUserImage.setRounded(true);
    }

    // Public methods

    public void configureItem(RestRecomendacion recomendacion) {
//        String urlUserImage = TinkerLinkApplication.getApp().getImagePath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + recomendacion.getUser().getUser().getPhoto();
//        mUserImage.setImageFromUrl(urlUserImage);
        mTitle.setText(recomendacion.getUser().getUser().getName());
        mSubTitle.setText(recomendacion.getRecomendacion());
    }
}