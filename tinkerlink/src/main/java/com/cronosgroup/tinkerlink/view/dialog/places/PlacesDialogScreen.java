package com.cronosgroup.tinkerlink.view.dialog.places;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.dialog.places.adapter.PlaceAutoCompleteAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class PlacesDialogScreen extends LinearLayout {

    /**
     * listeners of the PlacesDialog's screen.
     */
    public interface Listener {
        void onItemSelected(Address selected);
    }

    // Variables
    private PlaceAutoCompleteAdapter mAdapter;
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views
    @BindView(R.id.list)
    RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    SearchView mSearchView;

    /**
     * @param context
     */
    public PlacesDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
        init();
    }

    /**
     * @param context
     */
    public PlacesDialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public PlacesDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public PlacesDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public PlacesDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog, this);
        ButterKnife.bind(this);
        initRecyclerView();
        initAdapter();
        initSearchView();
        initSearchViewListener();
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initSearchView() {
        mSearchView.setFocusable(true);
        mSearchView.setIconified(false);
        mSearchView.requestFocus();
        mSearchView.requestFocusFromTouch();
        mSearchView.setQueryHint(getResources().getString(R.string.create_search_place_hint));

        int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText edit = (EditText) mSearchView.findViewById(id);
        if (edit != null) {
            edit.setHintTextColor(getResources().getColor(R.color.black_opaque));
            edit.setTextColor(getContext().getResources().getColor(R.color.tinkercolor));
        }
    }

    private void initSearchViewListener() {

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mAdapter.getFilter().filter(query);
                return false;
            }
        });
    }

    private void initAdapter() {
        mAdapter = new PlaceAutoCompleteAdapter(getContext());
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemSelected(mAdapter.getItems().get(position));
            }
        });
        mRecyclerListView.setAdapter(mAdapter);
    }
}
