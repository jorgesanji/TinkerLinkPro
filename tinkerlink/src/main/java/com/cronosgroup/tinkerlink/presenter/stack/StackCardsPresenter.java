package com.cronosgroup.tinkerlink.presenter.stack;

import android.os.Bundle;

import com.cronosgroup.tinkerlink.enums.StackCardType;
import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.CardManager;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestChat;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestContact;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestMessage;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestRecommendation;
import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestUser;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;
import com.cronosgroup.tinkerlink.utils.AsyncLoader;
import com.cronosgroup.tinkerlink.view.chatuser.ChatUserActivity;
import com.cronosgroup.tinkerlink.view.detailcard.DetailStackActivity;
import com.cronosgroup.tinkerlink.view.stack.StackActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jorgesanmartin on 3/6/16.
 */
public class StackCardsPresenter extends TinkerLinkPresenter<StackCardsPresenter.View> {

    /**
     * StackCardType listeners.
     */
    public interface View extends TinkerLinkPresenterView {

        int getCurrentIndexPage();

        List<TLCard> getItems();

        void setCards(List<TLCard> cars);

        boolean isFromUser();

        RestUser getUser();

        StackCardType getType();
    }


    //Public methods

    public void onSelectCardsType() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, (getView().getType().getStackType() == StackCardType.LINKER.getStackType()) ? StackCardType.TINKER : StackCardType.LINKER);
        navigation.onLaunchStack(getView().getActivity(), bundle);
        getView().getActivity().finish();
    }

    public void onLaunhDetailStack(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        bundle.putString(DetailStackActivity.KEY_ITEM, getView().getItems().get(position).getId());
        navigation.onLaunchDetailCard(getView().getActivity(), bundle);
    }

    public void getAllCards(String offset) {

        CardManager cardManager = new CardManager();
        cardManager.deleteAll();

        getView().showLoading();
        AsyncLoader<List<TLCard>> asyncLoader = new AsyncLoader<List<TLCard>>() {
            @Override
            public List<TLCard> doInBackground() {

                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<TLCard> list = new ArrayList<>();
                for (int posts = 0; posts < 10; posts++) {
                    TLCard tlCard = new TLCard();
                    tlCard.setId(posts + "");
                    tlCard.save();
                    list.add(tlCard);
                }

                return list;
            }

            @Override
            public void postProcess(List<TLCard> result) {
                getView().setCards(result);
                getView().hideLoading();
            }
        };

        asyncLoader.start();
    }

    public void showDetailCard() {
        Bundle bundle = new Bundle();
        bundle.putString(DetailStackActivity.KEY_ITEM, getView().getItems().get(getView().getCurrentIndexPage()).getId());
        bundle.putBoolean(DetailStackActivity.KEY_PUBLISH, false);
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchDetailCard(getView().getActivity(), bundle);
    }

    public void onSearchCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchCardsSearch(getView().getActivity(), bundle);
    }

    public void onCreateCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchCreateCard(getView().getActivity(), bundle);
    }

    public void onFilterCardsPressed() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(StackActivity.STACK_TYPE, getView().getType());
        navigation.onLaunchFilterCards(getView().getActivity(), bundle);
    }

    public void onWritteMessageSelected() {

        RestUser restUser = new RestUser();
        restUser.setName("Jorge Sanmartin");
        restUser.setPhoto("https://pixabay.com/static/uploads/photo/2016/03/28/12/35/cat-1285634_960_720.png");
        restUser.setProfession("Fontanero");

        RestContact restContact = new RestContact();
        restContact.setUser(restUser);

        RestChat restChat = new RestChat();
        restChat.setUser(restContact);

        List<RestMessage> listMessages = new ArrayList<>();

        RestMessage restMessage = new RestMessage();
        restMessage.setMensaje("Esto es una mentira");
        listMessages.add(restMessage);

        restChat.setMensajes(listMessages);

        Bundle bundle = new Bundle();
        bundle.putSerializable(ChatUserActivity.ITEMS_KEY, restChat);

        navigation.onLaunchChatUser(getView().getActivity(), bundle);
    }

    public void getRecommendations() {

        AsyncLoader<List<RestRecommendation>> asyncLoader = new AsyncLoader<List<RestRecommendation>>() {
            @Override
            public List<RestRecommendation> doInBackground() {
                List<RestRecommendation> list = new ArrayList<>();

                RestUser restUser = new RestUser();
                restUser.setName("Luisito");
                restUser.setPhoto("http://api.ning.com/files/3G-NNOsexAFFbCt-XN5LbraHbYlrzivPtxx39pnQ8w48JITkdWKLhPCFGwt4p7794nvVE97YYfqtSwVmiSLhl1jXxV4IfejV/Staindwallcopy.jpg");
                restUser.setProfession("Developer");

                for (int init = 0; init < 10; init++) {
                    RestRecommendation restRecomendacion = new RestRecommendation();
                    restRecomendacion.setUser(restUser);
                    restRecomendacion.setText("Es un crack de craks es el padre de la informatica si si siiiiiiii");
//                    restRecomendacion.setCreateDate(DateUtils.getDateIntervalFromTimeStamp(1350574775, getView().getContext()));
                    restRecomendacion.setCreateDate(new Date());
                    list.add(restRecomendacion);
                }

                return list;
            }

            @Override
            public void postProcess(List<RestRecommendation> result) {
            }
        };

        asyncLoader.start();
    }

    public void onLaunchProfilePressed() {
        navigation.onLaunchUserProfile(getView().getActivity(), null);
    }
}
