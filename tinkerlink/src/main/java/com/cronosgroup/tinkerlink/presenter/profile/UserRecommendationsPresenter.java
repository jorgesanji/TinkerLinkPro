package com.cronosgroup.tinkerlink.presenter.profile;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class UserRecommendationsPresenter extends TinkerLinkPresenter<UserRecommendationsPresenter.View> {

    // Vars

    /**
     * UserRecommendations listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setRecommendationsList(List<RestRecommendation> list);
    }

    //Actions

    public void getRecommendations() {

        AsyncLoader<List<RestRecommendation>> asyncLoader = new AsyncLoader<List<RestRecommendation>>() {
            @Override
            public List<RestRecommendation> doInBackground() {
                List<RestRecommendation> list = new ArrayList<>();

                RestUser restUser = new RestUser();
                restUser.setName("Luisito");
                restUser.setPhoto("http://api.ning.com/files/3G-NNOsexAFFbCt-XN5LbraHbYlrzivPtxx39pnQ8w48JITkdWKLhPCFGwt4p7794nvVE97YYfqtSwVmiSLhl1jXxV4IfejV/Staindwallcopy.jpg");
                restUser.setProfession("Developer");

                for (int init = 0; init < 2; init++) {
                    RestRecommendation restRecommendation = new RestRecommendation();
                    restRecommendation.setUser(restUser);
                    restRecommendation.setText("Es un crack de craks es el padre de la informatica si si siiiiiiii");
//                    restRecommendation.setCreateDate(DateUtils.getDateIntervalFromTimeStamp(1350574775, getView().getContext()));
                    restRecommendation.setCreateDate(new Date());
                    list.add(restRecommendation);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestRecommendation> result) {
                getView().setRecommendationsList(result);
            }
        };

        asyncLoader.start();
    }

    public void onShowAllRecommendationsPressed() {
        navigation.onLaunchUserRecommendations(getView().getActivity(), null);
    }

    public void onGiveRecommendationPressed() {
        navigation.onLaunchGiveUserRecommendation(getView().getActivity(), null);
    }

}


