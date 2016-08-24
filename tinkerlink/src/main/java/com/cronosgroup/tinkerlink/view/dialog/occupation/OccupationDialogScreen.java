package com.cronosgroup.tinkerlink.view.dialog.occupation;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.view.customviews.TLEditText;
import com.cronosgroup.tinkerlink.view.customviews.TLLinearLayout;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.TLTextView;
import com.cronosgroup.tinkerlink.view.dialog.occupation.adapter.OccupationAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by jorgesanmartin on 10/26/15.
 */
public class OccupationDialogScreen extends TLLinearLayout {

    /**
     * Occupations dialog screen.
     */
    public interface Listener {
        void onAddPressed(String result);

        void onClosePressed();
    }

    // Vars
    private Listener listener;
    private OccupationAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    // Views
    @BindView(R.id.list)
    protected TLRecyclerView mList;

    @BindView(R.id.newOccupation)
    protected TLEditText mNewOccupation;

    @BindView(R.id.limitOccupation)
    protected TLTextView mLimitOccupation;

    @BindView(R.id.containerOccupationView)
    protected View mContainerOccupation;

    /**
     * @param context
     */
    public OccupationDialogScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public OccupationDialogScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public OccupationDialogScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OccupationDialogScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_dialog_occupation;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        super.initUI(attributeSet);
        initRecyclerView();
        mContainerOccupation.setVisibility(INVISIBLE);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(mLayoutManager);
        mList.setItemAnimator(new DefaultItemAnimator());
    }

    private void initAdapter(List<String> list) {
        this.mAdapter = new OccupationAdapter(list);
        mList.setAdapter(mAdapter);
    }

    private void initListeners() {
        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onAddPressed(mAdapter.getItem(position));
            }
        });

        mNewOccupation.setOnEditorActionListener(new TLEditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    listener.onAddPressed(mNewOccupation.getText().toString());
                    handled = true;
                }
                return handled;
            }
        });
    }

    // Actions

    @OnClick(R.id.closeDialog)
    protected void onClosePressed() {
        listener.onClosePressed();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<String> list) {
        initAdapter(list);
        initListeners();
    }

    public void show() {
        appear(mContainerOccupation);
    }
}
