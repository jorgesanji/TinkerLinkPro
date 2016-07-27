package com.cronosgroup.tinkerlink.view.config.frequentlyquestions;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.changephonenumber.ChangePhoneNumberPresenter;
import com.cronosgroup.tinkerlink.presenter.frequentlyquestions.FrequentlyQuestionsPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;


/**
 * ChangePhoneNumber Fragment
 */
public class FrequentlyQuestionsFragment extends MVPTinkerLinkFragment<FrequentlyQuestionsPresenter, FrequentlyQuestionsPresenter.View>
        implements FrequentlyQuestionsPresenter.View, FrequentlyQuestionsScreen.Listener {

    // Vars

    // Views
    private FrequentlyQuestionsScreen preSignUserScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        preSignUserScreen = new FrequentlyQuestionsScreen(getActivity());
        preSignUserScreen.setListener(this);
        return preSignUserScreen;
    }

    @Override
    protected FrequentlyQuestionsPresenter createPresenter() {
        return new FrequentlyQuestionsPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected FrequentlyQuestionsPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** ChangePhoneNumberPresenter.View **************

    //endregion

    //region ************** ChangePhoneNumberScreen.Listener **************

    //endregion

}
