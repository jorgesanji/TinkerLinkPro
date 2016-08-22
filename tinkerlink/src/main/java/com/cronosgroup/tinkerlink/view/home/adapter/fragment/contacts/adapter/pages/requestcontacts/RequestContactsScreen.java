package com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.requestcontacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Main RequestContacts view.
 */
public class RequestContactsScreen extends RelativeLayout {

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
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public RequestContactsScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RequestContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
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
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_request_contacts, this);
        ButterKnife.bind(this);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

}