package com.cronosgroup.tinkerlink.model.business.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronasencio on 12/05/15.
 */
public class Post {


    private Long id = (long) -1;

    @SerializedName("idPost")
    private Long idWS = (long) -1;

    @SerializedName("tipo")
    private String tipo = "tinker";

    @SerializedName("usuario")
    private User usuario = new User();

    @SerializedName("habilities")
    private String intervalo = "";

    @SerializedName("pais")
    private String pais = "";

    @SerializedName("ciudad")
    private String ciudad = "";

    @SerializedName("categoria")
    private String categoria = "";

    @SerializedName("profesion")
    private String profesion = "";

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<String>();

    @SerializedName("descripcion")
    private String descripcion = "";

    @SerializedName("experiencia")
    private String experiencia = "";

    @SerializedName("duracion")
    private String tipoProyecto = "";

    @SerializedName("tipoSalario")
    private String tipoCambio = "";

    @SerializedName("salario")
    private String costeAproximado = "";

    @SerializedName("texto")
    private String estado = "";

    @SerializedName("visto")
    private Integer numeroVisualizaciones = 0;

    @SerializedName("fotos")
    private List<String> fotoString = new ArrayList<String>();

    @SerializedName("contacto")
    private Contacto contacto = new Contacto();

    @SerializedName("likes")
    private Integer likes = 0;

    @SerializedName("like")
    private Boolean like = false;

    @SerializedName("contactoComparte")
    private Contacto contactoComparte = new Contacto();

    @SerializedName("intervaloComparte")
    private String intervaloComparte = "";

    @SerializedName("idPostCompartido")
    private Long idPostCompartido = (long) -1;

    @SerializedName("shares")
    private Integer numeroShares = 0;

    @SerializedName("compartido")
    private Boolean compartido = false;

    private List<Bitmap> fotoBitmap = new ArrayList<Bitmap>();

    private boolean peticionSolicitudAmistadEnvidad = false;

    public Post() {

    }

    public Post(Long id, Long idWS, User usuario, String tipo, String pais, String ciudad, String categoria, String profesion,
                List<String> habilidades, String descripcion, String experiencia, String tipoProyecto,
                String tipoCambio, String costeAproximado, String estado, String intervalo, Integer numeroVisualizaciones,
                Integer likes, Boolean like, Contacto contactoComparte, String intervaloComparte, Long idPostCompartido, Integer numeroShares,
                boolean peticionSolicitudAmistadEnvidad) {
        this.id = id;
        this.idWS = idWS;
        this.tipo = tipo;
        this.usuario = usuario;
        this.intervalo = intervalo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.profesion = profesion;
        this.habilidades = habilidades;
        this.experiencia = experiencia;
        this.descripcion = descripcion;
        this.tipoProyecto = tipoProyecto;
        this.tipoCambio = tipoCambio;
        this.costeAproximado = costeAproximado;
        this.estado = estado;
        this.numeroVisualizaciones = numeroVisualizaciones;
        this.likes = likes;
        this.like = like;
        this.contactoComparte = contactoComparte;
        this.intervaloComparte = intervaloComparte;
        this.idPostCompartido = idPostCompartido;
        this.numeroShares = numeroShares;
        this.peticionSolicitudAmistadEnvidad = peticionSolicitudAmistadEnvidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdWS() {
        return idWS;
    }

    public void setIdWS(Long idWS) {
        this.idWS = idWS;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getCosteAproximado() {
        return costeAproximado;
    }

    public void setCosteAproximado(String costeAproximado) {
        this.costeAproximado = costeAproximado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumeroVisualizaciones() {
        return numeroVisualizaciones;
    }

    public void setNumeroVisualizaciones(Integer numeroVisualizaciones) {
        this.numeroVisualizaciones = numeroVisualizaciones;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<String> getFotoString() {
        return fotoString;
    }

    public void setFotoString(List<String> fotoString) {
        this.fotoString = fotoString;
    }

    public List<Bitmap> getFotoBitmap() {
        return fotoBitmap;
    }

    public void setFotoBitmap(List<Bitmap> fotoBitmap) {
        this.fotoBitmap = fotoBitmap;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Contacto getContactoComparte() {
        return contactoComparte;
    }

    public void setContactoComparte(Contacto contactoComparte) {
        this.contactoComparte = contactoComparte;
    }

    public String getIntervaloComparte() {
        return intervaloComparte;
    }

    public void setIntervaloComparte(String intervaloComparte) {
        this.intervaloComparte = intervaloComparte;
    }

    public Integer getNumeroShares() {
        return numeroShares;
    }

    public void setNumeroShares(Integer numeroShares) {
        this.numeroShares = numeroShares;
    }

    public Long getIdPostCompartido() {
        return idPostCompartido;
    }

    public void setIdPostCompartido(Long idPostCompartido) {
        this.idPostCompartido = idPostCompartido;
    }

    public boolean isPeticionSolicitudAmistadEnvidad() {
        return peticionSolicitudAmistadEnvidad;
    }

    public void setPeticionSolicitudAmistadEnvidad(boolean peticionSolicitudAmistadEnvidad) {
        this.peticionSolicitudAmistadEnvidad = peticionSolicitudAmistadEnvidad;
    }

    public Boolean getCompartido() {
        return compartido;
    }

    public void setCompartido(Boolean compartido) {
        this.compartido = compartido;
    }
}
