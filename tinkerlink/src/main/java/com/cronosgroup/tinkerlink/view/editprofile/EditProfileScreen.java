package com.cronosgroup.tinkerlink.view.editprofile;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main EditProfile view.
 */
public class EditProfileScreen extends RelativeLayout {

    public interface Listener {
        void onAddCoursePressed();
    }

    // Vars
    private Listener listener;

    // Views

    /**
     * @param context
     */
    public EditProfileScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public EditProfileScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public EditProfileScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditProfileScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_edit_profile, this);
        ButterKnife.bind(this);
    }

    // Actions

    @OnClick(R.id.addStudyOrCourse)
    protected void addCoursePressed() {
        listener.onAddCoursePressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}