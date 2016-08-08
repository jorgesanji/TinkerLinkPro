package com.cronosgroup.tinkerlink.presenter.tutorial;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 16/10/15.
 */
public class TutorialPresenter extends TinkerLinkPresenter<TutorialPresenter.View> {

    private final Actions listener;

    /**
     * Tutorial listeners.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    /**
     * Tutorial actions.
     */
    public interface Actions {

        void onLaunchHome(Activity activity, Bundle bundle);

        void onLaunchLogin(Activity activity, Bundle bundle);

        void onLaunchSign(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public TutorialPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  View Actions **************

    public void onLaunchLogin() {
        listener.onLaunchLogin(getView().getActivity(), null);
    }

    public void onLaunchSign() {
        listener.onLaunchSign(getView().getActivity(), null);
    }

    public boolean isUserLoged() {
        TLUser user = getAppUserSessionManager().getCurrentUser();
//        if (user != null && user.getLoged()) {
        if (false) {
            listener.onLaunchHome(getView().getActivity(), null);
            getView().getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            return true;
        }
        return false;
    }

}
