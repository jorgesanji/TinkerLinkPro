package com.cronosgroup.tinkerlink.presenter.detailcard;

import com.cronosgroup.tinkerlink.model.dataacess.database.entities.TLCard;
import com.cronosgroup.tinkerlink.model.dataacess.database.manager.CardManager;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenter;
import com.cronosgroup.tinkerlink.presenter.base.TinkerLinkPresenterView;

import java.util.List;

/**
 * Created by jorgesanmartin on 7/15/16.
 */
public class DetailStackPresenter extends TinkerLinkPresenter<DetailStackPresenter.View> {

    /**
     * DetailStack View.
     */
    public interface View extends TinkerLinkPresenterView {
        void setCards(List<TLCard> list);

        String getIdCard();

        void setCurrentCardVisible(int index);
    }

    // public methods

    public void getCards() {
        CardManager cardManager = new CardManager();
        List<TLCard> list = cardManager.getAll();
        TLCard card = cardManager.getCard(getView().getIdCard());
        int position = list.indexOf(card);
        getView().setCards(list);
        getView().setCurrentCardVisible(0);
    }

}

