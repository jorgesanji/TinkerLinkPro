package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 30/5/16.
 */
public class TLStackButton extends RelativeLayout {

    private static final String TAG = TLStackButton.class.getName();

    // Variables
    private Drawable stackIcon;
    private String stackTitle;
    private String stackSubTitle;
    private int stackTitleFont;
    private int stackSubTitleFont;
    private int stackColorLine;
    private int stackTitleColor;
    private int stackSubTitleColor;

    // View
    @BindView(R.id.stackIcon)
    TLImageView stack_Icon;

    @BindView(R.id.stackLine)
    View stack_Line;

    @BindView(R.id.stackTitle)
    TLTextView stack_Title;

    @BindView(R.id.stackSubTitle)
    TLTextView stack_SubTitle;

    public TLStackButton(Context context) {
        this(context, null);
    }

    public TLStackButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLStackButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLStackButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_actionstack_button, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLStackButton);
                setStackIcon(attributes.getDrawable(R.styleable.TLStackButton_stackIcon));
                setStackTitle(attributes.getString(R.styleable.TLStackButton_stackTitle));
                setStackSubTitle(attributes.getString(R.styleable.TLStackButton_stackSubTitle));
                setStackSubTitleFont(attributes.getInt(R.styleable.TLStackButton_stackSubTitleFont, TLTextView.DEFAULT_FONT));
                setStackTitleFont(attributes.getInt(R.styleable.TLStackButton_stackTitleFont, TLTextView.DEFAULT_FONT));
                setStackTitleColor(attributes.getColor(R.styleable.TLStackButton_stackTitleColor, TLTextView.DEFAULT_COLOR));
                setStackSubTitleColor(attributes.getColor(R.styleable.TLStackButton_stackSubTitleColor, TLTextView.DEFAULT_COLOR));
                setStackColorLine((attributes.getColor(R.styleable.TLStackButton_stackLineColor, TLTextView.DEFAULT_COLOR)));
            } catch (Exception ex) {
                Log.e(TAG, ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    //Public methods

    public Drawable getStackIcon() {
        return stackIcon;
    }

    public void setStackIcon(Drawable stackIcon) {
        this.stackIcon = stackIcon;
        stack_Icon.setImageDrawable(stackIcon);
    }

    public String getStackTitle() {
        return stackTitle;
    }

    public void setStackTitle(String stackTitle) {
        this.stackTitle = stackTitle;
        stack_Title.setText(stackTitle);
    }

    public String getStackSubTitle() {
        return stackSubTitle;
    }

    public void setStackSubTitle(String stackSubTitle) {
        this.stackSubTitle = stackSubTitle;
        stack_SubTitle.setText(stackSubTitle);
    }

    public int getStackTitleFont() {
        return stackTitleFont;
    }

    public void setStackTitleFont(int stackTitleFont) {
        this.stackTitleFont = stackTitleFont;
        stack_Title.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), stackTitleFont));
    }

    public int getStackSubTitleFont() {
        return stackSubTitleFont;
    }

    public void setStackSubTitleFont(int stackSubTitleFont) {
        this.stackSubTitleFont = stackSubTitleFont;
        stack_SubTitle.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), stackSubTitleFont));
    }

    public int getStackSubTitleColor() {
        return stackSubTitleColor;
    }

    public void setStackSubTitleColor(int stackSubTitleColor) {
        this.stackSubTitleColor = stackSubTitleColor;
        stack_SubTitle.setTextColor(stackSubTitleColor);
    }

    public int getStackTitleColor() {
        return stackTitleColor;
    }

    public void setStackTitleColor(int stackTitleColor) {
        this.stackTitleColor = stackTitleColor;
        stack_Title.setTextColor(stackTitleColor);
    }

    public int getStackColorLine() {
        return stackColorLine;
    }

    public void setStackColorLine(int stackColorLine) {
        this.stackColorLine = stackColorLine;
        stack_Line.setBackgroundColor(stackColorLine);
    }
}
