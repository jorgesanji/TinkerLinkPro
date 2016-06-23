package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgesanmartin on 15/10/15.
 */
public class Login {

    @SerializedName("comprobado")
    private Boolean comprobado = false;

    @SerializedName("usuario")
    private User usuario = new User();

    @SerializedName("codigoCaducado")
    private Boolean codigoCaducado = false;

    @SerializedName("thumbnailPath")
    private String thumbnailPath = "";

    @SerializedName("originalPath")
    private String originalPath = "";

    @SerializedName("originalProfilePath")
    private String originalProfilePath = "";

    @SerializedName("originalCroppedPath")
    private String originalCroppedPath = "";

    @SerializedName("postPath")
    private String postPath = "";

    public Login() {

    }

    public Login(Boolean comprobado, User usuario, Boolean codigoCaducado,
                 String thumbnailPath, String originalPath) {
        this.comprobado = comprobado;
        this.usuario = usuario;
        this.codigoCaducado = codigoCaducado;
        this.thumbnailPath = thumbnailPath;
        this.originalPath = originalPath;
    }

    public Boolean getComprobado() {
        return comprobado;
    }

    public void setComprobado(Boolean comprobado) {
        this.comprobado = comprobado;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Boolean getCodigoCaducado() {
        return codigoCaducado;
    }

    public void setCodigoCaducado(Boolean codigoCaducado) {
        this.codigoCaducado = codigoCaducado;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
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
