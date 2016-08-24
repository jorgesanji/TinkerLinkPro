package com.cronosgroup.tinkerlink.view.dialog.country;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCountry;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLSearchView;
import com.cronosgroup.tinkerlink.view.dialog.country.adapter.CountryAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CountryDialogScreen extends TLLinearLayout {

    public interface Listener {
        void onCountrySelected(RestCountry country);

        void onClosePressed();
    }

    // Variables
    private CountryAdapter mAdapter;
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;

    // Views
    @BindView(R.id.list)
    protected RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    protected TLSearchView mSearchView;

    @BindView(R.id.containerView)
    protected LinearLayout mCountryContainer;

    /**
     * @param context
     */
    public CountryDialogScreen(Context context, Listener listener) {
        super(context);
        this.listener = listener;
    }

    /**
     * @param context
     */
    public CountryDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public CountryDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CountryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CountryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_country;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        mCountryContainer.setVisibility(INVISIBLE);
        initSearch();
        initRecyclerView();
    }

    private void initSearch() {
        mSearchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
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

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
    }

    //Actions

    @OnClick(R.id.closeDialog)
    protected void onClosePressed() {
        listener.onClosePressed();
    }

    // Public

    public void setItems(List<RestCountry> list) {
        mAdapter = new CountryAdapter(list, getContext());
        mRecyclerListView.setAdapter(mAdapter);
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                if (listener != null) {
                    listener.onCountrySelected((mAdapter.getItems() != null && mAdapter.getItems().size() > 0) ? mAdapter.getItems().get(position) : mAdapter.getAllItems().get(position));
                }
            }
        });
    }

    public void show() {
        appear(mCountryContainer);
    }
}
