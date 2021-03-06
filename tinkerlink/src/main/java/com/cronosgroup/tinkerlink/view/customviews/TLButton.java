package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;

/**
 * Created by jorgesanmartin on 10/23/15.
 */
public class TLButton extends Button {

    private static final String TAG = TLButton.class.toString();

    private int fontName;

    /**
     * @param context
     */
    public TLButton(Context context) {
        super(context);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLButton);
                setFontName(attributes.getInt(R.styleable.TLButton_fontNameButton, TLTextView.DEFAULT_FONT));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    // Public methods

    public int getFontName() {
        return fontName;
    }

    public void setFontName(int fontName) {
        this.fontName = fontName;
        this.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), fontName));
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            setTextColor(getResources().getColor(R.color.white));
        } else {
            setTextColor(getResources().getColor(R.color.black_opaque));
        }
    }
}
