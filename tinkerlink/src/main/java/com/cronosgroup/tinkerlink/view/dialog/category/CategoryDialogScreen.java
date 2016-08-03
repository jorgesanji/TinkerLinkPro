package com.cronosgroup.tinkerlink.view.dialog.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
import com.cronosgroup.tinkerlink.view.customviews.TLSearchView;
import com.cronosgroup.tinkerlink.view.dialog.category.adapter.CategoryAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class CategoryDialogScreen extends LinearLayout {

    public interface Listener {
        void onItemSelected(RestCategoria categoria);
    }

    // Variables
    private CategoryAdapter mAdapter;
    private Listener listener;
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean isLinkerCard = false;

    // Views
    @BindView(R.id.list)
    protected RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    protected TLSearchView mSearchView;

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context, boolean isLinkerCard, Listener listener) {
        this(context);
        this.listener = listener;
        this.isLinkerCard = isLinkerCard;
    }

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context) {
        this(context, null);
        init();
    }

    /**
     * @param context
     * @param attrs
     */
    public CategoryDialogScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CategoryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CategoryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog_country, this);
        ButterKnife.bind(this);
        initUI();
        initListeners();
    }

    private void initUI() {
        mSearchView.setQueryHint(getResources().getString(R.string.create_search_hint));
        mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
    }

    private void initListeners() {

        mSearchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RestCategoria restCategoria = new RestCategoria();
                restCategoria.setProfesion(query);
                listener.onItemSelected(restCategoria);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    public void setItemsAdapter(List<RestCategoria> restCategoriaList) {
        mAdapter = new CategoryAdapter(restCategoriaList, isLinkerCard);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerListView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerListView.setAdapter(mAdapter);

        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemSelected(mAdapter.getItems().get(position));
            }
        });
    }
}
