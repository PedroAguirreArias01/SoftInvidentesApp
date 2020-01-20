package com.app.invidentes.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Clase 
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
    private Persona persona;
    
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
