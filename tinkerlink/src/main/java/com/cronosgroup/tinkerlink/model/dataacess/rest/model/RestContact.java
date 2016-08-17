/**
 * Clase que encapsula el objeto Contacto
 */
package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RestContact extends RestBase {

    public enum StatusContact {
        REQUESTEDTO("requestedTo"),
        REQUESTEDFROM("requestedFrom"),
        ACCEPTED("accepted"),
        NONE("none");

        private final String state;

        StatusContact(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public static StatusContact statusFromString(String state) {
            if (state == null) {
                return NONE;
            } else if (state.equalsIgnoreCase(REQUESTEDFROM.getState())) {
                return REQUESTEDFROM;
            } else if (state.equalsIgnoreCase(REQUESTEDTO.getState())) {
                return REQUESTEDTO;
            } else if (state.equalsIgnoreCase(ACCEPTED.getState())) {
                return ACCEPTED;
            } else {
                return NONE;
            }
        }
    }

    @SerializedName("_id")
    private String id = "";

    @SerializedName("idNotificacion")
    private long idNotificacion = 0;

    @SerializedName("usuario")
    private RestUser user = new RestUser();

    @SerializedName("orden")
    private Integer orden = 0;

    @SerializedName("usersCommon")
    private List<RestContact> usersCommon = new ArrayList<>();

    @SerializedName("dateConnected")
    private String dateConnected = "";

    @SerializedName("dateRequested")
    private String dateRequested = "";

    @SerializedName("status")
    private String status = "";

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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public void setUser(RestUser user) {
        this.user = user;
    }

    public List<RestContact> getUsersCommon() {
        return usersCommon;
    }

    public void setUsersCommon(List<RestContact> usersCommon) {
        this.usersCommon = usersCommon;
    }

    public String getDateConnected() {
        return dateConnected;
    }

    public void setDateConnected(String dateConnected) {
        this.dateConnected = dateConnected;
    }

    public String getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(String dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public boolean isAccepted() {
        return StatusContact.statusFromString(getStatus()).equals(StatusContact.ACCEPTED);
    }

    public boolean meRequestedLikeContact() {
        return StatusContact.statusFromString(getStatus()).equals(StatusContact.REQUESTEDTO);
    }

    public boolean wasRequestedToMeLikeContact() {
        return StatusContact.statusFromString(getStatus()).equals(StatusContact.REQUESTEDFROM);
    }

    public boolean isTinkerLinkUser() {
        return getOrden() != -1;
    }
}
