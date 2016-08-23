package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.enums.Font;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 30/5/16.
 */
public class TLActionButton extends TLBaseView {

    private static final String TAG = TLActionButton.class.getName();

    // Variables
    private Drawable actionIcon;
    private String actionTitle;
    private boolean actionStatus;

    // View
    @BindView(R.id.ic_action)
    protected TLImageView iconAction;

    @BindView(R.id.badge_action)
    protected View badge_action;

    @BindView(R.id.title_action)
    protected TLTextView title_action;

    public TLActionButton(Context context) {
        super(context);
    }

    public TLActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLActionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_action_menu_button;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLActionButton);
                setActionIcon(attributes.getDrawable(R.styleable.TLActionButton_actionIcon));
                setActionTitle(attributes.getString(R.styleable.TLActionButton_actionTitle));
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

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        title_action.setFontName(selected ? Font.SEMIBOLD.getType() : Font.LIGTH.getType());
        title_action.setTextColor(selected ? getResources().getColor(R.color.tinkercolor) : getResources().getColor(R.color.text_black_gray));
        iconAction.setSelected(selected);
    }
}
