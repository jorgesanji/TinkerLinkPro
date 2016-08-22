package com.cronosgroup.tinkerlink.view.detailcard.adapter.page;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.detailcard.DetailCardPresenter;
import com.cronosgroup.tinkerlink.utils.TLMMenuBuilder;
import com.cronosgroup.tinkerlink.utils.TLMMenuItem;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.detailcard.DetailCardScreen;
import com.cronosgroup.tinkerlink.view.detailcard.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.dialog.network.NetworkDialogFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Detail card Fragment
 */
public class DetailCardFragment extends MVPTinkerLinkFragment<DetailCardPresenter, DetailCardPresenter.View>
        implements DetailCardPresenter.View, DetailCardScreen.Listener {

    // Vars
    private boolean isPublish;

    // Views
    private DetailCardScreen accountScreen;

    //region **************  Fragment **************

    @Override
    protected View getRootView() {
        accountScreen = new DetailCardScreen(getActivity());
        accountScreen.setListener(this);
        return accountScreen;
    }

    @Override
    protected void onDidAppear() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isPublish = getActivity().getIntent().getExtras().getBoolean(DetailStackActivity.KEY_PUBLISH);
        setHasOptionsMenu(isPublish);
    }

    @Override
    protected List<TLMMenuBuilder> getMenuItems() {
        List<TLMMenuBuilder> menuItems = new ArrayList<>();
        menuItems.add(new TLMMenuItem().
                setId(R.id.action_publish).
                setTitle(R.string.create_card_publish).
                setTitleColor(R.color.text_white).
                setAction(TLMMenuItem.SHOW_ACTION));
        return menuItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_publish) {
            getPresenter().createCard();
        }

        return super.onOptionsItemSelected(item);
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected DetailCardPresenter createPresenter() {
        return new DetailCardPresenter();
    }

    @Override
    protected DetailCardPresenter.View getPresenterView() {
        return this;
    }

    //region **************  DetailCardScreen.Listener **************

    @Override
    public void onUpdateFormPressed() {
        getActivity().finish();
    }

    @Override
    public void onNetworkPressed() {
        addDialogFragment(NetworkDialogFragment.class, NetworkDialogFragment.CODE);
    }

    //endregion

    //region **************  DetailCardPresenter.View **************

    @Override
    public RestPost getCardData() {
        return null;
    }

    //endregion
}
