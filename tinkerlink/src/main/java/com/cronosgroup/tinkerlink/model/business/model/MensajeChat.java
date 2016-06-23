/**
 * Clase que encapsula el objeto mensaje de Chat
 */
package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MensajeChat implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idMensaje = (long) -1;

    @SerializedName("id")
    private Long idWS = null;

    @SerializedName("idChat")
    private Long idChat = null;

    @SerializedName("chat")
    private Chat chat = new Chat();

    @SerializedName("usuario")
    private User usuario = new User();

    @SerializedName("mensaje")
    private String mensaje = new String();

    @SerializedName("fecha")
    private String fecha = new String();

    @SerializedName("habilities")
    private String intervalo = new String();

    @SerializedName("readed")
    private Boolean leido = false;

    public MensajeChat(Long idMensaje, Long idWS, Long idChat, Chat chat, User usuario, String mensaje,
                       String fecha, String intervalo, Boolean leido) {
        super();
        this.idMensaje = idMensaje;
        this.idWS = idWS;
        this.idChat = idChat;
        this.chat = chat;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.intervalo = intervalo;
        this.leido = leido;
    }

    public MensajeChat() {
        this((long) -1, (long) -1, (long) -1, new Chat(), new User(), "", "", "", false);
    }

    public Long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Long getIdWS() {
        return idWS;
    }

    public void setIdWS(Long idWS) {
        this.idWS = idWS;
    }

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

}
