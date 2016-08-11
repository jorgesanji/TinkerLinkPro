package com.cronosgroup.tinkerlink.view.createcard.adapter.fragments.skills;

import android.view.View;

import com.cronosgroup.tinkerlink.presenter.createcard.SkillSelectionPresenter;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;

/**
 * Created by jorgesanmartin on 7/20/16.
 */
public class SkillsSelectionFragment extends MVPTinkerLinkFragment<SkillSelectionPresenter, SkillSelectionPresenter.View>
        implements SkillSelectionPresenter.View, SkillSelectionScreen.Listener {

    // Views
    private SkillSelectionScreen skillSelectionScreen;

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        skillSelectionScreen = new SkillSelectionScreen(getActivity());
        skillSelectionScreen.setListener(this);
        return skillSelectionScreen;
    }

    @Override
    protected SkillSelectionPresenter createPresenter() {
        return new SkillSelectionPresenter();
    }

    @Override
    protected SkillSelectionPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }
}
