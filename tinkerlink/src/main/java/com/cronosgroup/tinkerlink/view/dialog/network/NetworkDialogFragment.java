package com.cronosgroup.tinkerlink.view.dialog.network;

import android.view.View;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNetwork;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.network.NetworkPresenter;
import com.cronosgroup.tinkerlink.view.dialog.base.MVPTinkerLinkDialogFragment;

import java.util.List;


/**
 * Sign Fragment
 */
public class NetworkDialogFragment extends MVPTinkerLinkDialogFragment<NetworkPresenter, NetworkPresenter.View>
        implements NetworkPresenter.View, NetworkDialogScreen.Listener {

    // Vars
    public static final int CODE = 134;

    private int mLinkerPage = 0;
    private int mTinkerPage = 0;

    // Views
    private NetworkDialogScreen networkScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        networkScreen = new NetworkDialogScreen(getActivity());
        networkScreen.setListener(this);
        return networkScreen;
    }

    @Override
    protected NetworkPresenter createPresenter() {
        return new NetworkPresenter();
    }

    @Override
    protected NetworkPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

        getPresenter().getNetwork();

        networkScreen.setContactImage("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
        networkScreen.setContactName("Andres Sanmartin");
        networkScreen.setUserImage("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
        networkScreen.show();
    }

    //endregion

    //region ************** NetworkPresenter.View **************

    private void addItemsToLinkerbByPage() {
        List<String> subListByPage = getPresenter().getLinkerCategoriesByPage(mLinkerPage);
        for (String name : subListByPage) {
            networkScreen.addLinkerCategory(name);
        }

        if (subListByPage.isEmpty()) {
            networkScreen.removeLinkerLoader();
        }
    }

    private void addItemsToTinkerbByPage() {
        List<String> subListByPage = getPresenter().getTinkerCategoriesByPage(mTinkerPage);
        for (String name : subListByPage) {
            networkScreen.addTinkerCategory(name);
        }

        if (subListByPage.isEmpty()) {
            networkScreen.removeTinkerLoader();
        }
    }

    @Override
    public void setNetworkInfo(RestNetwork network) {

        addItemsToTinkerbByPage();
        addItemsToLinkerbByPage();

        List<RestUser> userList = network.getContactsFriend();
        if (!userList.isEmpty()) {
            networkScreen.setNumberCommonContacts(String.valueOf(userList.size()));
            if (userList.size() > 4) {
                userList = userList.subList(0, 4);
            }
            for (RestUser user : userList) {
                networkScreen.addContactFriend(user.getPhoto(), user.getName(), user.getProfession());
            }
        }

        networkScreen.removeLoader();
    }

    //endregion

    //region ************** NetworkDialogScreen.Listener **************

    @Override
    public void onClosePressed() {
        dismiss();
    }

    @Override
    public void onShowContactsPressed() {
        getPresenter().onShowContactsPressed();
    }

    @Override
    public void onLoadTinkerPressed() {
        mTinkerPage++;
        addItemsToTinkerbByPage();
    }

    @Override
    public void onLoadLinkerPressed() {
        mLinkerPage++;
        addItemsToLinkerbByPage();
    }

    //endregion

}
