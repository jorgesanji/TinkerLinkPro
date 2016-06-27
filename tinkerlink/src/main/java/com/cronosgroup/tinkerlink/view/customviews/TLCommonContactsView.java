package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;

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
    TLImageView mContact1;

    @BindView(R.id.contact2)
    TLImageView mContact2;

    @BindView(R.id.contact3)
    TLImageView mContact3;

    @BindView(R.id.contact4)
    TLImageView mContact4;

    @BindView(R.id.numberContacts)
    TLTextView mNumberContacts;

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
        mContact1.setVisibility(GONE);
        mContact2.setVisibility(GONE);
        mContact3.setVisibility(GONE);
        mContact4.setVisibility(GONE);
        mContact1.setRounded(true);
        mContact2.setRounded(true);
        mContact3.setRounded(true);
        mContact4.setRounded(true);
    }

    //Public methods

    public void setContacts(List<RestContacto> contacts,
                            AppConfigManager appConfigManager) {
        mNumberContacts.setText(String.valueOf(contacts.size()));
        RelativeLayout layout = (RelativeLayout) mContact1.getParent();
        int size = contacts.size() > 4 ? 4 : contacts.size();
        for (int index = 0; index < size; index++) {
            RestContacto contacto = contacts.get(index);
            TLImageView imageView = (TLImageView) layout.getChildAt(index);
            imageView.setVisibility(VISIBLE);
            imageView.setImageFromUrl(appConfigManager.getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + contacto.getUser().getPhoto());
        }
    }
}
