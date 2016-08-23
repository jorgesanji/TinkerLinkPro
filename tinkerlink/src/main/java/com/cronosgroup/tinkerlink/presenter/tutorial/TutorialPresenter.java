package com.cronosgroup.tinkerlink.presenter.tutorial;

import android.app.Activity;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.tutorial.adapter.TutoriaItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 16/10/15.
 */
public class TutorialPresenter extends TinkerLinkPresenter<TutorialPresenter.View> {

    /**
     * Tutorial listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setTutorialItems(List<TutoriaItem> list);
    }

    //region **************  View Actions **************

    public void getTutorialItems() {

        List<TutoriaItem> list = new ArrayList<>();
        Activity activity = getView().getActivity();

        list.add(new TutoriaItem(R.drawable.background_tutorial_gradient,
                R.mipmap.ic_logo_ti_dark,
                "",
                "",
                "",
                activity.getString(R.string.tutorial_tinkerLink_title),
                "",
                activity.getString(R.string.tutorial_tinkerLink_description)));

        list.add(new TutoriaItem(R.mipmap.bg_inicio_soy,
                R.mipmap.inicio_img_soy,
                activity.getString(R.string.tutorial_tinker_user_name),
                activity.getString(R.string.tutorial_tinker_type),
                activity.getString(R.string.tutorial_tinker_job),
                activity.getString(R.string.tutorial_tinkerLink_tinker_title),
                activity.getString(R.string.tutorial_tinkerLink_tinker_subtitle),
                activity.getString(R.string.tutorial_tinkerLink_tinker_description)));


        list.add(new TutoriaItem(R.mipmap.bg_inicio_busco,
                R.mipmap.inicio_img_busco,
                activity.getString(R.string.tutorial_linker_user_name),
                activity.getString(R.string.tutorial_linker_type),
                activity.getString(R.string.tutorial_linker_job),
                activity.getString(R.string.tutorial_tinkerLink_linker_title),
                activity.getString(R.string.tutorial_tinkerLink_linker_subtitle),
                activity.getString(R.string.tutorial_tinkerLink_linker_description)));

        list.add(new TutoriaItem(R.drawable.background_tutorial_gradient,
                R.mipmap.inicio_img_red,
                "",
                "",
                activity.getString(R.string.tutorial_network_type),
                activity.getString(R.string.tutorial_tinkerLink_network_title),
                activity.getString(R.string.tutorial_tinkerLink_network_subtitle),
                activity.getString(R.string.tutorial_tinkerLink_network_description)));

        getView().setTutorialItems(list);
    }

    public void onLaunchLogin() {
        navigation.onLaunchLogin(getView().getActivity(), null);
    }

    public void onLaunchSign() {
        navigation.onLaunchSign(getView().getActivity(), null);
    }

    public boolean isUserLoged() {
        TLUser user = getAppUserSessionManager().getCurrentUser();
//        if (user != null && user.getLoged()) {
        if (false) {
            navigation.onLaunchHome(getView().getActivity(), null);
            getView().getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            return true;
        }
        return false;
    }

}
