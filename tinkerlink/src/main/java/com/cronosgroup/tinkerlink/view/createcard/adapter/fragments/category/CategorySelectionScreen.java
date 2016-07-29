package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class CategorySelectionScreen extends LinearLayout {

    public interface Listener {
        void onSelectGeoPositionPressed();
    }

    // Vars
    private Listener listener;

    // Views

    public CategorySelectionScreen(Context context) {
        this(context, null);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CategorySelectionScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.lay_categories_selection, this);
        ButterKnife.bind(this);
    }

    // Actions
    @OnClick(R.id.selectGeoPosition)
    protected void selectGeoPositionPressed() {
        listener.onSelectGeoPositionPressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}
