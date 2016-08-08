package com.cronosgroup.tinkerlink.presenter.stack;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.utils.DateUtils;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 6/22/16.
 */
public class CardPresenter extends TinkerLinkPresenter<CardPresenter.View> {

    private final Actions listener;

    /**
     * Card listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        StackCardType getType();

        void setRecommendationsList(List<RestRecomendacion> list);
    }

    /**
     * Card actions.
     */
    public interface Actions {
        void onLaunchDetailCard(Activity activity, Bundle bundrle);
    }

    /**
     * @param navigationListener
     */
    public CardPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }


    //Actions

    public void onLaunhDetailStack() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        listener.onLaunchDetailCard(getView().getActivity(), bundle);
    }


    public void getRecommendations() {

        AsyncLoader<List<RestRecomendacion>> asyncLoader = new AsyncLoader<List<RestRecomendacion>>() {
            @Override
            public List<RestRecomendacion> doInBackground() {
                List<RestRecomendacion> list = new ArrayList<>();

                RestProfile restProfile = new RestProfile();
                restProfile.setProfession("Developer");

                RestUser restUser = new RestUser();
                restUser.setName("Luisito");
                restUser.setPhoto("http://api.ning.com/files/3G-NNOsexAFFbCt-XN5LbraHbYlrzivPtxx39pnQ8w48JITkdWKLhPCFGwt4p7794nvVE97YYfqtSwVmiSLhl1jXxV4IfejV/Staindwallcopy.jpg");
                restUser.setProfile(restProfile);

                RestContacto restContacto = new RestContacto();
                restContacto.setUser(restUser);

                for (int init = 0; init < 10; init++) {
                    RestRecomendacion restRecomendacion = new RestRecomendacion();
                    restRecomendacion.setUser(restContacto);
                    restRecomendacion.setRecomendacion("Es un crack de craks es el padre de la informatica si si siiiiiiii");
                    restRecomendacion.setCreateDate(DateUtils.getDateIntervalFromTimeStamp(1350574775, getView().getContext()));
                    list.add(restRecomendacion);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestRecomendacion> result) {
                getView().setRecommendationsList(result);
            }
        };

        asyncLoader.start();
    }

}
