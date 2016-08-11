package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.Font;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;

/**
 * Created by jorgesanmartin on 21/10/15.
 */
public class TLTextView extends TextView {

    private static final String TAG = TLTextView.class.toString();
    public static final int DEFAULT_TITLE_FONT = Font.REGULAR.getType();
    public static final int DEFAULT_SUBTITLE_FONT = Font.REGULAR.getType();
    public static final int DEFAULT_TITLE_SIZE = R.dimen.text_size_mediun;
    public static final int DEFAULT_SUBTITLE_SIZE = R.dimen.text_size_small;
    public static final int DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_UNDERLINE_COLOR = Color.TRANSPARENT;

    // Vars
    private int fontName;
    private String textToUnderline;
    private int underlineColor;
    private boolean itemSelected = false;
    private boolean styleMessage;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public TLTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public TLTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TLTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLTextView);
                setFontName(attributes.getInt(R.styleable.TLTextView_fontName, DEFAULT_TITLE_FONT));
                setUnderlineColor(attributes.getColor(R.styleable.TLTextView_underLineColor, DEFAULT_UNDERLINE_COLOR));
                setTextToUnderline(attributes.getString(R.styleable.TLTextView_underLineText));
                setStyleMessage(attributes.getBoolean(R.styleable.TLTextView_hasMessageStyle, false));
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

    public String getTextToUnderline() {
        return textToUnderline;
    }

    public void setTextToUnderline(String textToUnderline) {
        this.textToUnderline = textToUnderline;
        if (textToUnderline != null) {
            String colorUnderLine = "#" + Integer.toHexString(getUnderlineColor()).substring(2);
            String textToReplace = "<u><font color=\"" + colorUnderLine + "\">" + textToUnderline + "</font></u>";
            String text = getText().toString().replace(textToUnderline, textToReplace);
            setText(Html.fromHtml(text));
        }
    }

    public int getUnderlineColor() {
        return underlineColor;
    }

    public void setUnderlineColor(int underlineColor) {
        this.underlineColor = underlineColor;
    }

    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }

    public boolean isStyleMessage() {
        return styleMessage;
    }

    public void setStyleMessage(boolean styleMessage) {
        this.styleMessage = styleMessage;
        if (styleMessage) {
            setShadowLayer(4, 0, 0, getResources().getColor(R.color.black));
        }
    }

    public void paintTextWithColor(String word, int colorResource) {
        String text = getText().toString();
        int startIndex = text.indexOf(word);
        int endIndex = word.length();
        try {
            final SpannableString spannableString = new SpannableString(getText());
            ForegroundColorSpan color = new ForegroundColorSpan(getResources().getColor(colorResource));
            spannableString.setSpan(color, startIndex, startIndex + endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            // set text with spannable string
            setText(spannableString);
        } catch (Exception ex) {
        }
    }
}
