package com.cronosgroup.tinkerlink.view.dialog.recommendations;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.dialog.recommendations.adapter.RecommendationsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class RecommendationsDialogScreen extends LinearLayout {

    /**
     * listeners of the home's screen.
     */
    public interface Listener {

    }

    // Vars
    private RecommendationsAdapter mAdapter;
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mNameUser;

    // Views

    @BindView(R.id.recomendationsTitle)
    TLTextView mTitle;

    @BindView(R.id.recList)
    RecyclerView mRecyclerListView;

    @BindView(R.id.progressBar)
    View mProgrress;

    @BindView(R.id.empty_message)
    TLTextView mEmpty_message;

    /**
     * @param context
     */
    public RecommendationsDialogScreen(Context context, String nameUser) {
        super(context);
        this.mNameUser = nameUser;
        init();
    }

    /**
     * @param context
     */
    public RecommendationsDialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public RecommendationsDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RecommendationsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public RecommendationsDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_list_recommendations, this);
        ButterKnife.bind(this);
        initUI();
        initRecyclerView();
        initAdapter();
    }

    private void initUI() {
        mEmpty_message.setText(getResources().getString(R.string.profile_recommendations_empty_messages));
        String contactWith = String.format(getResources().getString(R.string.news_feed_recommendations_from), mNameUser);
        mTitle.setText(contactWith);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerListView.addItemDecoration(new TLDividerItemDecoration(getContext(), R.drawable.line_divider_contacts));
    }

    private void initAdapter() {
        mAdapter = new RecommendationsAdapter();
        mRecyclerListView.setAdapter(mAdapter);
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setRecommendations(List<RestRecomendacion> list) {

        mProgrress.setVisibility(GONE);

        if (list.isEmpty()) {
            mEmpty_message.setVisibility(VISIBLE);
//            mEmpty_message.startEmptyAnimation();
        } else {
            mEmpty_message.setVisibility(GONE);
            mAdapter.getItems().addAll(list);
            mAdapter.notifyDataSetChanged();
        }
    }
}
