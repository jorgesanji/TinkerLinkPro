package com.cronosgroup.tinkerlink.model.business.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class User {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    private Long id = (long) -1;

    @SerializedName("_id")
    private String idWS = "";

    @SerializedName("nombreCompleto")
    private String nombreCompleto = "";

    @SerializedName("cumpleanos")
    private String cumpleanos = "";

    @SerializedName("sexo")
    private String sexo = "";

    @SerializedName("password")
    private String password = "";

    @SerializedName("telefono")
    private String telefono = "";

    @SerializedName("codigoActivacion")
    private String codigoActivacion = "";

    @SerializedName("email")
    private String email = "";

    @SerializedName("foto")
    private String fotoString = "";

    private Bitmap fotoBitmap = null;

    @SerializedName("perfil")
    private Perfil perfil = new Perfil();

    @SerializedName("contactos")
    private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    @SerializedName("notificaciones")
    private ArrayList<Notificacion> notificaciones = new ArrayList<Notificacion>();

    @SerializedName("conversaciones")
    private ArrayList<Chat> conversaciones = new ArrayList<Chat>();

    @SerializedName("onPosts")
    private ArrayList<Post> posts = new ArrayList<Post>();

    @SerializedName("tinker")
    private Integer tinkers;

    @SerializedName("linker")
    private Integer linkers;

    @SerializedName("numContactos")
    private Integer numContactos;

    @SerializedName("numComunes")
    private Integer numComunes;

    @SerializedName("activo")
    private Boolean activo;

    @SerializedName("duplicado")
    private Boolean duplicado;

    private String thumbnailPath = "";

    private String originalPath = "";

    private String originalProfilePath = "";

    private String originalCroppedPath = "";

    private String postPath = "";

    private ArrayList<String> fotos = new ArrayList<String>();

    public User() {

    }

    public User(String codigoActivacion, Long id, String idWS, String nombreCompleto, String cumpleanos, String sexo, String password,
                String telefono, String fotoString, Bitmap fotoBitmap, String email, Perfil perfil,
                ArrayList<Contacto> contactos, ArrayList<Notificacion> notificaciones,
                ArrayList<Chat> conversaciones, ArrayList<Post> posts, Integer tinkers, Integer linkers,
                Integer numContactos, Integer numComunes,
                Boolean activo, Boolean duplicado) {
        this.codigoActivacion = codigoActivacion;
        this.id = id;
        this.idWS = idWS;
        this.nombreCompleto = nombreCompleto;
        this.cumpleanos = cumpleanos;
        this.sexo = sexo;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
        this.fotoString = fotoString;
        this.fotoBitmap = fotoBitmap;
        this.perfil = perfil;
        this.contactos = contactos;
        this.notificaciones = notificaciones;
        this.conversaciones = conversaciones;
        this.posts = posts;
        this.tinkers = tinkers;
        this.linkers = linkers;
        this.numContactos = numContactos;
        this.numComunes = numComunes;
        this.activo = activo;
        this.duplicado = duplicado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdWS() {
        return idWS;
    }

    public void setIdWS(String idWS) {
        this.idWS = idWS;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoString() {
        return fotoString;
    }

    public void setFotoString(String fotoString) {
        this.fotoString = fotoString;
    }

    public Bitmap getFotoBitmap() {
        return fotoBitmap;
    }

    public void setFotoBitmap(Bitmap fotoBitmap) {
        this.fotoBitmap = fotoBitmap;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public ArrayList<Chat> getConversaciones() {
        return conversaciones;
    }

    public void setConversaciones(ArrayList<Chat> conversaciones) {
        this.conversaciones = conversaciones;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Integer getTinkers() {
        return tinkers;
    }

    public void setTinkers(Integer tinkers) {
        this.tinkers = tinkers;
    }

    public Integer getLinkers() {
        return linkers;
    }

    public void setLinkers(Integer linkers) {
        this.linkers = linkers;
    }

    public Integer getNumContactos() {
        return numContactos;
    }

    public void setNumContactos(Integer numContactos) {
        this.numContactos = numContactos;
    }

    public Integer getNumComunes() {
        return numComunes;
    }

    public void setNumComunes(Integer numComunes) {
        this.numComunes = numComunes;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<String> fotos) {
        this.fotos = fotos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getDuplicado() {
        return duplicado;
    }

    public void setDuplicado(Boolean duplicado) {
        this.duplicado = duplicado;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getOriginalProfilePath() {
        return originalProfilePath;
    }

    public void setOriginalProfilePath(String originalProfilePath) {
        this.originalProfilePath = originalProfilePath;
    }

    public String getOriginalCroppedPath() {
        return originalCroppedPath;
    }

    public void setOriginalCroppedPath(String originalCroppedPath) {
        this.originalCroppedPath = originalCroppedPath;
    }

    public String getPostPath() {
        return postPath;
    }

    public void setPostPath(String postPath) {
        this.postPath = postPath;
    }
}
