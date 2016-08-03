package com.cronosgroup.tinkerlink.presenter.createcard;

import android.app.Activity;
import android.os.Bundle;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.view.detailcard.DetailCardActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class CreateCardPresenter extends TinkerLinkPresenter<CreateCardPresenter.View> {

    private final Actions listener;

    /**
     * CreateCard view.
     */
    public interface View extends TinkerLinkPresenterView {
        RestPost getCardData();
    }

    /**
     * ContCreateCard  actions.
     */
    public interface Actions {
        void onLaunchDetailCard(Activity activity, Bundle bundle);
    }

    /**
     * @param navigationListener
     */
    public CreateCardPresenter(Actions navigationListener) {
        this.listener = navigationListener;
    }

    // public methods

    public void onPrevisualizedPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getActivity().getIntent().getExtras().getSerializable(StackActivity.STACK_TYPE));
        bundle.putSerializable(DetailCardActivity.KEY_ITEM, getView().getCardData());
        bundle.putBoolean(DetailCardActivity.KEY_PUBLISH, true);
        listener.onLaunchDetailCard(getView().getActivity(), bundle);
    }
}
