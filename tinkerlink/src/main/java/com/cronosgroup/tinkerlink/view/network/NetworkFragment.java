package com.cronosgroup.tinkerlink.view.network;

import android.view.View;

import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestNetwork;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.network.NetworkPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.customviews.TLNetworkView;

import java.util.List;


/**
 * Sign Fragment
 */
public class NetworkFragment extends MVPTinkerLinkFragment<NetworkPresenter, NetworkPresenter.View>
        implements NetworkPresenter.View, TLNetworkView.Listener {

    // Vars
    private int mLinkerPage = 0;
    private int mTinkerPage = 0;

    // Views
    private NetworkScreen networkScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        networkScreen = new NetworkScreen(getActivity());
        networkScreen.getNetworkView().setListener(this);
        return networkScreen;
    }

    @Override
    protected NetworkPresenter createPresenter() {
        return new NetworkPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected NetworkPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

        getPresenter().getNetwork();

        networkScreen.getNetworkView().setContactImage("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");
        networkScreen.getNetworkView().setContactName("Andres Sanmartin");
        networkScreen.getNetworkView().setUserImage("http://img.webme.com/pic/m/metallica-cf/jameshetfield.jpg");

        networkScreen.introAnimation();
    }

    //endregion

    //region ************** NetworkPresenter.View **************

    private void addItemsToLinkerbByPage() {
        List<String> subListByPage = getPresenter().getLinkerCategoriesByPage(mLinkerPage);
        for (String name : subListByPage) {
            networkScreen.getNetworkView().addLinkerCategory(name);
        }

        if (subListByPage.isEmpty()) {
            networkScreen.getNetworkView().removeLinkerLoader();
        }
    }

    private void addItemsToTinkerbByPage() {
        List<String> subListByPage = getPresenter().getTinkerCategoriesByPage(mTinkerPage);
        for (String name : subListByPage) {
            networkScreen.getNetworkView().addTinkerCategory(name);
        }

        if (subListByPage.isEmpty()) {
            networkScreen.getNetworkView().removeTinkerLoader();
        }
    }

    @Override
    public void setNetworkInfo(RestNetwork network) {

        addItemsToTinkerbByPage();
        addItemsToLinkerbByPage();

        List<RestUser> userList = network.getContactsFriend();
        if (!userList.isEmpty()) {
            networkScreen.getNetworkView().setNumberCommonContacts(String.valueOf(userList.size()));
            if (userList.size() > 4) {
                userList = userList.subList(0, 4);
            }
            for (RestUser user : userList) {
                networkScreen.getNetworkView().addContactFriend(user.getPhoto(), user.getName(), user.getProfile().getProfession());
            }
        }

        networkScreen.getNetworkView().removeLoader();
    }

    //endregion

    //region ************** TLNetworkView.Listener **************

    @Override
    public void onClosePressed() {
        getActivity().finish();
    }

    @Override
    public void onShowContactsPressed() {

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

    @Override
    public void showLoading() {
        super.showLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        if (getActivity() != null) {
            ((ToolBarActivity) getActivity()).hideLoading();
        }
    }

    //endregion

}
