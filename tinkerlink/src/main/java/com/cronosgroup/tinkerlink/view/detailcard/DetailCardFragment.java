package com.cronosgroup.tinkerlink.view.detailcard;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.UpdateInfoCardEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.detailcard.DetailCardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.network.NetworkDialogFragment;

import org.greenrobot.eventbus.EventBus;


/**
 * Detail card Fragment
 */
public class DetailCardFragment extends MVPTinkerLinkFragment<DetailCardPresenter, DetailCardPresenter.View>
        implements DetailCardPresenter.View, DetailCardScreen.Listener {

    // Vars

    // Views
    private DetailCardScreen detailCardScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.create_card_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_publish) {
            getPresenter().createCard();
        }

        return super.onOptionsItemSelected(item);
    }


    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        detailCardScreen = new DetailCardScreen(getActivity());
        detailCardScreen.setListener(this);
        return detailCardScreen;
    }

    @Override
    protected DetailCardPresenter createPresenter() {
        return new DetailCardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected DetailCardPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {

    }

    //endregion

    //region ************** DetailCardPresenter.View **************

    @Override
    public RestPost getCardData() {
        return null;
    }

    //endregion

    //region ************** DetailCardScreen.Listener **************

    private void goToFormPage(int position) {
        EventBus.getDefault().post(new UpdateInfoCardEvent(position));
        getActivity().finish();
    }

    @Override
    public void onUpdateBudgetPressed() {
        goToFormPage(2);
    }

    @Override
    public void onUpdateSkillsPressed() {
        goToFormPage(1);
    }

    @Override
    public void onUpdateImagesPressed() {
        goToFormPage(2);
    }

    @Override
    public void onNetworkPressed() {
        addDialogFragment(NetworkDialogFragment.class, NetworkDialogFragment.CODE, null);
    }

    //endregion

}
