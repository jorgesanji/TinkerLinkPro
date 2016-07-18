package com.cronosgroup.tinkerlink.view.createrecommendation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class CreateRecommendationScreen extends RelativeLayout {

    public interface Listener {
        void onAllContactsPressed();

        void onOnlyFriendsPressed();
    }


    // Vars
    private Listener listener;

    // Views

    @BindView(R.id.selectorContactsToSend)
    protected TLTextView mSelectorContactsToSend;

    @BindView(R.id.usersToSendContainer)
    protected LinearLayout mUsersToSendContainer;

    /**
     * @param context
     */
    public CreateRecommendationScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public CreateRecommendationScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CreateRecommendationScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CreateRecommendationScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_create_recommendation, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.selectorContactsToSend)
    protected void onSelectorContactsPressed() {
        PopupMenu popup = new PopupMenu(getContext(), mSelectorContactsToSend);
        popup.getMenuInflater().inflate(R.menu.popup_recommendation_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_allContacts:
                        listener.onAllContactsPressed();
                        break;
                    case R.id.action_onlyFriends:
                        listener.onOnlyFriendsPressed();
                        break;
                }
                return true;
            }
        });

        popup.show();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void addUser(TLUserView userView) {
        mUsersToSendContainer.addView(userView);
    }
}