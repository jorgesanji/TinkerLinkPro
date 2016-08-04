package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.tinkerexperience;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.createcard.ExperienceSelectionPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class TinkerExperienceSelectionFragment extends MVPTinkerLinkFragment<ExperienceSelectionPresenter, ExperienceSelectionPresenter.View>
        implements ExperienceSelectionPresenter.View, TinkerExperienceSelectionScreen.Listener {

    // Views
    private TinkerExperienceSelectionScreen experienceSelectionScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        experienceSelectionScreen = new TinkerExperienceSelectionScreen(getActivity());
        experienceSelectionScreen.setListener(this);
        return experienceSelectionScreen;
    }

    @Override
    protected ExperienceSelectionPresenter createPresenter() {
        return new ExperienceSelectionPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected ExperienceSelectionPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

}
