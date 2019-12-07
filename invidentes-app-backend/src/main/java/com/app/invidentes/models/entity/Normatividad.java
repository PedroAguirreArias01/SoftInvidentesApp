package com.app.invidentes.models.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NORMATIVIDAD")
public class Normatividad {

	/**
	 * Atributo que representa el id de la informacion
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Atributo que representa el titulo de la ley o decreto
	 */
	private String titulo;
	/**
	 * Atributo que representa una pequennia descripcion de la informacion
	 */
	private String descripcion;
	/**
	 * Atributo que representa el contenido total de la informacion
	 */
	private String contenido;
	/**
	 * Atributo quue representa el tipo de informacion 
	 */
	@Enumerated(value = EnumType.STRING)
	private TipoNormativaEnum tipoNormativaEnum;
	
	/**
	 * Contructor de la calse normatividad
	 */
	public Normatividad() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public TipoNormativaEnum getTipoNormativaEnum() {
		return tipoNormativaEnum;
	}

	public void setTipoNormativaEnum(TipoNormativaEnum tipoNormativaEnum) {
		this.tipoNormativaEnum = tipoNormativaEnum;
	}
	
	
}
