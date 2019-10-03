package com.arquitecturajava.bo;

import java.io.Serializable;
import java.util.Date;

public class Noticia implements Serializable {
	
	private String titulo;
	private String autor;
	private Date fecha;	
	
	public Noticia() {
		super();
	}

	public Noticia(String titulo, String autor, Date fecha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
	}
	
	public Noticia(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
