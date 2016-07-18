package com.cronosgroup.tinkerlink.presenter.tutorial;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;

/**
 * Created by jorgesanmartin on 16/10/15.
 */
public class TutorialPresenter extends TinkerLinkPresenter<TutorialPresenter.View> {

    private final Actions listener;

    /**
     * Tutorial listeners.
     */
    public interface View extends Presenter.View {
    }

    /**
     * Tutorial actions.
     */
    public interface Actions {

        void onLoginPressed(Activity activity, Bundle bundle);

        void onSignPressed(Activity activity, Bundle bundle);

        void onLaunchHomeFromTutorial(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public TutorialPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    //region **************  View Actions **************

    public void onLoginPressed() {
        listener.onLoginPressed(getView().getActivity(), null);
    }

    public void onSignPressed() {
        listener.onSignPressed(getView().getActivity(), null);
    }

    public boolean isUserLoged() {
        TLUser user = getAppUserSessionManager().getCurrentUser();
//        if (user != null && user.getLoged()) {
        if (true){
            listener.onLaunchHomeFromTutorial(getView().getActivity(), null);
            getView().getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            return true;
        }
        return false;
    }

}
