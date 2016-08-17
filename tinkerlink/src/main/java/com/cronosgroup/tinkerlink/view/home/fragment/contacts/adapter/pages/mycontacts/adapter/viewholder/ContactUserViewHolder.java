package com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.mycontacts.adapter.viewholder;

import android.view.View;

import com.cronosgroup.core.view.recyclerview.BaseViewHolder;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.view.customviews.TLUserContactView;
import com.cronosgroup.tinkerlink.view.home.fragment.contacts.adapter.pages.mycontacts.adapter.MyContactsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 8/2/16.
 */
public class ContactUserViewHolder extends BaseViewHolder<RestContact> {

    // Vars
    MyContactsAdapter.Listener listener;

    //Views
    @BindView(R.id.contactView)

    protected TLUserContactView mContactView;

    public ContactUserViewHolder(View itemView, TLUserContactView.ContactsType type) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContactView.setType(type);
    }

    @Override
    public void configureItem(RestContact item) {
        super.configureItem(item);
        mContactView.setUserName(item.getUser().getName());
        mContactView.setUserProfession(item.getUser().getProfile().getProfession());
        mContactView.setUserImageFromUrl(item.getUser().getPhoto());
        mContactView.setListener(new TLUserContactView.Listener() {
            @Override
            public void onItemPressed(View anchorView, TLUserContactView.ContactsType type) {
                if (listener != null) {
                    listener.onItemPressed(getAdapterPosition(), anchorView, type);
                }
            }
        });

    }

    public MyContactsAdapter.Listener getListener() {
        return listener;
    }

    public void setListener(MyContactsAdapter.Listener listener) {
        this.listener = listener;
    }
}
