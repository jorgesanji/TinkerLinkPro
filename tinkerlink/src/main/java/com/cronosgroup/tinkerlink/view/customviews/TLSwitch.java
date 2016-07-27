package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Switch;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;

/**
 * Created by jorgesanmartin on 7/26/16.
 */
public class TLSwitch extends Switch {

    private static final String TAG = TLSwitch.class.toString();
    private static final int DEFAULT_FONT = 0;

    private int fontName;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLSwitch(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public TLSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public TLSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TLSwitch(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLSwitch);
                setFontName(attributes.getInt(R.styleable.TLSwitch_fontSwitchName, DEFAULT_FONT));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    // Public method

    public int getFontName() {
        return fontName;
    }

    public void setFontName(int fontName) {
        this.fontName = fontName;
        this.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), fontName));
    }
}
