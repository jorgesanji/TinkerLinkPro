package com.cronosgroup.tinkerlink.presenter.tutorial;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 16/10/15.
 */
public class TutorialPresenter extends TinkerLinkPresenter<TutorialPresenter.View> {

    /**
     * Tutorial listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    //region **************  View Actions **************

    public void onLaunchLogin() {
        navigation.onLaunchLogin(getView().getActivity(), null);
    }

    public void onLaunchSign() {
        navigation.onLaunchSign(getView().getActivity(), null);
    }

    public boolean isUserLoged() {
        TLUser user = getAppUserSessionManager().getCurrentUser();
//        if (user != null && user.getLoged()) {
        if (false) {
            navigation.onLaunchHome(getView().getActivity(), null);
            getView().getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            return true;
        }
        return false;
    }

}
