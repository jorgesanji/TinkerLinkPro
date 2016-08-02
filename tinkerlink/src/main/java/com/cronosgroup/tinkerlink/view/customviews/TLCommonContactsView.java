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

    //Views
    @BindView(R.id.contact1)
    protected TLImageView mContact1;

    @BindView(R.id.contact2)
    protected TLImageView mContact2;

    @BindView(R.id.contact3)
    protected TLImageView mContact3;

    @BindView(R.id.contact4)
    protected TLImageView mContact4;

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
                showStatusContact(attributes.getBoolean(R.styleable.TLCommonContactsView_showStatusContact, true));
            } catch (Exception ex) {
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        }
    }

    //Public methods

    public void setContacts(List<RestContacto> contacts) {
        if (!contacts.isEmpty()) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = Math.round(DimenUtils.getPixelsFromDp(getContext(), 50));
            mcontainerCommon.setLayoutParams(params);

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

    public void showStatusContact(boolean showstatus) {
        mUserStatusContact.setVisibility(showstatus ? VISIBLE : GONE);
    }

}
