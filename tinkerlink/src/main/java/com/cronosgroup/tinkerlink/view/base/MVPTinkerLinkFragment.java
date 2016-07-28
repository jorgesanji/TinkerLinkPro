package com.cronosgroup.tinkerlink.view.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cronosgroup.core.presenter.Presenter;
import com.cronosgroup.core.view.BaseActivity;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.AppSnackManager;


/**
 * Common functionalities for fragments.
 * Handles life cycle of presenters.
 */
public abstract class MVPTinkerLinkFragment<P extends Presenter<V>, V extends TinkerLinkPresenter.View> extends TinkerLinkFragment implements TinkerLinkPresenterView {

    // Variables
    private P presenter;
    private boolean readyInitialized = false;

    private AppSnackManager appStatusMessageManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getRootView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = createPresenter();
        appStatusMessageManager = new AppSnackManager(getPresenterView());
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.attachView(getPresenterView());
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.pause();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.resume();
        }

        if (!readyInitialized) {
            onDidAppear();
            readyInitialized = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (presenter != null) {
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    @NonNull
    public Context getContext() {
        return getActivity();
    }

    @Override
    @NonNull
    public Context getApplicationContext() {
        return getActivity().getApplicationContext();
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    protected P getPresenter() {
        return this.presenter;
    }

    protected abstract P createPresenter();

    protected abstract V getPresenterView();

    protected abstract void onDidAppear();

    protected abstract View getRootView();

    /**
     * Calls activity showInfo if container activity extends {@Presenter.View} or shows a info
     * {@Snackbar} with title and a message in a new line.
     * It is recommended to override it.
     */
    @Override
    public void showInfo(@NonNull String message, int color) {
        if (getActivity() instanceof Presenter.View) {
            ((Presenter.View) getActivity()).showInfo(message, color);
        } else {
            makeBar(message, (color == 0) ? Color.GREEN : color);
        }
    }

    /**
     * Calls activity showWarning if container activity extends {@Presenter.View} or shows a warning
     * {@Snackbar} with title and a message in a new line.
     * It is recommended to override it.
     */
    @Override
    public void showWarning(@NonNull String message, int color) {
        if (getActivity() instanceof Presenter.View) {
            ((Presenter.View) getActivity()).showWarning(message, color);
        } else {
            makeBar(message, (color == 0) ? Color.YELLOW : color);
        }
    }

    /**
     * Calls activity showError if container activity extends {@Presenter.View} or shows a error
     * {@Snackbar} with title and a message in a new line.
     * It is recommended to override it.
     */
    @Override
    public void showError(@NonNull String message, int color) {
        if (getActivity() instanceof Presenter.View) {
            ((Presenter.View) getActivity()).showError(message, color);
        } else {
            makeBar(message, (color == 0) ? Color.RED : color);
        }
    }

    private void makeBar(String text, int color) {
        Snackbar snackbar = Snackbar.make(getView(), text, Snackbar.LENGTH_LONG);
        View group = snackbar.getView();
        group.setBackgroundColor(getResources().getColor(color));
        snackbar.show();
    }

    @Override
    public void removeActivityDelay() {
        if (getActivity() != null) {
            ((BaseActivity) getActivity()).removeActivityDelay();
        }
    }

    @Override
    public void showLoading() {
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (getActivity() != null) {
            ((TinkerLinkActivity) getActivity()).hideLoading();
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        getActivity().setTitle(title);
    }

    @Override
    public void setTitle(int stringResId) {
        getActivity().setTitle(stringResId);
    }

    @Override
    public AppSnackManager getMessagesHandler() {
        return appStatusMessageManager;
    }
}
