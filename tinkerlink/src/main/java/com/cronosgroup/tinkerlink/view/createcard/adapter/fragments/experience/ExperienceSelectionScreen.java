package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.experience;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class ExperienceSelectionScreen extends TLBaseView {

    public interface Listener {

    }

    // Vars
    private Listener listener;

    public ExperienceSelectionScreen(Context context) {
        super(context);
    }

    public ExperienceSelectionScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExperienceSelectionScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExperienceSelectionScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return  R.layout.lay_experience_selection;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
