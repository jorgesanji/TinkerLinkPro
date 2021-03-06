package com.cronosgroup.tinkerlink.view.home.fragment.newsfeed;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.manager.AppConfigManager;
import com.cronosgroup.tinkerlink.manager.AppUserSessionManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.view.animation.newsfeed.ScrollHandler;
import com.cronosgroup.tinkerlink.view.customviews.TLMenuButton;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.home.fragment.newsfeed.adapter.HomeAdapter;
import com.cronosgroup.tinkerlink.view.interfaces.IOActionButtons;
import com.cronosgroup.tinkerlink.view.interfaces.IOLoadMore;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Main NewsFeed view.
 */
public class NewsFeedScreen extends RelativeLayout {

    public static final int MAX_ITEMS = 25;

    /**
     * listeners of the home's screen.
     */
    public interface Listener {
        void onImTinkerStackPressed();

        void onSearchTinkerStackPressed();

        void onLoadPost(String idLastPost, String... params);

        void onLikePressed(RestPost restPost);

        void onChatPressed(RestContacto restContacto);

        void onShareFacebookPressed(RestPost post);

        void onShareNewsFeedPressed(RestPost post);

        void onShowUserRecommendationPressed(RestPost restPost);

        void onAddContactPressed(RestPost restPost);

        void onUserIconPressed(RestContacto userContact);

        void onShowDetailCard(RestPost restPost);

        void onUserImagePressed(RestPost restPost);

        void onUserActivityPressed();
    }

    // Vars
    private boolean mRefreshing = false;
    private Listener listener;
    private HomeAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ScrollHandler mScrollHandler;

    // Views
    @BindView(R.id.newsFeedList)
    TLRecyclerView mHomeListView;

    @BindView(R.id.progressBar)
    View mLoader;

    @BindView(R.id.menuView)
    TLMenuButton mMenuButton;

    @BindView(R.id.empty_message)
    TLTextView mEmptyMessage;

    @BindView(R.id.viewMenu)
    View mViewMenu;

    @BindView(R.id.topView)
    View mTopView;

    @BindView(R.id.statusMessage)
    TLTextView mStatusMessage;

    @BindView(R.id.newPosts)
    TLTextView newPosts;


    /**
     * @param context
     */
    public NewsFeedScreen(Context context, Listener listener) {
        this(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public NewsFeedScreen(Context context) {
        this(context, null, 0);
    }

    /**
     * @param context
     * @param attrs
     */
    public NewsFeedScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public NewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public NewsFeedScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_newsfeed, this);
        ButterKnife.bind(this);
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        newPosts.setVisibility(GONE);
        mViewMenu.setVisibility(GONE);
        mEmptyMessage.setBackgroundColor(getResources().getColor(R.color.gray_color));
        mEmptyMessage.setText(getResources().getString(R.string.news_feed_empty_message));
        mEmptyMessage.setBackgroundColor(Color.TRANSPARENT);

//        // Configure the refreshing colors
//        mSwipeRefresh.setColorSchemeResources(R.color.tinkercolor,
//                R.color.linkercolor,
//                android.R.color.holo_orange_light,
//                android.R.color.holo_red_light);

    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mHomeListView.setLayoutManager(mLayoutManager);
        mHomeListView.setItemAnimator(new SlideInUpAnimator());
        mScrollHandler = new ScrollHandler(mMenuButton, mTopView, newPosts);
        mHomeListView.setOnScrollListener(mScrollHandler);
    }

    private void initListeners() {
//
//        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                reloadPosts();
//            }
//        });

        mViewMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuButton.collapseMenu();
                mViewMenu.setVisibility(GONE);
            }
        });

        mMenuButton.setListener(new TLMenuButton.IOMenuButtonState() {
            @Override
            public void collapsed() {
                mViewMenu.setVisibility(GONE);
            }

            @Override
            public void expanded() {
                mViewMenu.setVisibility(VISIBLE);
            }
        });

        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                RestPost post = mAdapter.getItem(position);
                listener.onShowDetailCard(post);
            }
        });

        mAdapter.setLoadMorePost(new IOLoadMore() {

            @Override
            public void onLoadByOffset(String idPost) {
                if (!mRefreshing) {
                    mRefreshing = true;
                    loadPosts(idPost);
                }
            }
        });

        mAdapter.setActionButtons(new IOActionButtons() {

            @Override
            public void onUserImagePressed(int position) {
                RestPost post = mAdapter.getItem(position);
                if (post.isShared()) {
                    post = post.getPost();
                }
                listener.onUserImagePressed(post);
            }

            @Override
            public void onIconProfilePressed(RestContacto contacto) {
                listener.onUserIconPressed(contacto);
            }

            @Override
            public void onLikePressed(final int position) {
                final RestPost post = mAdapter.getItems().get(position);
                post.setLike(!post.getLike());
                mAdapter.notifyItemChanged(position);
                listener.onLikePressed(mAdapter.getItems().get(position));
            }

            @Override
            public void onSharePressed(final int position) {
                final RestPost post = mAdapter.getItems().get(position);

            }

            @Override
            public void onChatPressed(RestContacto contacto) {
                listener.onChatPressed(contacto);
            }

            @Override
            public void onAddContactPressed(RestPost restPost) {
                listener.onAddContactPressed(restPost);
            }

            @Override
            public void onShowRecommendationPressed(int position) {
                RestPost post = mAdapter.getItems().get(position);
                if (post.isShared()) {
                    post = post.getPost();
                }
                listener.onShowUserRecommendationPressed(post);
            }
        });
    }

    private void initAdapter() {
        mAdapter = new HomeAdapter();
//        mAdapter.setHasStableIds(true);
//        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
//        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        mHomeListView.setAdapter(mAdapter);
    }

    // **************  UI Actions **************

    @OnClick(R.id.linkerButton)
    protected void btnLinkerPressed() {
        mMenuButton.collapseMenu();
        listener.onSearchTinkerStackPressed();
    }

    @OnClick(R.id.tinkerButton)
    protected void btnTinkerPressed() {
        mMenuButton.collapseMenu();
        listener.onImTinkerStackPressed();
    }

    @OnClick(R.id.statusCard)
    protected void btnStatusPressed() {
        listener.onUserActivityPressed();
    }

    @OnClick(R.id.newPosts)
    protected void btnNewsPostsPressed() {
        newPosts.setVisibility(GONE);
        goToListTop();
        mRefreshing = true;
        loadPosts("0");
    }

    @OnClick(R.id.imTinkerbt)
    protected void btnImTinkerPressed() {
        listener.onImTinkerStackPressed();
    }

    @OnClick(R.id.searchTinkerbt)
    protected void btnSearchTinkerPressed() {
        listener.onSearchTinkerStackPressed();
    }

    protected HomeAdapter getAdapter() {
        return mAdapter;
    }

    protected void hideButtons() {
        mMenuButton.setVisibility(GONE);
    }

    protected void hideStatus() {
        mTopView.setVisibility(GONE);
    }

    protected void showMessageIfItemsIsEmpty() {
        if (mAdapter.getItemCount() == 0) {
            mEmptyMessage.setVisibility(VISIBLE);
            mEmptyMessage.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_pager));
        } else {
            mEmptyMessage.setVisibility(GONE);
        }
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void initAdapter(AppConfigManager appConfigManager,
                            AppUserSessionManager appUserSessionManager) {
        getAdapter().setAppUserSessionManager(appUserSessionManager);
        getAdapter().setAppConfigManager(appConfigManager);
    }

    public void setStatusMessage(String statusMessage) {
        mStatusMessage.setText(statusMessage);
    }

    public void goToListTop() {
        mScrollHandler.show();
        mHomeListView.scrollToPosition(0);
    }

    public void showLoading() {
        mLoader.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        mLoader.setVisibility(View.GONE);
    }

    public void loadPosts(String lastPost) {
        listener.onLoadPost(lastPost);
    }

    public void reloadPosts() {
        mAdapter.reloadData();
        loadPosts("0");
    }

    public void addPost(RestPost restPost) {
        mAdapter.getItems().add(0, restPost);
        mAdapter.notifyItemInserted(0);
        mEmptyMessage.setVisibility(GONE);
    }

    public void addPosts(List<RestPost> list) {

        if (list != null && list.size() != 0) {
            if (mAdapter.getItemCount() >= MAX_ITEMS) {
                mAdapter.removeAndUpdateUI((mAdapter.getItemCount() - 1));
            }

            if (list.size() == MAX_ITEMS) {
                RestPost post = new RestPost();
                post.setTipo(RestPost.PostType.LOAD.getTypeString());
                list.add(post);
            }
            mAdapter.addItems(list);
        }

        showMessageIfItemsIsEmpty();

        mRefreshing = false;

//                mSwipeRefresh.setRefreshing(false);
    }

    public List<RestPost> getItems() {
        return mAdapter.getItems();
    }

    public void updateItem(int index) {
        mAdapter.notifyItemChanged(index);
    }

    public void showNewPost() {
        if (!mRefreshing) {
            newPosts.setVisibility(VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_scale_button);
            newPosts.startAnimation(animation);
            mScrollHandler.show();
        }
    }

    public void clearData() {
        mAdapter.clearData();
    }
}