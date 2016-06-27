package com.cronosgroup.tinkerlink.view.tutorial;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.tutorial.TutorialPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

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
        return new TutorialPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected TutorialPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
    }

    //endregion

    //region **************  TutorialPresenter.View **************

    //endregion

    //region **************  TutorialScreen.Listener **************

    @Override
    public void onSignPressed() {
        getPresenter().onSignPressed();
    }

    @Override
    public void onLoginPressed() {
        getPresenter().onLoginPressed();
    }

    @Override
    public boolean isUserLoged() {
        return getPresenter().isUserLoged();
    }
    //endregion

}
