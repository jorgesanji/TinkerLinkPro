package com.cronosgroup.tinkerlink.view.stack.main.adapter.card;

import android.os.Bundle;
import android.view.View;

import com.cronosgroup.tinkerlink.event.ShowOverLaySelectorEvent;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestPost;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecomendacion;
import com.cronosgroup.tinkerlink.presenter.stack.CardPresenter;
import com.cronosgroup.tinkerlink.view.ScreenNavigationHandler;
import com.cronosgroup.tinkerlink.view.base.MVPTinkerLinkFragment;
import com.cronosgroup.tinkerlink.view.stack.main.StackActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by jorgesanmartin on 6/22/16.
 */

public class CardFragment extends MVPTinkerLinkFragment<CardPresenter, CardPresenter.View> implements CardPresenter.View, CardScreen.Listener {

    public static final String CARD = "card";
    public static final String SHOW_CARD_DETAIL = "showDetail";

    private CardScreen cardScreen;
    private StackActivity.Stack stackType;
    private RestPost restPost;
    private boolean showDetail;

    //region **************  Fragment **************

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stackType = (StackActivity.Stack) getArguments().getSerializable(StackActivity.STACK_TYPE);
        restPost = (RestPost) getArguments().getSerializable(CARD);
        showDetail = getArguments().getBoolean(SHOW_CARD_DETAIL);
    }

    //region

    //region **************  MVPFragment **************

    @Override
    protected View getRootView() {
        cardScreen = new CardScreen(getContext(), this);
        return cardScreen;
    }

    @Override
    protected void onDidAppear() {

        getPresenter().getRecommendations();
//        boolean isLinker = (stackType.getStackType() == StackActivity.Stack.LINKER.getStackType());
//        RestUser restUser = restPost.getUser().getUser();
//        String urlImageProfile = getPresenter().getAppConfigManager().getPath(AppConfigManager.Path.PATH_IMAGE_PROFILE_THUMBNAIL) + restUser.getPhoto();
//        cardScreen.setUrlUser(urlImageProfile);
//        cardScreen.setUserName(restUser.getName());
//        cardScreen.setUserCardType(getResources().getString(isLinker ? R.string.card_seek : R.string.card_me));
//        cardScreen.setUserCardJob(restPost.getProfesion().toUpperCase());
//        cardScreen.setUserLocation(restPost.getLocation());
//        cardScreen.setOverlayColor(isLinker ? R.mipmap.linkercard_back : R.mipmap.tinkercard_back);
//        cardScreen.setUserCardDescription(restPost.getDescripcion());
//        cardScreen.showDetail(showDetail);
//        cardScreen.setUserSkills(restPost.getHabilidades());
//        cardScreen.setUserCommonContacts(restPost.getUser().getUsersCommon());
//        cardScreen.setStatus(restPost.getUser());
//        cardScreen.setUserNumberRecommendations(String.valueOf(restUser.getProfile().getRecommendations()));

    }

    //region

    //region **************  CardPresenter **************

    @Override
    protected CardPresenter createPresenter() {
        return new CardPresenter(ScreenNavigationHandler.getInstance());
    }

    @Override
    protected CardPresenter.View getPresenterView() {
        return this;
    }

    //region

    //region **************  CardPresenter.View **************

    @Override
    public StackActivity.Stack getType() {
        return stackType;
    }

    @Override
    public void setRecommendationsList(List<RestRecomendacion> list) {
        cardScreen.setRecommendationItems(list);
    }

    //region

    //region **************  CardScreen.Listener **************

    @Override
    public void showDetailPressed() {
        getPresenter().onLaunhDetailStack();
    }

    @Override
    public void onLongClikDone() {
        EventBus.getDefault().post(new ShowOverLaySelectorEvent());
    }

    //region

}
