package com.cronosgroup.tinkerlink.view.dialog.country;

import android.annotation.TargetApi;
import android.content.Context;
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
import com.cronosgroup.tinkerlink.manager.AppCountryManager;
import com.cronosgroup.tinkerlink.view.dialog.country.adapter.CountryAdapter;
import com.cronosgroup.tinkerlink.view.interfaces.IOCountrySelected;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class DialogScreen extends LinearLayout {


    // Variables
    private CountryAdapter mAdapter;
    private IOCountrySelected listener;
    private RecyclerView.LayoutManager mLayoutManager;
    private AppCountryManager appCountryManager;


    // Views
    @BindView(R.id.list)
    RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    SearchView mSearchView;

    /**
     * @param context
     */
    public DialogScreen(Context context, IOCountrySelected listener, AppCountryManager appCountryManager) {
        super(context);
        this.listener = listener;
        this.appCountryManager = appCountryManager;
        init();
    }

    /**
     * @param context
     */
    public DialogScreen(Context context, IOCountrySelected listener) {
        super(context);
        this.listener = listener;
        init();
    }

    /**
     * @param context
     */
    public DialogScreen(Context context) {
        super(context);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public DialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public DialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public DialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog, this);
        ButterKnife.bind(this);
        initAdapter();
        initSearchViewListener();
    }

    private void initAdapter() {
        mAdapter = new CountryAdapter(appCountryManager.getCountries(), new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                if (listener != null) {
                    listener.onCountrySelected((mAdapter.getItems() != null && mAdapter.getItems().size() > 0) ? mAdapter.getItems().get(position) : mAdapter.getAllItems().get(position));
                }
            }
        });

        mAdapter.setAppCountryManager(appCountryManager);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerListView.setAdapter(mAdapter);

        mSearchView.setFocusable(true);
        mSearchView.setIconified(false);
        mSearchView.requestFocus();
        mSearchView.requestFocusFromTouch();

        int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText edit = (EditText) mSearchView.findViewById(id);
        if (edit != null) {
            edit.setHintTextColor(getResources().getColor(R.color.gray_30));
            edit.setTextColor(getContext().getResources().getColor(R.color.black));
        }
    }

    private void initSearchViewListener() {

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
}
