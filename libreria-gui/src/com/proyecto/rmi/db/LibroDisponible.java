package com.proyecto.rmi.db;

import java.io.Serializable;
import java.util.Date;

public class LibroDisponible implements Serializable{
	 
	private static final long serialVersionUID = -3248208415162842592L;
	private int id;
	private int libroId;
	private String isbn;
	private Date fechaRegistro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLibroId() {
		return libroId;
	}
	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

