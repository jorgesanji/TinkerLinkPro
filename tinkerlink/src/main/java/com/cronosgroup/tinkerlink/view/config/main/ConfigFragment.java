package com.cronosgroup.tinkerlink.view.config.main;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.config.ConfigPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Config Fragment
 */
public class ConfigFragment extends MVPTinkerLinkFragment<ConfigPresenter, ConfigPresenter.View>
        implements ConfigPresenter.View, ConfigScreen.Listener {

    // Vars

    // Views
    private ConfigScreen configScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        configScreen = new ConfigScreen(getActivity());
        configScreen.setListener(this);
        return configScreen;
    }

    @Override
    protected ConfigPresenter createPresenter() {
        return new ConfigPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ConfigPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        configScreen.initPager(getActivity().getSupportFragmentManager());
    }

    //endregion

    //region ************** ConfigPresenter.View **************

    //endregion

    //region ************** ConfigScreen.Listener **************

    //endregion

}
