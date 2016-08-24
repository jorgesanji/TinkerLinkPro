package com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.mycontacts;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.cronosgroup.core.view.BaseAdapter;
import com.cronosgroup.core.view.animator.SlideInUpAnimator;
import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.utils.TLDividerItemDecoration;
import com.cronosgroup.tinkerlink.view.customviews.TLImageButton;
import com.cronosgroup.tinkerlink.view.customviews.TLMenuButton;
import com.cronosgroup.tinkerlink.view.customviews.TLRecyclerView;
import com.cronosgroup.tinkerlink.view.customviews.TLSearchView;
import com.cronosgroup.tinkerlink.view.customviews.TLUserContactView;
import com.cronosgroup.tinkerlink.view.base.TLBaseView;
import com.cronosgroup.tinkerlink.view.home.adapter.fragment.contacts.adapter.pages.mycontacts.adapter.MyContactsAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Main MyContacts view.
 */
public class MyContactsScreen extends TLBaseView {

    public interface Listener {
        void onItemClicked(int position);

        void onWriteMessagePressed(int position);

        void onRemoveContactPressed(int position);

        void onBlockContactPressed(int position);

        void onImportContactsPressed();

        void onSearchContactsPressed();
    }

    // Vars
    private Listener listener;
    private MyContactsAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    // Views
    @BindView(R.id.contactList)
    protected TLRecyclerView mList;

    @BindView(R.id.closeDialog)
    protected TLImageButton mCloseButton;

    @BindView(R.id.searchView)
    protected TLSearchView mSearchView;

    @BindView(R.id.menuView)
    protected TLMenuButton mMenuButton;

    /**
     * @param context
     */
    public MyContactsScreen(Context context) {
        super(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public MyContactsScreen(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyContactsScreen(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyContactsScreen(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getLayout() {
        return R.layout.lay_my_contacts;
    }

    @Override
    public void initUI(AttributeSet attributeSet) {
        initUI();
        initRecyclerView();
        initAdapter();
        initListeners();
    }

    private void initUI() {
        mCloseButton.setVisibility(GONE);
        mList.addItemDecoration(new TLDividerItemDecoration(getContext(), R.drawable.line_divider_contacts));
        mSearchView.setQueryHint(getResources().getString(R.string.contacts_search_hint));
    }

    private void initAdapter() {
        mAdapter = new MyContactsAdapter();
        mAdapter.setType(TLUserContactView.ContactsType.OPTIONS);
        mList.setAdapter(mAdapter);
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(mLayoutManager);
        mList.setItemAnimator(new SlideInUpAnimator());
    }

    private void initListeners() {
        mAdapter.setListener(new MyContactsAdapter.Listener() {
            @Override
            public void onItemPressed(final int position, View view, TLUserContactView.ContactsType type) {
                if (TLUserContactView.ContactsType.OPTIONS == type) {
                    PopupMenu popup = new PopupMenu(getContext(), view);
                    popup.getMenuInflater().inflate(R.menu.popup_contacts_menu, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.action_writte_message:
                                    listener.onWriteMessagePressed(position);
                                    break;
                                case R.id.action_remove_contact:
                                    listener.onRemoveContactPressed(position);
                                    break;
                                case R.id.action_block_contact:
                                    listener.onBlockContactPressed(position);
                                    break;
                            }
                            return true;
                        }
                    });

                    popup.show();
                }
            }
        });

        mAdapter.setClickListener(new BaseAdapter.CLickListener() {
            @Override
            public void onItemSelected(int position) {
                listener.onItemClicked(position);
            }
        });

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                return false;
            }
        });
    }

    // Actions

    @OnClick(R.id.importContacts)
    protected void imporContactsPressed() {
        listener.onImportContactsPressed();
        mMenuButton.collapseMenu();
    }

    @OnClick(R.id.searchContacts)
    protected void searchContactsPressed() {
        listener.onSearchContactsPressed();
        mMenuButton.collapseMenu();
    }

    // Public methods

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setItems(List<RestContact> list) {
        mAdapter.addItems(list);
    }

    public List<RestContact> getItems() {
        return mAdapter.getItems();
    }

}