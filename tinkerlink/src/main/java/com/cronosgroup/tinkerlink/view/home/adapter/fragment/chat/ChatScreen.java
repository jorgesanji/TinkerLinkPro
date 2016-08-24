package com.cronosgroup.tinkerlink.view.home.adapter.fragment.chat;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.chat.adapter.ChatAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * Main Chat view.
 */
public class ChatScreen extends TLBaseView {

    /**
     * listeners chat's screen.
     */
    public interface Listener {
        void onItemClicked(int position);
    }

    // Vars
    private Listener listener;
    private ChatAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    // Views
    @BindView(R.id.chatList)
    protected TLRecyclerView mChatList;

    /**
     * @param context
     */
    public ChatScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public ChatScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public ChatScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChatScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChatScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_messages;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        mChatList.addItemDecoration(new TLDividerItemDecoration(getContext(), R.drawable.line_divider_contacts));
    }

    private void initAdapter() {
        mAdapter = new ChatAdapter();
        mChatList.setAdapter(mAdapter);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mChatList.setLayoutManager(mLayoutManager);
        mChatList.setItemAnimator(new SlideInUpAnimator());
    }

    private void initListeners() {
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemClicked(position);
            }
        });
    }

    // **************  UI Actions **************


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setChats(List<RestChat> list) {
        mAdapter.addItems(list);
    }

    public List<RestChat> getItems() {
        return mAdapter.getItems();
    }


}