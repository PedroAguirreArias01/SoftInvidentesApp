package com.app.invidentes.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Clase que representa la tabla normatividad
 * @author pedro
 *
 */
@Entity
@Table(name = "NORMATIVIDAD")
public class Normatividad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributo que representa el id de la informacion
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Atributo que representa el titulo de la ley o decreto
	 */
	@Column(name="titulo")
	private String titulo;
	/**
	 * Atributo que representa una pequennia descripcion de la informacion
	 */
	@Column(name="descripcion", length = 256)
	@Size(min=3, max = 256)
	private String descripcion;
	/**
	 * Atributo que representa el contenido total de la informacion
	 */
	@Column(name="contenido", length = 100000)
	private String contenido;
	
	/**
	 * Atributo quue representa el tipo de informacion normativa
	 */
	@OneToOne(cascade = CascadeType.DETACH)
	private TipoNormativa tipoNormativa;
	
	/**
	 * Atrbuto que representa el usuario que creo dicha normatividad
	 */
	@JsonIgnoreProperties(value={"usuarios", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	/**
	 * Contructor de la calse normatividad
	 */
	public Normatividad() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que obtiene el id de la norma
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que modifica el id de la norma
	 * @param id
	 */
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoNormativa getTipoNormativa() {
		return tipoNormativa;
	}

	public void setTipoNormativa(TipoNormativa tipoNormativa) {
		this.tipoNormativa = tipoNormativa;
	}
	
	
}
