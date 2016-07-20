package com.cronosgroup.tinkerlink.view.sign.adapter.fragments.facebook;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.cronosgroup.core.utils.BitmapUtils;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.business.model.AppUser;
import com.cronosgroup.tinkerlink.utils.TLDateTextWatcher;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class FacebookScreen extends RelativeLayout {

    /**
     * listeners of the Facebook's screen.
     */

    public interface Listener {
        void onUsePolicyPressed();

        void onFacebookPressed();

        void onGalleryPressed();

        void onCameraPressed();

        void onMalePressed();

        void onWomenPressed();
    }

    //Variables
    Listener listener;

    //Views
    @BindView(R.id.loginEmail)
    TLEditText mLoginEmail;

    @BindView(R.id.loginName)
    TLEditText mLoginName;

    @BindView(R.id.loginBirthDate)
    TLEditText mLoginBirth;

    @BindView(R.id.imageProfile)
    TLImageView mProfileImage;

    @BindView(R.id.loginFemale)
    TLButton mLoginFemale;

    @BindView(R.id.loginMale)
    TLButton mLoginMale;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    /**
     * @param context
     */
    public FacebookScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public FacebookScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FacebookScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FacebookScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_sign_facebook, this);
        ButterKnife.bind(this);
        mLoginBirth.addTextChangedListener(new TLDateTextWatcher(mLoginBirth));
    }

    private void cleanForm() {
        mLoginBirth.setError(null);
        mLoginEmail.setError(null);
        mLoginName.setError(null);
        mLoginMale.setSelected(false);
        mLoginFemale.setSelected(false);
        mProfileImage.setImageBitmap(null);
        mLoginBirth.setText(null);
        mLoginEmail.setText(null);
        mLoginName.setText(null);
    }

    // Actions view

    @OnClick(R.id.login_with_facebook_button)
    protected void faceBookLogin() {
        listener.onFacebookPressed();
    }

    @OnClick(R.id.loginMale)
    protected void onMalePressed() {
        mLoginMale.setSelected(true);
        mLoginFemale.setSelected(false);
        listener.onMalePressed();
    }

    @OnClick(R.id.loginFemale)
    protected void onFeMalePressed() {
        mLoginMale.setSelected(false);
        mLoginFemale.setSelected(true);
        listener.onWomenPressed();
    }

    @OnClick(R.id.usePolicy)
    protected void onUsePolicyPressed() {
        listener.onUsePolicyPressed();
    }

    @OnClick(R.id.imageProfile)
    protected void onImageProfileSelected() {
        PopupMenu popup = new PopupMenu(getContext(), mProfileImage);
        popup.getMenuInflater().inflate(R.menu.popup_profile_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_camera:
                        listener.onCameraPressed();
                        break;
                    case R.id.action_gallery:
                        listener.onGalleryPressed();
                        break;
                }
                return true;
            }
        });

        popup.show();
    }

    //Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void changeProfileImage(Bitmap bitmap) {
        mProfileImage.setAlpha(0.0f);
        mProfileImage.setImageBitmap(BitmapUtils.getCircularBitmap(bitmap));
        mProgressBar.setVisibility(GONE);
        mProfileImage.animate().alpha(1.0f).start();
    }

    public void fillUserForm(AppUser user) {
        if (user != null) {
            mLoginEmail.setText(user.getEmail());
            mLoginName.setText(user.getName());
            mLoginBirth.setText(user.getBirthday());
            if (user.isMale()) {
                mLoginMale.setSelected(true);
            } else {
                mLoginFemale.setSelected(true);
            }

            if (user.getCropBitmageBase64() != null) {
                Bitmap userImage = BitmapUtils.getCircularBitmap(BitmapUtils.decodeBase64(user.getCropBitmageBase64()));
                mProfileImage.setImageBitmap(userImage);
            } else {
                ImageLoader.getInstance().displayImage(user.getImageUrl(), mProfileImage, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        mProgressBar.setVisibility(VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        changeProfileImage(loadedImage);
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {
                    }
                });
            }
        }
    }

    public String getEmail() {
        return mLoginEmail.getText().toString();
    }

    public String getName() {
        return mLoginName.getText().toString();
    }

    public String getBirthDate() {
        return mLoginBirth.getText().toString();
    }

    public String getGender() {
        return (mLoginFemale.isSelected() || mLoginMale.isSelected()) ? mLoginFemale.isSelected() ? AppUser.FEMALE : AppUser.MALE : null;
    }
}
