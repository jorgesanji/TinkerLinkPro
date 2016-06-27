package com.cronosgroup.tinkerlink.view.dialog.selectionusers;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.sectionable.Item;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.dialog.selectionusers.adapter.UsersAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class SelectorUsersScreen extends LinearLayout {

    private Listener listener;

    public interface Listener {
        void onCancelPressed();

        void onAcceptPressed();
    }

    // Variables
    private UsersAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views
    @BindView(R.id.list)
    RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    SearchView mSearchView;

    @BindView(R.id.containerButtons)
    View mContainerButtons;

    /**
     * @param context
     */
    public SelectorUsersScreen(Context context, List<Item> contacts) {
        super(context);
        init(contacts);
    }

    /**
     * @param context
     * @param attrs
     */
    public SelectorUsersScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SelectorUsersScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(null);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SelectorUsersScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(null);
    }

    private void init(List<Item> contacts) {
        inflate(getContext(), R.layout.lay_dialog, this);
        ButterKnife.bind(this);
        initUI();
        initAdapter(contacts);
        initRecyclerView();
        initSearchView();
        initListeners();
    }

    private void initUI() {
        mContainerButtons.setVisibility(VISIBLE);
    }

    private void initAdapter(List<Item> contacts) {
        mAdapter = new UsersAdapter(contacts);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerListView.setAdapter(mAdapter);
        mRecyclerListView.addItemDecoration(new TLDividerItemDecoration(getContext(), R.drawable.line_divider_contacts));
    }

    private void initSearchView() {
        mSearchView.setQueryHint(getResources().getString(R.string.profile_recommendation_introduce_name_conctact));
        mSearchView.setFocusable(true);
        mSearchView.setIconified(false);
        mSearchView.requestFocus();
        mSearchView.requestFocusFromTouch();

        int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText edit = (EditText) mSearchView.findViewById(id);
        if (edit != null) {
            edit.setHintTextColor(getResources().getColor(R.color.black_opaque));
            edit.setTextColor(getContext().getResources().getColor(R.color.tinkercolor));
        }
    }

    private void initListeners() {

        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                mAdapter.tryItem(position);
            }
        });

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    //*** View Actions

    @OnClick(R.id.cancelButton)
    protected void cancelPressed() {
        listener.onCancelPressed();
    }

    @OnClick(R.id.acceptButton)
    protected void acceptPressed() {
        listener.onAcceptPressed();
    }

    // Public methods


    public Listener getListener() {
        return listener;
    }

    public SelectorUsersScreen setListener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public List<RestUser> getUsersSelected() {
        return mAdapter.getUsersSelected();
    }
}
