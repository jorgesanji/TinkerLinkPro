package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.utils.TypeFaceUtils;
import com.cronosgroup.tinkerlink.view.interfaces.IOAddContactListener;
import com.cronosgroup.tinkerlink.view.interfaces.IOIconListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 11/11/15.
 */
public class TLUserView extends LinearLayout {

    //Vars
    private SpannableString userTitle;
    private String userSubTitle;
    private String userUrl;
    private int iconCard;
    private IOIconListener listener;
    private IOAddContactListener addContactListener;

    //Views
    @BindView(R.id.userImage)
    TLImageView mUserImage;

    @BindView(R.id.cardBadge)
    TLImageView mCardBadge;

    @BindView(R.id.userName)
    TLTextView mUserTitle;

    @BindView(R.id.userStatusContact)
    TLTabItem mUserStatusContact;

    @BindView(R.id.userDescription)
    TLTextView mUserSubTitle;

    /**
     * @param context
     */
    public TLUserView(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLUserView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLUserView(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public TLUserView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_user_item, this);
        ButterKnife.bind(this);
        mUserImage.setRounded(true);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLUserView);
                setTitle(attributes.getString(R.styleable.TLUserView_userTitle));
                setTitleColor(attributes.getColor(R.styleable.TLUserView_userTitleColor, Color.BLACK));
                setTitleFont(attributes.getInt(R.styleable.TLUserView_userTitleFont, TLTextView.DEFAULT_FONT));
                setTitleSize(attributes.getDimensionPixelSize(R.styleable.TLUserView_userTitleSize, TLTextView.DEFAULT_SIZE));
                setSubTitle(attributes.getString(R.styleable.TLUserView_userSubTitle));
                setSubTitleColor(attributes.getColor(R.styleable.TLUserView_userSubTitleColor, Color.BLACK));
                setSubTitleFont(attributes.getInt(R.styleable.TLUserView_userSubTitleFont, TLTextView.DEFAULT_FONT));
                setSubTitleSize(attributes.getDimensionPixelSize(R.styleable.TLUserView_userSubTitleSize, TLTextView.DEFAULT_SIZE));
                setUserIcon(attributes.getResourceId(R.styleable.TLUserView_userIcon, R.mipmap.newsfeed_avatar_hombre));
            } catch (Exception ex) {
                Log.e("", ex.getMessage(), ex);
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    @OnClick(R.id.userImage)
    protected void onUserPressed() {
        if (getListener() != null) {
            getListener().onIconPressed();
        }
    }

    @OnClick(R.id.userName)
    protected void onTitlePressed() {
        if (getListener() != null) {
            getListener().onIconPressed();
        }
    }

    //Public methods

    public void setUserIcon(int icon) {
        mUserImage.setImageResource(icon);
    }

    public void setTitle(String title) {
        mUserTitle.setText(title);
    }

    public void setTitleFont(int font) {
        mUserTitle.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), font));
    }

    public void setTitleSize(float size) {
        mUserTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setTitleColor(int color) {
        mUserTitle.setTextColor(color);
    }

    public String getSubTitle() {
        return mUserSubTitle.getText().toString();
    }

    public void setSubTitle(String subTitle) {
        if (subTitle != null) {
            mUserSubTitle.setText(subTitle);
        } else {
            mUserSubTitle.setVisibility(GONE);
        }
    }

    public String getSubTitlehint() {
        return mUserSubTitle.getText().toString();
    }

    public void setSubTitlehint(String subTitlehint) {
        mUserSubTitle.setHint(subTitlehint);
    }

    public void setSubTitleFont(int font) {
        mUserSubTitle.setTypeface(TypeFaceUtils.getFontWithFlag(getContext(), font));
    }

    public void setSubTitleSize(float size) {
        mUserSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setSubTitleColor(int color) {
        mUserSubTitle.setTextColor(color);
    }

    public SpannableString getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(SpannableString userTitle) {
        this.userTitle = userTitle;
        mUserTitle.setText(userTitle);
    }

    public void setUserTitle(String userTitle) {
        mUserTitle.setText(userTitle);
    }

    public String getUserSubTitle() {
        return userSubTitle;
    }

    public void setUserSubTitle(String userSubTitle) {
        this.userSubTitle = userSubTitle;
        mUserSubTitle.setText(userSubTitle);
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserImageFromUrl(String userUrl) {
        this.userUrl = userUrl;
        mUserImage.setImageFromUrl(userUrl, TLImageView.ImageType.USER);
    }

    public IOIconListener getListener() {
        return listener;
    }

    public void setListener(IOIconListener listener) {
        this.listener = listener;
    }

    public IOAddContactListener getAddContactListener() {
        return addContactListener;
    }

    public void setAddContactListener(IOAddContactListener addContactListener) {
        this.addContactListener = addContactListener;
        if (addContactListener != null) {
            mUserStatusContact.setVisibility(VISIBLE);
            mUserStatusContact.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAddContactListener() != null) {
                        getAddContactListener().AddContact();
                    }
                }
            });
        }
    }

    public void setStatus(RestContacto contacto) {
        if (!contacto.getUser().isMe()) {
            mUserStatusContact.setItemFromStatus(contacto);
        } else {
            mUserStatusContact.setVisibility(GONE);
        }
    }

    public void hideIcon(boolean hide) {
        mUserImage.setVisibility(hide ? GONE : VISIBLE);
    }

    public int getIconCard() {
        return iconCard;
    }

    public void setIconCard(int iconCard) {
        this.iconCard = iconCard;
        mCardBadge.setImageResource(iconCard);
    }
}
