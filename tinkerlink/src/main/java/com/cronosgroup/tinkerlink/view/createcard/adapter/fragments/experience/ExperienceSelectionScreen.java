package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.experience;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class ExperienceSelectionScreen extends LinearLayout {

    public interface Listener {

    }

    // Vars
    private Listener listener;

    public ExperienceSelectionScreen(Context context) {
        this(context, null);
    }

    public ExperienceSelectionScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExperienceSelectionScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExperienceSelectionScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.lay_experience_selection, this);
        ButterKnife.bind(this);

    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
