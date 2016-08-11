package com.cronosgroup.tinkerlink.view.detailcard;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.cronosgroup.tinkerlink.R;
import com.cronosgroup.tinkerlink.event.UpdateInfoCardEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.presenter.detailcard.DetailCardPresenter;
import com.cronosgroup.tinkerlink.utils.TLMMenuBuilder;
import com.cronosgroup.tinkerlink.utils.TLMMenuItem;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.dialog.network.NetworkDialogFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


/**
 * Detail card Fragment
 */
public class DetailCardFragment extends MVPTinkerLinkFragment<DetailCardPresenter, DetailCardPresenter.View>
        implements DetailCardPresenter.View, DetailCardScreen.Listener {

    // Vars
    private boolean isPublish;
    // Views
    private DetailCardScreen detailCardScreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isPublish = getArguments().getBoolean(DetailCardActivity.KEY_PUBLISH);
        setHasOptionsMenu(isPublish);
    }

    @Override
    protected List<TLMMenuBuilder> getMenuItems() {
        List<TLMMenuBuilder> menuItems = new ArrayList<>();
        menuItems.add(new TLMMenuItem().
                setId(R.id.action_publish).
                setTitle(R.string.create_card_publish).
                setTitleColor(R.color.text_white).
                setAction(TLMMenuItem.SHOW_ACTION));
        return menuItems;
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
        return new DetailCardPresenter();
    }

    @Override
    protected DetailCardPresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onDidAppear() {
        detailCardScreen.setAsPublishMode(isPublish);
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
    public void onUpdateImagesPressed() {
        EventBus.getDefault().post(new UpdateInfoCardEvent(0));
        getActivity().finish();
    }

    @Override
    public void onNetworkPressed() {
        addDialogFragment(NetworkDialogFragment.class, NetworkDialogFragment.CODE, null);
    }

    //endregion

}
