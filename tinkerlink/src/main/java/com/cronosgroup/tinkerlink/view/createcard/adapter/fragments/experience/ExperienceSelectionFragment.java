package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.experience;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.createcard.ExperienceSelectionPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class ExperienceSelectionFragment extends MVPTinkerLinkFragment<ExperienceSelectionPresenter, ExperienceSelectionPresenter.View>
        implements ExperienceSelectionPresenter.View, ExperienceSelectionScreen.Listener {

    // Views
    private ExperienceSelectionScreen experienceSelectionScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        experienceSelectionScreen = new ExperienceSelectionScreen(getActivity());
        experienceSelectionScreen.setListener(this);
        return experienceSelectionScreen;
    }

    @Override
    protected ExperienceSelectionPresenter createPresenter() {
        return new ExperienceSelectionPresenter();
    }

    @Override
    protected ExperienceSelectionPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

}
