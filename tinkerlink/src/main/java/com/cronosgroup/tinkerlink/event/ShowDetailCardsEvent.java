package com.cronosgroup.tinkerlink.event;

import com.cronosgroup.tinkerlink.model.dataacess.rest.model.RestCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgesanmartin on 6/28/16.
 */
public class ShowDetailCardsEvent {

    private List<RestCard> listCards = new ArrayList<>();

    public ShowDetailCardsEvent(RestCard card) {
        listCards.add(card);
    }

    public ShowDetailCardsEvent(List<RestCard> listCards) {
        this.listCards = listCards;
    }

    public List<RestCard> getListCards() {
        return listCards;
    }

    public void setListCards(List<RestCard> listCards) {
        this.listCards = listCards;
    }
}
