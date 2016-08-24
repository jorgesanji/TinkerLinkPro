package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;

import butterknife.BindView;

/**
 * Created by jorgesanmartin on 11/23/15.
 */
public class TLTabItem extends TLBaseView {

    // Vars
    private Drawable icon;
    private String text;

    // Views
    @BindView(R.id.iconTabItem)
    TLImageView mIconTabItem;

    @BindView(R.id.titleTabItem)
    TLTextView mTitleTabItem;

    /**
     * @param context
     */
    public TLTabItem(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLTabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLTabItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void init(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.button_default_states);
        super.init(attributeSet);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_info_field;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLTabItem);
                setIcon(attributes.getDrawable(R.styleable.TLTabItem_iconItem));
                setText(attributes.getString(R.styleable.TLTabItem_textItem));
                setTextColor(attributes.getColor(R.styleable.TLTabItem_textItemColor, Color.BLACK));
                setTextFont(attributes.getInt(R.styleable.TLTabItem_textItemFont, TLTextView.DEFAULT_TITLE_FONT));
                setTextSize(attributes.getDimensionPixelSize(R.styleable.TLTabItem_textItemSize, TLTextView.DEFAULT_TITLE_SIZE));
            } catch (Exception ex) {
                Log.e("", ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    // Public methods

    public String getText() {
        return text;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
        mIconTabItem.setImageDrawable(icon);
    }

    public void setTextSize(float titlesize) {
        mTitleTabItem.setTextSize(TypedValue.COMPLEX_UNIT_PX, titlesize);
    }

    public void setText(String text) {
        this.text = text;
        mTitleTabItem.setText(text);
    }

    public void setTextColor(int color) {
        mTitleTabItem.setTextColor(color);
    }

    public void setTextFont(int fontName) {
        mTitleTabItem.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), fontName));
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        mTitleTabItem.setSelected(selected);
    }

    public void scaleAnimation() {
        clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_button);
        mIconTabItem.setAnimation(animation);
    }

    public void setItemFromStatus(RestContact contacto) {
        if (!contacto.getUser().isMe()) {
            if (contacto.isAccepted()) {
                setText(getContext().getString(R.string.profile_friends));
                setIcon(getContext().getResources().getDrawable(R.mipmap.ic_contact));
            } else if (contacto.meRequestedLikeContact()) {
                setText(getContext().getString(R.string.profile_request_sent));
                setIcon(getContext().getResources().getDrawable(R.mipmap.ic_contact_sent));
            } else if (contacto.wasRequestedToMeLikeContact()) {
                setText(getContext().getString(R.string.profile_request_received));
                setIcon(getContext().getResources().getDrawable(R.mipmap.ic_contact_accept));
            } else {
                setText(getContext().getString(R.string.profile_send_request));
                setIcon(getContext().getResources().getDrawable(R.mipmap.ic_contact_add));
            }
        }
    }
}
