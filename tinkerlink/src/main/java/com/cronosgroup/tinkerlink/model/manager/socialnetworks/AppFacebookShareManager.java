package com.cronosgroup.tinkerlink.model.manager.socialnetworks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.manager.socialnetworks.interfaces.IOSocialNetWorkCallBack;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

/**
 * Created by jorgesanmartin on 2/10/16.
 */
public class AppFacebookShareManager {

    private Activity activity;
    private CallbackManager callbackManager = CallbackManager.Factory.create();

    public AppFacebookShareManager(Activity context) {
        this.activity = context;
    }

    public Activity getActivity() {
        return activity;
    }

    private void makeRequestShare(ShareDialog shareDialog, final IOSocialNetWorkCallBack callBack) {

        if (shareDialog != null && callBack != null) {
            shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                @Override
                public void onSuccess(Sharer.Result result) {
                    if (callBack != null) {
                        callBack.onResponse(result);
                    }
                }

                @Override
                public void onCancel() {
                    if (callBack != null) {
                        callBack.onError(null);
                    }
                }

                @Override
                public void onError(FacebookException error) {
                    if (callBack != null) {
                        callBack.onError(null);
                    }
                }
            });
        }
    }

    private void shareLink(Activity context, String title, String description, String urlImage, String urlShare, IOSocialNetWorkCallBack callBack) {

        if (ShareDialog.canShow(ShareLinkContent.class)) {

            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle(title)
                    .setContentDescription(
                            description)
                    .setContentUrl(Uri.parse(urlShare))
                    .setImageUrl(Uri.parse(urlImage))
                    .build();
            ShareDialog shareDialog = new ShareDialog(context);
            shareDialog.show(linkContent);

            makeRequestShare(shareDialog, callBack);
        }
    }

    public void sharePost(RestPost post, IOSocialNetWorkCallBack callBack) {

        String urltoShare = getActivity().getString(R.string.fb_share_me);
        String description = getActivity().getString(R.string.tinkerlink_url);

        String imagetoShare = "";
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

        shareLink(getActivity(), title, description, imagetoShare, urltoShare, callBack);
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return onActivityResult(requestCode, resultCode, data);
    }
}
