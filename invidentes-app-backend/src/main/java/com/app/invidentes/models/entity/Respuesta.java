package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Clase que representa las respuestas a las pqrs
 * @author pedro
 *
 */
@Entity
@Table(name = "RESPUESTAS")
public class Respuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Atrinuto que representa el id de la respuesta
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    /**
     * Atrinuto que representa la descripcion de la respuesta
     */
    public String descripcion;
    /**
     * Atributo que representa la calificacion realizada por el usuario a esa respuesta
     */
    public Long calificacion;
    
    /**
     * Atributo que representa la persona quien realizo la respuesta
     */
//    private Persona persona;
    
    /**
     * Atributo que representa la fecha de creacion de la respuesta
     */
    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
    
    /**
     * Atributo que representa los archivos asociados a la respuesta
     */
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "respuesta_id")
    private List<Recurso> recursos;
    
    public Respuesta() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}

//	public Persona getPersona() {
//		return persona;
//	}
//
//	public void setPersona(Persona persona) {
//		this.persona = persona;
//	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Recurso> getUrlRecursos() {
		return recursos;
	}

	public void setUrlRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
}
