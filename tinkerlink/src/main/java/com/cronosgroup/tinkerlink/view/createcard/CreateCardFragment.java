package com.cronosgroup.tinkerlink.view.createcard;

import android.view.View;

import com.cronosgroup.core.view.ToolBarActivity;
import com.cronosgroup.tinkerlink.presenter.EditProfilePresenter;
import com.cronosgroup.tinkerlink.presenter.createcard.CreateCardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * Create card Fragment
 */
public class CreateCardFragment extends MVPTinkerLinkFragment<CreateCardPresenter, CreateCardPresenter.View>
        implements CreateCardPresenter.View, CreateCardScreen.Listener {

    // Vars

    // Views
    private CreateCardScreen createCardScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        createCardScreen = new CreateCardScreen(getActivity());
        createCardScreen.setListener(this);
        return createCardScreen;
    }

    @Override
    protected CreateCardPresenter createPresenter() {
        return new CreateCardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CreateCardPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** CreateCardPresenter.View **************
    //endregion

    //region ************** CreateCardScreen.Listener **************
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
