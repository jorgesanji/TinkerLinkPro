package com.cronosgroup.tinkerlink.view.tutorial;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.tutorial.adapter.TutoriaItem;

import java.util.List;

/**
 * Tutorial Fragment
 */
public class TutorialFragment extends MVPTinkerLinkFragment<TutorialPresenter, TutorialPresenter.View>
        implements TutorialPresenter.View, TutorialScreen.Listener {

    private TutorialScreen tutorialScreen;

    //region **************  Fragment **************

    @Override
    public void onPause() {
        super.onPause();
        tutorialScreen.stopTutorial();
    }

    @Override
    public void onResume() {
        super.onResume();
        tutorialScreen.startTutorial();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        tutorialScreen.stopTutorial();
    }

    //endregion

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        tutorialScreen = new TutorialScreen(getActivity());
        tutorialScreen.setListener(this);
        return tutorialScreen;
    }

    @Override
    protected TutorialPresenter createPresenter() {
        return new TutorialPresenter();
    }

    @Override
    protected TutorialPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        getPresenter().getTutorialItems();
    }

    //endregion

    //region **************  TutorialPresenter.View **************

    @Override
    public void setTutorialItems(List<TutoriaItem> list) {
        tutorialScreen.setTutorialItems(list);
    }

    //endregion

    //region **************  TutorialScreen.Listener **************


    @Override
    public void onSignPressed() {
        getPresenter().onLaunchSign();
    }

    @Override
    public void onLoginPressed() {
        getPresenter().onLaunchLogin();
    }

    @Override
    public boolean isUserLoged() {
        return getPresenter().isUserLoged();
    }

    //endregion

}
