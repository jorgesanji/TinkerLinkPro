package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 3/8/16.
 */
public class TLMenuItem extends TLBaseView {

    //Vars
    public static final int DEFAULT_FONT = 0;
    public static final int DEFAULT_SIZE = 12;

    //Views
    @BindView(R.id.itemButton)
    FloatingActionButton mItemButton;

    @BindView(R.id.itemTitle)
    TLTextView mItemTitle;

    /**
     * @param context
     */
    public TLMenuItem(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLMenuItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLMenuItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLMenuItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_item_menu;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MenuItem);
                setMenuItemTitle(attributes.getString(R.styleable.MenuItem_menuItemTitle));
                setMenuItemImage(attributes.getDrawable(R.styleable.MenuItem_menuItemImageResource));
                setMenuItemBackgroundTintColor(attributes.getColor(R.styleable.MenuItem_menuItemBackgroundTintColor, Color.BLACK));
                setMenuItemFontName(attributes.getInt(R.styleable.MenuItem_menuItemTitleFont, DEFAULT_FONT));
                setMenuItemTitleColor(attributes.getColor(R.styleable.MenuItem_menuItemTitleColor, Color.BLACK));
                setMenutItemTitlesize(attributes.getDimensionPixelSize(R.styleable.MenuItem_menuItemTitleSize, DEFAULT_SIZE));
            } catch (Exception ex) {
                Log.e(TLMenuItem.class.getName(), ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    //Public methods

    public void setMenuItemTitle(String title) {
        mItemTitle.setText(title);
    }

    public void setMenuItemImage(Drawable drawable) {
        mItemButton.setImageDrawable(drawable);
    }

    public void setMenuItemBackgroundTintColor(int tintColor) {
        mItemButton.setBackgroundTintList(ColorStateList.valueOf(tintColor));
    }

    public void setMenuItemFontName(int fontName) {
        mItemTitle.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), fontName));
    }

    public void setMenuItemTitleColor(int titleColor) {
        mItemTitle.setTextColor(titleColor);
    }

    public void setMenutItemTitlesize(float titlesize) {
        mItemTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titlesize);
    }
}
