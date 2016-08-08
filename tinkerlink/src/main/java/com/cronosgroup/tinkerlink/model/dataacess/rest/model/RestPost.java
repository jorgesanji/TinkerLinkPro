package com.cronosgroup.tinkerlink.model.dataacess.rest.model;

import android.text.TextUtils;

import com.cronosgroup.core.rest.RestBase;
import com.cronosgroup.tinkerlink.enums.PostStatus;
import com.cronosgroup.tinkerlink.enums.PostType;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by aaronasencio on 12/05/15.
 */
public class RestPost extends RestBase{

    @SerializedName("_id")
    private String id = "";

    @SerializedName("usuario")
    private RestContacto user = new RestContacto();

    @SerializedName("usuario2")
    private RestContacto contacto = null;

    @SerializedName("tipo")

    private String tipo = "tinker";

    @SerializedName("fecha")
    private Date fecha = null;

    @SerializedName("likes")
    private Integer likes = 0;

    @SerializedName("usersLike")
    private List<String> usersLike = new ArrayList<String>();

    @SerializedName("usersCompartido")
    private List<String> usersCompartido = new ArrayList<String>();

    @SerializedName("visto")
    private Integer numeroVisualizaciones = 0;

    @SerializedName("shares")
    private Integer numeroShares = 0;

    @SerializedName("texto")
    private String texto = "";

    @SerializedName("fotos")
    private List<String> fotoString = new ArrayList<String>();

    @SerializedName("post")
    private RestPost post = null;

    @SerializedName("pais")
    private String pais = "";

    @SerializedName("ciudad")
    private String ciudad = "";

    @SerializedName("latitude")
    private double latitude = 0;

    @SerializedName("longitude")
    private double longitude = 0;

    @SerializedName("categoria")
    private String categoria = "";

    @SerializedName("descripcion")
    private String descripcion = "";

    @SerializedName("salario")
    private String costeAproximado = "";

    @SerializedName("tipoSalario")
    private String tipoCambio = "";

    @SerializedName("habilidades")
    private List<String> habilidades = new ArrayList<String>();

    @SerializedName("duracion")
    private String tipoProyecto = "";

    @SerializedName("profesion")
    private String profesion = "";

    @SerializedName("experiencia")
    private String experiencia = "";

    @SerializedName("habilities")
    private String intervalo = "";

    @SerializedName("compartido")
    private Boolean compartido = false;

    @SerializedName("like")
    private Boolean like = false;

    @SerializedName("linkUrl")
    private String linkUrl = "";

    @SerializedName("linkTitle")
    private String linkTitle = "";

    @SerializedName("linkDescription")
    private String linkDescription = "";

    @SerializedName("linkImage")
    private String linkImage = "";

    private PostStatus status = PostStatus.PUBLISHED;

    private String habilidadesStringFormat = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestContacto getUser() {
        return user;
    }

    public void setUser(RestContacto user) {
        this.user = user;
    }

    public RestContacto getContacto() {
        return contacto;
    }

    public void setContacto(RestContacto contacto) {
        this.contacto = contacto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<String> getUsersLike() {
        return usersLike;
    }

    public void setUsersLike(List<String> usersLike) {
        this.usersLike = usersLike;
    }

    public List<String> getUsersCompartido() {
        return usersCompartido;
    }

    public void setUsersCompartido(List<String> usersCompartido) {
        this.usersCompartido = usersCompartido;
    }

    public Integer getNumeroVisualizaciones() {
        return numeroVisualizaciones;
    }

    public void setNumeroVisualizaciones(Integer numeroVisualizaciones) {
        this.numeroVisualizaciones = numeroVisualizaciones;
    }

    public Integer getNumeroShares() {
        return numeroShares;
    }

    public void setNumeroShares(Integer numeroShares) {
        this.numeroShares = numeroShares;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getFotoString() {
        return fotoString;
    }

    public void setFotoString(List<String> fotoString) {
        this.fotoString = fotoString;
    }

    public RestPost getPost() {
        return post;
    }

    public void setPost(RestPost post) {
        this.post = post;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosteAproximado() {
        return costeAproximado;
    }

    public void setCosteAproximado(String costeAproximado) {
        this.costeAproximado = costeAproximado;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public Boolean getCompartido() {
        return compartido;
    }

    public void setCompartido(Boolean compartido) {
        this.compartido = compartido;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    public PostType getTypePost() {
        PostType type = PostType.typeFromString(getTipo());
        if (type == PostType.SHARE) {
            type = PostType.typeFromString(getTipo() + "_" + getPost().getTipo());
        }
        return type;
    }

    public void setHabilidadesStringFormat(String habilidadesStringFormat) {
        this.habilidadesStringFormat = habilidadesStringFormat;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getHabilidadesStringFormat() {

        if (habilidadesStringFormat == null && habilidades != null) {
            habilidadesStringFormat = TextUtils.join(",#", habilidades).replace("\"", "");
        }

        return habilidadesStringFormat;
    }

    public String getLocation() {
        return (getCiudad() == null || getCiudad().isEmpty()) ? ((getPais() == null || getPais().isEmpty()) ? null : getPais()) : getCiudad() + ", " + getPais();
    }

    public boolean isShared() {
        return (getTypePost() == PostType.SHARE_TINKER ||
                getTypePost() == PostType.SHARE_LINKER ||
                getTypePost() == PostType.SHARE_RECOMMENDATION ||
                getTypePost() == PostType.SHARE_STATUS ||
                getTypePost() == PostType.SHARE_UPDATEPHOTO ||
                getTypePost() == PostType.SHARE_UPDATEPROFILE);
    }
}
