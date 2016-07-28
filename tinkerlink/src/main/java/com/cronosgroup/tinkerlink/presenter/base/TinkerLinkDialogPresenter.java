package com.cronosgroup.tinkerlink.presenter.base;

import android.content.Intent;

import com.cronosgroup.core.managers.PermissionsManager;
import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.view.BaseActivity;


/**
 * Created by jorgesanmartin on 2/23/16.
 */
public class TinkerLinkDialogPresenter<V extends TinkerLinkDialogPresenterView> extends PresenterDependencies implements Presenter<V> {

    // Views

    protected V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public V getView() {
        return view;
    }


    public PermissionsManager getPermissionManager() {
        return ((BaseActivity) getView().getActivity()).getPermissionsManager();
    }
}
