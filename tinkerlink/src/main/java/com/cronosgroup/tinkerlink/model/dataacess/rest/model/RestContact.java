/**
 * Clase que encapsula el objeto Contacto
 */
package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestContact extends RestBase {

    public enum StatusContact {
        REQUESTEDTO(0),
        REQUESTEDFROM(1),
        ACCEPTED(2),
        NONE(-1);

        private final int state;

        StatusContact(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }

        public static StatusContact statusFromId(int state) {
            if (state == 0) {
                return NONE;
            } else if (state == (REQUESTEDFROM.getState())) {
                return REQUESTEDFROM;
            } else if (state == (REQUESTEDTO.getState())) {
                return REQUESTEDTO;
            } else if (state == (ACCEPTED.getState())) {
                return ACCEPTED;
            } else {
                return NONE;
            }
        }
    }

    @SerializedName("id")
    private String id = "";

    @SerializedName("user")
    private RestUser user = new RestUser();

    @SerializedName("order")
    private Integer order = 0;

    @SerializedName("commonContacts")
    private List<RestContact> commonContacts = new ArrayList<>();

    @SerializedName("dateConnected")
    private Date dateConnected;

    @SerializedName("dateRequested")
    private Date dateRequested;

    @SerializedName("status")
    private int status = StatusContact.NONE.ordinal();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestUser getUser() {
        return user;
    }

    public void setUsuario(RestUser usuario) {
        this.user = usuario;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }

    public List<RestContact> getCommonContacts() {
        return commonContacts;
    }

    public void setCommonContacts(List<RestContact> commonContacts) {
        this.commonContacts = commonContacts;
    }

    public Date getDateConnected() {
        return dateConnected;
    }

    public void setDateConnected(Date dateConnected) {
        this.dateConnected = dateConnected;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public boolean isAccepted() {
        return getStatus() == StatusContact.ACCEPTED.getState();
    }

    public boolean meRequestedLikeContact() {
        return getStatus() == StatusContact.REQUESTEDTO.getState();
    }

    public boolean wasRequestedToMeLikeContact() {
        return getStatus() == StatusContact.REQUESTEDFROM.getState();
    }

    public boolean isTinkerLinkUser() {
        return getOrder() != -1;
    }
}
