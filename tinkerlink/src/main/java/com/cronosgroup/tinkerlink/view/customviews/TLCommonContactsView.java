package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
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
    protected TLImageRoundBorder mContact1;

    @BindView(R.id.contact2)
    protected TLImageRoundBorder mContact2;

    @BindView(R.id.contact3)
    protected TLImageRoundBorder mContact3;

    @BindView(R.id.contact4)
    protected TLImageRoundBorder mContact4;

    @BindView(R.id.numberContacts)
    protected TLTextView mNumberContacts;

    @BindView(R.id.containerCommon)
    protected RelativeLayout mcontainerCommon;

    @BindView(R.id.contactsContainer)
    protected RelativeLayout mContactsContainer;

    /**
     * @param context
     */
    public TLCommonContactsView(Context context) {
        super(context);
        init();
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
        super(context, attrs, defStyleAttr);
        init();
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
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_common_contacts, this);
        ButterKnife.bind(this);
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
                TLImageRoundBorder imageView = (TLImageRoundBorder) mContactsContainer.getChildAt(index);
                imageView.setImageFromUrl(contacto.getUser().getPhoto());
            }
        }
    }

}
