package com.cronosgroup.tinkerlink.view.dialog.places;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLSearchView;
import com.cronosgroup.tinkerlink.view.dialog.places.adapter.PlaceAutoCompleteAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class PlacesDialogScreen extends TLLinearLayout {

    /**
     * listeners  PlacesDialog's screen.
     */
    public interface Listener {
        void onItemSelected(Address selected);

        void onClosePressed();

        void onSearchPressed();
    }

    // Variables
    private PlaceAutoCompleteAdapter mAdapter;
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views
    @BindView(R.id.list)
    protected RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    protected TLSearchView mSearchView;

    @BindView(R.id.containerView)
    protected View mPlacesContainer;

    @BindView(R.id.progressBar)
    protected ProgressBar mProgressBar;

    /**
     * @param context
     */
    public PlacesDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public PlacesDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public PlacesDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PlacesDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PlacesDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_places;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        mPlacesContainer.setVisibility(INVISIBLE);
        mProgressBar.setVisibility(GONE);
        mSearchView.setQueryHint(getResources().getString(R.string.ubication_hint));
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initAdapter() {
        mAdapter = new PlaceAutoCompleteAdapter();
        mRecyclerListView.setAdapter(mAdapter);
    }

    private void initListeners() {
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemSelected(mAdapter.getItems().get(position));
            }
        });

        mSearchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listener.onSearchPressed();
                return false;
            }
        });
    }

    // Actions

    @OnClick(R.id.closeDialog)
    protected void closePressed() {
        listener.onClosePressed();
    }

    //Public

    public void show() {
        appear(mPlacesContainer);
    }

    public void showLoader() {
        mProgressBar.setVisibility(VISIBLE);
    }

    public void hideLoader() {
        mProgressBar.setVisibility(GONE);
    }

    public String getSearchableText() {
        return mSearchView.getQuery().toString();
    }

    public void setItems(List<Address> list) {
        mAdapter.addItems(list);
    }
}
