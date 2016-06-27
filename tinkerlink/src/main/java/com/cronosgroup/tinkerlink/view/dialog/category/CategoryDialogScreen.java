package com.cronosgroup.tinkerlink.view.dialog.category;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCategoria;
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
    RecyclerView mRecyclerListView;

    @BindView(R.id.searchView)
    SearchView mSearchView;

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context, boolean isLinkerCard, Listener listener) {
        super(context);
        this.listener = listener;
        this.isLinkerCard = isLinkerCard;
        init();
    }

    /**
     * @param context
     */
    public CategoryDialogScreen(Context context) {
        super(context);
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
    public CategoryDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.lay_dialog, this);
        ButterKnife.bind(this);
        initUI();
        initListeners();
    }

    private void initUI() {
        mSearchView.setFocusable(true);
        mSearchView.setIconified(false);
        mSearchView.requestFocus();
        mSearchView.requestFocusFromTouch();
        mSearchView.setQueryHint(getResources().getString(R.string.create_search_hint));

        int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        EditText edit = (EditText) mSearchView.findViewById(id);
        if (edit != null) {
            edit.setHintTextColor(getResources().getColor(R.color.gray_30));
            edit.setTextColor(getContext().getResources().getColor(R.color.black));
        }
        mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
    }


    private void initListeners() {

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
