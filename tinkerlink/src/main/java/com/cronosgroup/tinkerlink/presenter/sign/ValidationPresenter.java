package com.cronosgroup.tinkerlink.presenter.sign;

import android.os.Handler;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkDialogPresenterView;

/**
 * Validation sign presenter.
 */
public class ValidationPresenter extends TinkerLinkDialogPresenter<ValidationPresenter.View> {

    /**
     * Validation view.
     */
    public interface View extends TinkerLinkDialogPresenterView {
        String getValidationCode();

        void validateUser(RestUser restUser);
    }


    //region **************  View Actions **************

    public void checkCode() {
        String code = getView().getValidationCode();
        getView().showLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView().getActivity() != null) {
                    getView().validateUser(null);
                    getView().hideLoading();
                }
            }
        }, 3000);


//        if (code.length() == 6) {
//            getView().showLoading();
//            UserUseCases.checkCode(code, new Callback<RestCode, RestError>() {
//
//                @Override
//                public void onResponse(RestCode restCode) {
//                    getView().hideLoading();
//                    getView().validateUser(restCode.getUser());
//                }
//
//                @Override
//                public void onErrorResponse(RestError error) {
//                    getView().hideLoading();
//                }
//
//            }, getView().getActivity());
//        }
    }


    //endregion
}
