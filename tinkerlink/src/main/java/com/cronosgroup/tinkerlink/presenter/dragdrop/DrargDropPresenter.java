package com.cronosgroup.tinkerlink.presenter.dragdrop;

import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DrargDropPresenter extends TinkerLinkPresenter<DrargDropPresenter.View> {

    /**
     * DrargDrop View.
     */
    public interface View extends TinkerLinkPresenterView {
    }

    // public methods

    public void onLaunchWatchNetwork() {
        getView().getActivity().finish();
    }

    public void onLaunchWatchProfile() {
        getView().getActivity().finish();
    }

    public void onLaunchShare() {
        getView().getActivity().finish();
    }

    public void onLaunchSendMessage() {
        getView().getActivity().finish();
    }


}

