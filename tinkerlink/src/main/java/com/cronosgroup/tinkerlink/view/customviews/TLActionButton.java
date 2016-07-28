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
public class TLActionButton extends RelativeLayout {

    private static final String TAG = TLActionButton.class.getName();

    // Variables
    private Drawable actionIcon;
    private String actionTitle;
    private int actionTitleFont;
    private boolean actionStatus;

    // View
    @BindView(R.id.ic_action)
    TLImageView iconAction;

    @BindView(R.id.badge_action)
    View badge_action;

    @BindView(R.id.title_action)
    TLTextView title_action;

    public TLActionButton(Context context) {
        this(context, null);
    }

    public TLActionButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_action_menu_button, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLActionButton);
                setActionIcon(attributes.getDrawable(R.styleable.TLActionButton_actionIcon));
                setActionTitle(attributes.getString(R.styleable.TLActionButton_actionTitle));
                setActionTitleFont(attributes.getInt(R.styleable.TLActionButton_actionTitleFont, TLTextView.DEFAULT_FONT));
                setActionStatus(attributes.getBoolean(R.styleable.TLActionButton_actionUpdateStatus, false));
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

    public boolean isActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(boolean actionStatus) {
        this.actionStatus = actionStatus;
        badge_action.setVisibility(actionStatus ? VISIBLE : GONE);
    }

    public Drawable getActionIcon() {
        return actionIcon;
    }

    public void setActionIcon(Drawable actionIcon) {
        this.actionIcon = actionIcon;
        iconAction.setImageDrawable(actionIcon);
    }

    public String getActionTitle() {
        return actionTitle;
    }

    public void setActionTitle(String actionTitle) {
        this.actionTitle = actionTitle;
        title_action.setText(actionTitle);
    }

    public int getActionTitleFont() {
        return actionTitleFont;
    }

    public void setActionTitleFont(int actionTitleFont) {
        this.actionTitleFont = actionTitleFont;
        title_action.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), actionTitleFont));
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        title_action.setFontName(selected ? TLTextView.Font.BOLD.getType() : TLTextView.Font.REGULAR.getType());
        iconAction.setSelected(selected);
    }
}
