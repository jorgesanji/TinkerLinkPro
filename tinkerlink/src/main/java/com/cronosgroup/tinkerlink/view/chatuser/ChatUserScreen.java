package com.cronosgroup.tinkerlink.view.chatuser;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.view.chatuser.adapter.ChatUserAdapter;
import com.cronosgroup.tinkerlink.view.customviews.TLButton;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Main Network view.
 */
public class ChatUserScreen extends RelativeLayout {

    /**
     * listeners of the chat user's screen.
     */
    public interface Listener {

        void getMessages();

        void sendMessage(String message);

        void cameraPressed();

        void galleryPressed();
    }

    // Vars

    private Listener listener;
    private ChatUserAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views

    @BindView(R.id.messageToSend)
    TLEditText mMessageToSend;

    @BindView(R.id.chatUserList)
    TLRecyclerView mChatUserList;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout mSwipeContainer;

    @BindView(R.id.sendButton)
    TLButton mSendButton;

    /**
     * @param context
     */
    public ChatUserScreen(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ChatUserScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ChatUserScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChatUserScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_chat_user, this);
        ButterKnife.bind(this);
        initUI();
        initRecyclerView();
        initAdapter();
        initListener();
    }

    private void initUI() {
        mSendButton.setEnabled(false);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mChatUserList.setLayoutManager(mLayoutManager);
        mChatUserList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initAdapter() {
        mAdapter = new ChatUserAdapter();
        mChatUserList.setAdapter(mAdapter);
    }

    private void initListener() {
        // Setup refresh listener which triggers new data loading
        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listener.getMessages();
            }
        });

        mMessageToSend.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mMessageToSend.getText().length() == 0) {
                    mSendButton.setEnabled(false);
                } else {
                    mSendButton.setEnabled(true);
                }
            }
        });

        mMessageToSend.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (mAdapter.getItemCount() > 0) {
                        mChatUserList.scrollToPosition(mAdapter.getItemCount() - 1);
                    }
                }
            }
        });
    }

    // **************  UI Actions **************

    @OnClick(R.id.sendButton)
    protected void sendPressed() {
        String textMessage = mMessageToSend.getText().toString().trim();
        listener.sendMessage(textMessage);
        mMessageToSend.setText(null);
        mMessageToSend.invalidate();
    }

    @OnClick(R.id.cameraButton)
    protected void cameraPressed() {
        listener.cameraPressed();
    }

    @OnClick(R.id.galleryButton)
    protected void galeryPressed() {
        listener.galleryPressed();
    }

    // Public methods

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void addMessages(List<RestMessage> messageList) {
        if (!messageList.isEmpty()) {
            boolean isEmpty = mAdapter.getItemCount() == 0;
            int start = 0;
            int count = messageList.size() - 1;
            messageList.addAll(mAdapter.getItems());
            mAdapter.setItems(messageList);
            mAdapter.notifyItemRangeInserted(start, count);
            if (isEmpty && mAdapter.getItemCount() > 0) {
                mChatUserList.scrollToPosition(mAdapter.getItemCount() - 1);
            }
        }
        mSwipeContainer.setRefreshing(false);
    }

    public void addMessage(RestMessage message) {
        mAdapter.getItems().add(message);
        mAdapter.notifyItemInserted(mAdapter.getItemCount() - 1);
        mChatUserList.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    public void addUnReadMessages(List<RestMessage> messages) {
        int size = mAdapter.getItems().size();
        mAdapter.getItems().addAll(messages);
        mAdapter.notifyItemRangeInserted(size, messages.size());
        mChatUserList.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    public void removeMessage(TLMessage message) {
        int position = mAdapter.getItems().indexOf(message);
        mAdapter.removeAndUpdateUI(position);
    }

    public void updateMessage(TLMessage message) {
        int position = mAdapter.getItems().indexOf(message);
        mAdapter.notifyItemChanged(position);
    }
}