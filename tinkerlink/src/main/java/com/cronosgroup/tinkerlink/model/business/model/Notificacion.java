/**
 * Clase que encapsula el objeto Notificacion
 */
package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;


    // 1 invitacion aceptada
    // 2 invitacion de contacto recibida
    // 3 invitacion pendiente de aceptacion o cancelacion por parte del usuario
    // receptor
    // 4 invitacion denegada
    // 5 invitacion rechazada(por parte del que rechaza)
    // 6 invitacion aceptada(por parte del que acepta)
    // 7 contacto desasignado (para el que es desasignado)
    // 8 contacto desasignado (para el que desasigna
    public static final String NOTIFICACION_TIPO1 = "1";
    public static final String NOTIFICACION_TIPO2 = "2";
    public static final String NOTIFICACION_TIPO3 = "3";
    public static final String NOTIFICACION_TIPO4 = "4";
    public static final String NOTIFICACION_TIPO5 = "5";
    public static final String NOTIFICACION_TIPO6 = "6";
    public static final String NOTIFICACION_TIPO7 = "7";
    public static final String NOTIFICACION_TIPO8 = "8";
    public static final String NOTIFICACION_TIPO_HE_RECOMENDADO= "9";
    public static final String NOTIFICACION_TIPO_ME_HAN_RECOMENDADO= "10";
    public static final String NOTIFICACION_TIPO_ME_HAN_ACEPTADO_LA_RECOMENDACION = "11";
    public static final String NOTIFICACION_TIPO_HE_ACEPTADO_LA_RECOMENDACION = "12";
    public static final String NOTIFICACION_TIPO_ME_HAN_RECHAZADO_LA_RECOMENDACION = "13";
    public static final String NOTIFICACION_TIPO_HE_RECHAZADO_LA_RECOMENDACION = "14";
    public static final String NOTIFICACION_TIPO_HE_CANCELADO_LA_RECOMENDACION = "15";
    public static final String NOTIFICACION_TIPO_HE_COMPARTIDO_POST = "16";
    public static final String NOTIFICACION_TIPO_ME_HAN_COMPARTIDO_POST = "17";
    public static final String NOTIFICACION_TIPO_HAS_COMPARTIDO_PERFIL = "18";
    public static final String NOTIFICACION_TIPO_ME_HAN_COMPARTIDO_PERFIL = "19";
    public static final String NOTIFICACION_TIPO_PETICION_SOLICITUD_RECOMENDACION = "21";
    public static final String NOTIFICACION_TIPO_RECEPCION_SOLICITUD_RECOMENDACION = "22";

    public static final String NOTIFICACION_TIPO_USUARIO_DUPLICADO = "20";

    @SerializedName("id")
    private Long id = (long) -1;

    @SerializedName("idWS")
    private Long idWS = (long) -1;

    @SerializedName("idNotificacion")
    private Long idNotificacion =  (long) -1;

    @SerializedName("tipo")
    private Integer tipo = 0;

    @SerializedName("usuarioNotificacion")
    private User usuario = new User();

    @SerializedName("fecha")
    private String fecha;

    @SerializedName("habilities")
    private String intervalo = "";

    @SerializedName("leida")
    private Boolean leida = false;

    @SerializedName("texto")
    private String texto = "";


    public Notificacion() {

    }

    public Notificacion(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Long getIdWS() {
        return idWS;
    }

    public void setIdWS(Long idWS) {
        this.idWS = idWS;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
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

    public Boolean getLeida() {
        return leida;
    }

    public void setLeida(Boolean leida) {
        this.leida = leida;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
