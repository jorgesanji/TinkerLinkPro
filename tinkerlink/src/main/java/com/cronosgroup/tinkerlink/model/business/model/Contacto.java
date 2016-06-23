/**
 * Clase que encapsula el objeto Contacto
 */
package com.cronosgroup.tinkerlink.model.business.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contacto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id = (long) -1;

    @SerializedName("_id")
    private String idWS = "";
	
	@SerializedName("usuario")
	private User usuario = new User();

	@SerializedName("orden")
	private Integer orden = 0;

	@SerializedName("aceptado")
	private Boolean aceptado = false;

	@SerializedName("offset")
	private Integer offset = 0;

    @SerializedName("numContactos")
    private Integer numContactos = 0;

    @SerializedName("numComunes")
    private Integer numComunes = 0;

    @SerializedName("comun")
    private Boolean comun = false;

    private List<Contacto> contactos = new ArrayList<Contacto>();

    private boolean peticionSolicitudAmistadEnvidad = false;

	public Contacto() {

	}

	public Contacto(long id) {
		this.id = id;
	}

	public Contacto(long id, User usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Contacto(long id, User usuario, Integer orden) {
		this.id = id;
		this.usuario = usuario;
		this.orden = orden;
	}

	public long getId() {
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

    public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Boolean getAceptado() {
		return aceptado;
	}

	public void setAceptado(Boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
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

    public Boolean getComun() {
        return comun;
    }

    public void setComun(Boolean comun) {
        this.comun = comun;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean isPeticionSolicitudAmistadEnvidad() {
        return peticionSolicitudAmistadEnvidad;
    }

    public void setPeticionSolicitudAmistadEnvidad(boolean peticionSolicitudAmistadEnvidad) {
        this.peticionSolicitudAmistadEnvidad = peticionSolicitudAmistadEnvidad;
    }
}
