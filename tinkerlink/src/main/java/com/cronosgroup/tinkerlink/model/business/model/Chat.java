/**
 * Clase que encapsula el objeto Chat
 */
package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idChat = (long) -1;

    @SerializedName("id")
    private Long idWS = null;

    @SerializedName("integrante1")
    private User integrante1 = new User();

    @SerializedName("integrante2")
    private User integrante2 = new User();

    @SerializedName("mensajes")
    private List<MensajeChat> mensajes = new ArrayList<MensajeChat>();


    public Chat(Long idWS, User integrante1, User integrante2,
                List<MensajeChat> mensajes) {
        super();
        this.idWS = idWS;
        this.integrante1 = integrante1;
        this.integrante2 = integrante2;
        this.mensajes = mensajes;
    }

    public Chat() {
        this((long) -1, new User(), new User(), new ArrayList<MensajeChat>());
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setId(Long idChat) {
        this.idChat = idChat;
    }

    public Long getIdWS() {
        return idWS;
    }

    public void setIdWS(Long idWS) {
        this.idWS = idWS;
    }

    public User getIntegrante1() {
        return integrante1;
    }

    public void setIntegrante1(User integrante1) {
        this.integrante1 = integrante1;
    }

    public User getIntegrante2() {
        return integrante2;
    }

    public void setIntegrante2(User integrante2) {
        this.integrante2 = integrante2;
    }

    public List<MensajeChat> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<MensajeChat> mensajes) {
        this.mensajes = mensajes;
    }


}