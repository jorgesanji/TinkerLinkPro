package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.DimenUtils;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/8/16.
 */
public class TLMenuButton extends TLBaseView {

    public interface IOMenuButtonState {
        void collapsed();

        void expanded();
    }

    private static final String TRANSLATION_Y = "translationY";
    private static final String ALPHA = "alpha";
    private static final int ROTATION_DEGREES = 360;
    private static final int DEFAULT_SIZE_BUTTON = 60;

    //Vars
    private boolean expanded = true;
    private List<Float> mPositions = new ArrayList<>();
    private int mBackgroundResource;
    private Drawable mIcon;
    private Drawable mIconExpanded;
    private IOMenuButtonState listener;

    //Views
    private TLImageButton mMenuButton;

    /**
     * @param context
     */
    public TLMenuButton(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLMenuButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLMenuButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLMenuButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_menu_button;
    }

    @Override
    protected void init(AttributeSet attrs) {
        setOrientation(VERTICAL);
        setGravity(Gravity.RIGHT);
        super.init(attrs);
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();

        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLMenuButton);
                setMenuButtonImage(attributes.getDrawable(R.styleable.TLMenuButton_menuButtonImageResource));
                setMenuButtonExpandedImage(attributes.getDrawable(R.styleable.TLMenuButton_menuButtonStateExpandedImageResource));
                setMenuButtonBackgroundResource(attributes.getResourceId(R.styleable.TLMenuButton_menuButtonBackgroundResource, R.drawable.background_black_gradient));
                setExpanded(attributes.getBoolean(R.styleable.TLMenuButton_menuButtonExpanded, true));
            } catch (Exception ex) {
                Log.e(TLMenuItem.class.getName(), ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    private void initUI() {
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        animateMenu();
    }

    private void configMainButton() {
        int size = DimenUtils.getIntPixelsFromDp(getContext(), DEFAULT_SIZE_BUTTON);
        LinearLayout.LayoutParams params = new LayoutParams(size, size);
        mMenuButton = new TLImageButton(getContext());
        mMenuButton.setLayoutParams(params);
        mMenuButton.setBackgroundResource(mBackgroundResource);
        mMenuButton.setImageDrawable(mIcon);
        addView(mMenuButton);
        mMenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                expanded = !expanded;
                requestLayout();
            }
        });
    }

    private synchronized void animateFab() {
        Drawable drawable = mMenuButton.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        mMenuButton.animate().rotation(expanded ? ROTATION_DEGREES : 0).start();
    }

    private synchronized void animateMenu() {
        mMenuButton.setImageDrawable(expanded ? mIconExpanded : mIcon);
        boolean isPositionsFilled = mPositions.size() > 0;
        List<Animator> list = new ArrayList<>();
        int indexButtonIn = 0;
        for (int index = 0; index < getChildCount(); index++) {
            View view = getChildAt(index);
            if (view != mMenuButton && view instanceof TLMenuItem) {
                view.setEnabled(expanded);
                float posTransitionY = mMenuButton.getY() - view.getY();
                if (isPositionsFilled) {
                    posTransitionY = mPositions.get(indexButtonIn).floatValue();
                } else {
                    mPositions.add(Float.valueOf(posTransitionY));
                }
                list.add(!expanded ? createCollapseAnimator(view, posTransitionY) : createExpandAnimator(view, posTransitionY));
                indexButtonIn++;
            }
        }

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(list);
        animatorSet.start();
        animateFab();

        if (isPositionsFilled) {
            mPositions.clear();
        }

        if (getListener() != null) {
            if (expanded) {
                getListener().expanded();
            } else {
                getListener().collapsed();
            }
        }
    }

    private synchronized Animator animateItem(View view, float offset) {
        PropertyValuesHolder position = PropertyValuesHolder.ofFloat(TRANSLATION_Y, (!expanded) ? 0 : offset, (!expanded) ? offset : 0);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(ALPHA, (!expanded) ? 0 : 1);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, position, alpha);
        animator.setDuration(getResources().getInteger(android.R.integer.config_mediumAnimTime));
        return animator;
    }

    private Animator createCollapseAnimator(View view, float offset) {
        return animateItem(view, offset);
    }

    private Animator createExpandAnimator(View view, float offset) {
        return animateItem(view, offset);
    }

    @Override
    public void removeView(View view) {
        if (view != null) {
            super.removeView(view);
        }
    }

    @Override
    public void addView(View child, int width, int height) {
        this.removeView(mMenuButton);
        super.addView(child, width, height);
        configMainButton();
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        this.removeView(mMenuButton);
        super.addView(child, params);
        configMainButton();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        this.removeView(mMenuButton);
        super.addView(child, index, params);
    }

    //Public methods

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public void setMenuButtonBackgroundResource(int menuButtonBackgroundResource) {
        mBackgroundResource = menuButtonBackgroundResource;
        if (mMenuButton != null) {
            mMenuButton.setBackgroundResource(menuButtonBackgroundResource);
        }
    }

    public void setMenuButtonExpandedImage(Drawable drawable) {
        mIconExpanded = drawable;
    }

    public void setMenuButtonImage(Drawable drawable) {
        mIcon = drawable;
        if (mMenuButton != null) {
            mMenuButton.setImageDrawable(mIcon);
        }
    }

    public void collapseMenu() {
        if (expanded) {
            expanded = false;
            animateMenu();
        }
    }

    public void expandMenu() {
        if (!expanded) {
            expanded = true;
            animateMenu();
        }
    }

    public IOMenuButtonState getListener() {
        return listener;
    }

    public void setListener(IOMenuButtonState listener) {
        this.listener = listener;
    }
}
