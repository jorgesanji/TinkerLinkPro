package com.cronosgroup.tinkerlink.view.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 7/27/16.
 */
public class TLUserContactView extends LinearLayout {

    public enum ContactsType {
        EMAIL(0, R.string.contacts_undo, R.mipmap.nav_mensajes, R.mipmap.nav_mensajes),
        TINKERLINKUSERS(1, R.string.contacts_undo, R.mipmap.ic_contact_add, R.mipmap.ic_contact_sent),
        CONTACTSFRIEND(2, 0, 0, 0),
        OPTIONS(3, 0, R.mipmap.ic_more, R.mipmap.ic_more),
        NONE(4, 0, 0, 0);

        private final int idType;
        private final int title;
        private final int icon;
        private final int iconPressed;

        ContactsType(int idType, int title, int icon, int iconPressed) {
            this.idType = idType;
            this.title = title;
            this.icon = icon;
            this.iconPressed = iconPressed;
        }

        public int getIdType() {
            return idType;
        }

        public int getTitle() {
            return title;
        }

        public int getIcon() {
            return icon;
        }

        public int getIconPressed() {
            return iconPressed;
        }

        public static ContactsType fromId(int id) {
            if (id == EMAIL.getIdType()) {
                return EMAIL;
            } else if (id == TINKERLINKUSERS.getIdType()) {
                return TINKERLINKUSERS;
            } else if (id == CONTACTSFRIEND.getIdType()) {
                return CONTACTSFRIEND;
            } else if (id == OPTIONS.getIdType()) {
                return OPTIONS;
            }

            return NONE;
        }
    }


    public interface Listener {
        void onItemPressed(View anchorView, ContactsType type);
    }

    //Vars
    private ContactsType type;
    private Listener listener;

    //Views

    @BindView(R.id.userImage)
    protected TLImageView mUserImage;

    @BindView(R.id.userName)
    protected TLTextView mUserName;

    @BindView(R.id.userJob)
    protected TLTextView mUserJob;

    @BindView(R.id.contactsView)
    protected TLCommonContactsView mContactsView;

    @BindView(R.id.containerOptions)
    protected LinearLayout mContainerOptions;

    @BindView(R.id.undoText)
    protected TLTextView mUndoText;

    @BindView(R.id.optionsButton)
    protected TLImageButton mOptionsButton;


    public TLUserContactView(Context context) {
        this(context, null);
    }

    public TLUserContactView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TLUserContactView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TLUserContactView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        setBackgroundResource(R.drawable.button_default_states);
        inflate(getContext(), R.layout.lay_user_contacts_view, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            TypedArray attributes = null;
            try {
                attributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TLUserContactView);
                setType(ContactsType.fromId(attributes.getInt(R.styleable.TLUserContactView_contactType, ContactsType.NONE.getIdType())));
            } catch (Exception ex) {
            } finally {
                if (attributes != null) {
                    attributes.recycle();
                }
            }
        } else {
            setType(ContactsType.NONE);
        }
    }

    private void modeEmail() {
        mContainerOptions.setVisibility(VISIBLE);
        mContactsView.setVisibility(GONE);
        mUndoText.setText(getResources().getString(getType().getTitle()));
        mUndoText.setVisibility(GONE);
        mOptionsButton.setImageResource(getType().getIcon());
    }

    private void modeTinkerLinkUsers() {
        mContainerOptions.setVisibility(VISIBLE);
        mContactsView.setVisibility(GONE);
        mUndoText.setText(getResources().getString(getType().getTitle()));
        mUndoText.setVisibility(GONE);
        mOptionsButton.setImageResource(getType().getIcon());
    }

    private void modeContactsFriend() {
        mContactsView.setVisibility(VISIBLE);
        mContainerOptions.setVisibility(GONE);
    }

    private void modeOptions() {
        mContainerOptions.setVisibility(VISIBLE);
        mContactsView.setVisibility(GONE);
        mUndoText.setVisibility(GONE);
        mOptionsButton.setImageResource(getType().getIcon());
    }

    private void modeNone() {
        mContactsView.setVisibility(GONE);
        mContainerOptions.setVisibility(GONE);
    }

    private void tryType() {
        if (getType() == ContactsType.EMAIL) {
            modeEmail();
        } else if (getType() == ContactsType.TINKERLINKUSERS) {
            modeTinkerLinkUsers();
        } else if (getType() == ContactsType.OPTIONS) {
            modeOptions();
        } else if (getType() == ContactsType.CONTACTSFRIEND) {
            modeContactsFriend();
        } else {
            modeNone();
        }
    }

    // Actions

    @OnClick(R.id.optionsButton)
    protected void optionsPressed() {
        if (listener != null) {
            listener.onItemPressed(mOptionsButton, getType());
        }
    }

    // Public

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ContactsType getType() {
        return type;
    }

    public void setType(ContactsType type) {
        this.type = type;
        tryType();
    }

    public void setUserName(String userName) {
        mUserName.setText(userName);
    }

    public void setUserProfession(String profession) {
        mUserJob.setText(profession);
    }

    public void setUserImageFromUrl(String url) {
        mUserImage.setImageFromUrl(url);
    }
}
