package com.cronosgroup.tinkerlink.view.stack.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bartoszlipinski.flippablestackview.FlippableStackView;
import com.bartoszlipinski.flippablestackview.StackPageTransformer;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.stack.main.adapter.StackAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Stack view.
 */
public class StackScreen extends LinearLayout {

    public static final int DEFAULT_PAGES = 4;

    /**
     * listeners of the stack's screen.
     */
    public interface Listener {


    }

    // Vars
    private Listener listener;
    private StackAdapter adapter;

    // Views
    @BindView(R.id.pager)
    FlippableStackView mPager;

    /**
     * @param context
     */
    public StackScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public StackScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public StackScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public StackScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public StackScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_stack, this);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        mPager.initStack(DEFAULT_PAGES,
                StackPageTransformer.Orientation.VERTICAL);
    }

    // **************  UI Actions **************

//    @OnClick(R.id.newsfeedbt)
//    protected void newsFeedbtPressed() {
//        listener.onNewsFeedPresed();
//    }


    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initAdapter(FragmentManager fragmentManager) {
        adapter = new StackAdapter(fragmentManager);
        mPager.setAdapter(adapter);
    }

    public void addItems(List<RestPost> restPosts) {
        adapter.addItems(restPosts);
        adapter.notifyDataSetChanged();
    }
}