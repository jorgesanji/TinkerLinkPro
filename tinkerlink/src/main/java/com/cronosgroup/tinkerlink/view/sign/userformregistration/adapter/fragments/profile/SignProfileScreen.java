package com.cronosgroup.tinkerlink.view.sign.userformregistration.adapter.fragments.profile;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/28/15.
 */
public class SignProfileScreen extends TLBaseView {

    public static final int IMAGE_WALL = 0;
    public static final int IMAGE_PROFILE = 1;


    public interface Listener {
        void onOccupationPressed();

        void onAddPressed();

        void onGalleryPressed(int type);

        void onCameraPressed(int type);
    }

    //Variables
    private Listener listener;

    //Views
    @BindView(R.id.profileUserImage)
    protected TLImageButton mProfileUserImage;

    @BindView(R.id.profileUserWallImage)
    protected TLImageButton mProfileUserWallImage;

    /**
     * @param context
     */
    public SignProfileScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public SignProfileScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SignProfileScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SignProfileScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_sign_profile;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    private void launchPopup(final int type, View anchor) {
        PopupMenu popup = new PopupMenu(getContext(), anchor);
        popup.getMenuInflater().inflate(R.menu.camera_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_camera:
                        listener.onCameraPressed(type);
                        break;
                    case R.id.action_gallery:
                        listener.onGalleryPressed(type);
                        break;
                }
                return true;
            }
        });
        popup.show();
    }

    // Actions

    @OnClick(R.id.selectOccupation)
    protected void occupationPressed() {
        listener.onOccupationPressed();
    }

    @OnClick(R.id.addStudyOrCourse)
    protected void addPressed() {
        listener.onAddPressed();
    }

    @OnClick(R.id.profileUserWallImage)
    protected void profileUserWallImagePressed() {
        launchPopup(IMAGE_WALL, mProfileUserWallImage);
    }

    @OnClick(R.id.profileUserImage)
    protected void profileUserImagePressed() {
        launchPopup(IMAGE_PROFILE, mProfileUserImage);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


}
