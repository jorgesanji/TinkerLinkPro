package com.cronosgroup.tinkerlink.presenter.profile;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContacto;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestProfile;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class ProfilePresenter extends TinkerLinkPresenter<ProfilePresenter.View> {

    // Vars

    /**
     * Profile listeners.
     */
    public interface View extends TinkerLinkPresenterView {
        void setContact(RestContacto contact);
    }

    //Actions

    public void getUserInfo() {

        getView().showLoading();

        AsyncLoader<RestContacto> asyncLoader = new AsyncLoader<RestContacto>() {
            @Override
            public RestContacto doInBackground() {

                RestProfile restProfile = new RestProfile();
                restProfile.setProfession("Fontanero");
                restProfile.setCity("Barcelona");
                restProfile.setCountry("España");

                RestUser restUser = new RestUser();
                restUser.setName("Jorge Sanmartin");
                restUser.setPhoto("http://qsrock.com/wp-content/uploads/2016/04/130699422.jpg");
                restUser.setProfile(restProfile);

                RestContacto restContacto = new RestContacto();
                restContacto.setUser(restUser);

                List<RestContacto> list = new ArrayList<>();

                for (int contacts = 0; contacts < 20; contacts++) {

                    RestUser restUser1 = new RestUser();
                    restUser1.setName("Eddy Samaniego");
                    restUser1.setPhoto("http://qsrock.com/wp-content/uploads/2016/04/130699422.jpg");
                    restUser1.setProfile(restProfile);

                    RestContacto contacto = new RestContacto();
                    contacto.setUser(restUser1);

                    list.add(contacto);
                }

                restContacto.setUsersCommon(list);

                return restContacto;
            }

            @Override
            public void postProcess(RestContacto result) {
                getView().setContact(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();
    }

    public void onLaunchImTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.TINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

    public void onLaunchSearchTinker() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, StackCardType.LINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
    }

}


