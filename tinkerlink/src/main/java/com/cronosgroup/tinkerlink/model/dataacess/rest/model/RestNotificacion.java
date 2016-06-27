/**
 * Clase que encapsula el objeto Notificacion
 */
package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import com.cronosgroup.core.rest.RestBase;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestNotificacion extends RestBase {

    @SerializedName("_id")
    private String id = "";

    @SerializedName("usuario")
    private RestContacto user = new RestContacto();

    @SerializedName("idNotificacion")
    private long idNotificacion = 0;

    @SerializedName("tipo")
    private Integer tipo = 0;

    @SerializedName("fecha")
    private Date fecha;

    @SerializedName("leida")
    private Boolean leida = false;

    @SerializedName("done")
    private Boolean done = false;

    @SerializedName("habilities")
    private String intervalo = "";

    @SerializedName("texto")
    private String texto = "";

    @SerializedName("habilidades")
    private List<String> habilities = new ArrayList<>();

    public String getId() {
        return id;
    }

    public long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public RestContacto getUser() {
        return user;
    }

    public void setUsuario(RestContacto usuario) {
        this.user = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public List<String> getHabilities() {
        return habilities;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setHabilities(List<String> habilities) {
        this.habilities = habilities;
    }
}
