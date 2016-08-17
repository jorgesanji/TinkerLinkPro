package com.cronosgroup.tinkerlink.view.customviews.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by jorgesanmartin on 8/5/16.
 */
public class TLCardFrameLayout extends FrameLayout {

    public TLCardFrameLayout(Context context) {
        this(context, null);
    }

    public TLCardFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLCardFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setClipChildren(false);
        setClipToPadding(false);
    }

    //this is so that on versions of android pre lollipop it will render the cardstack above
    //everything else within the layout
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        ViewGroup.LayoutParams params = getLayoutParams();

        ArrayList<View> children = new ArrayList<>();
        View swipeDeck = null;
        for (int i = 0; i < childCount; ++i) {
            View child = getChildAt(i);
            if (child instanceof TLCardStack) {
                swipeDeck = getChildAt(i);
            } else {
                children.add(child);
            }
        }
        removeAllViews();
        removeAllViewsInLayout();
        for (View v : children) {
            addViewInLayout(v, -1, v.getLayoutParams(), true);
        }
        if (swipeDeck != null) {
            addViewInLayout(swipeDeck, -1, swipeDeck.getLayoutParams(), true);
        }
        invalidate();
        requestLayout();
    }
}
