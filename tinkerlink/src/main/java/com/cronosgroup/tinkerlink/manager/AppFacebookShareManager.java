package com.cronosgroup.tinkerlink.manager;

import android.app.Activity;
import android.content.Intent;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.application.TinkerLinkApplication;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.utils.LocaleUtils;

import javax.inject.Inject;

/**
 * Created by jorgesanmartin on 2/10/16.
 */
public class AppFacebookShareManager {

    private AppFacebookManager facebookManager;
    private Activity activity;

    @Inject
    AppConfigManager appConfigManager;

    public AppFacebookShareManager(Activity context) {
        this.activity = context;
        this.facebookManager = new AppFacebookManager(context);
        TinkerLinkApplication.getApp().getComponent().inject(this);
    }

    public Activity getActivity() {
        return activity;
    }

    public void sharePost(RestPost post, AppFacebookManager.IOFacebookCallBack callBack) {

        String urltoShare = getActivity().getString(R.string.fb_share_me);
        String description = getActivity().getString(R.string.tinkerlink_url);

        String imagetoShare = appConfigManager.getPath(AppConfigManager.Path.PATH_SHARE) + LocaleUtils.getCurrentLanguage() + "/";
        String title = "";

        switch (post.getTypePost()) {
            case RECOMMENDATION: //3
                imagetoShare += "photo3.png";
                title = String.format(getActivity().getString(R.string.share_text_recommendation), post.getUser().getUser().getName(), post.getContacto().getUser().getName());
                break;
            case TINKER://2
                imagetoShare += "photo2.png";
                title = String.format(getActivity().getString(R.string.share_text_help_linker), post.getUser().getUser().getName());
                break;
            case LINKER://1
                imagetoShare += "photo1.png";
                title = String.format(getActivity().getString(R.string.share_text_help_tinker), post.getUser().getUser().getName());
                break;

        }

        facebookManager.shareLink(getActivity(), title, description, imagetoShare, urltoShare, callBack);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return facebookManager.onActivityResult(requestCode, resultCode, data);
    }
}
