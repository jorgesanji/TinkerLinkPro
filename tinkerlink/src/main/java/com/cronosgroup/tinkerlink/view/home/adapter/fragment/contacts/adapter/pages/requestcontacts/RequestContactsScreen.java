package com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.requestcontacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.base.TLBaseView;

import butterknife.BindView;


/**
 * Main RequestContacts view.
 */
public class RequestContactsScreen extends TLBaseView {

    public interface Listener {

    }

    // Vars
    private Listener listener;

    // Views
    @BindView(R.id.list)
    protected TLRecyclerView mList;

    /**
     * @param context
     */
    public RequestContactsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public RequestContactsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RequestContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RequestContactsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_request_contacts;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {

    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}