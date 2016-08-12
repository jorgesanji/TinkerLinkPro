package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.utils.DimenUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 3/23/16.
 */
public class TLCommonContactsView extends RelativeLayout {

    //Vars

    //Properties

    private boolean showstatusContact;

    //Views

    @BindView(R.id.numberContacts)
    protected TLTextView mNumberContacts;

    @BindView(R.id.containerCommon)
    protected RelativeLayout mcontainerCommon;

    @BindView(R.id.contactsContainer)
    protected RelativeLayout mContactsContainer;

    @BindView(R.id.userStatusContact)
    protected TLImageView mUserStatusContact;

    /**
     * @param context
     */
    public TLCommonContactsView(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public TLCommonContactsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TLCommonContactsView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLCommonContactsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.lay_common_contacts, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLCommonContactsView);
                setShowstatusContact(attributes.getBoolean(R.styleable.TLCommonContactsView_showStatusContact, true));
            } catch (Exception ex) {
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    private void setParamsContainer(boolean wrContent) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(wrContent ? ViewGroup.LayoutParams.WRAP_CONTENT :DimenUtils.getIntPixelsFromDp(getContext(), 50), ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = isShowstatusContact() ? DimenUtils.getIntPixelsFromDp(getContext(), 100) : 0;
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        mcontainerCommon.setLayoutParams(params);
    }

    //Public methods

    public void setContacts(List<RestContacto> contacts) {
        if (!contacts.isEmpty()) {
            setParamsContainer(true);
            mContactsContainer.setVisibility(VISIBLE);
            mNumberContacts.setVisibility(VISIBLE);
            String numberContacts = contacts.size() > 4 ? "+" + String.valueOf(contacts.size() - 4) + " " : "";
            mNumberContacts.setText(numberContacts + getResources().getString(R.string.profile_contacts_common));

            int size = contacts.size() > 4 ? 4 : contacts.size();
            for (int index = 0; index < size; index++) {
                RestContacto contacto = contacts.get(index);
                TLImageView imageView = (TLImageView) mContactsContainer.getChildAt(index);
                imageView.setImageFromUrl(contacto.getUser().getPhoto());
            }
        }
    }

    public boolean isShowstatusContact() {
        return showstatusContact;
    }

    public void setShowstatusContact(boolean showstatusContact) {
        this.showstatusContact = showstatusContact;
        mUserStatusContact.setVisibility(showstatusContact ? VISIBLE : GONE);
        setParamsContainer(false);
    }
}
