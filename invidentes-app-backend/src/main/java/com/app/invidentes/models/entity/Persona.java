package com.app.invidentes.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Clase que representa a las personas que realizan pqrs
 * o brindan asesoria brindando solucion a una pqrs
 * @author pedro
 *
 */
@Entity
@Table(name = "PERSONAS")
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que representa el identificador de la persona
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	/**
	 * Atributo que representa el nombre de la persona
	 */
	@Column(name = "nombres")
	public String nombre;

	/**
	 * Atributo que representa el apellido de la persona
	 */
	@Column(name = "apellidos")
	private String apellido;

	/**
	 * Atributo que representa el num de identificacion de la persona
	 */
	@Column(name = "identificacion")
	public String numIdentificacion;

	/**
	 * Atributo que representa la direccion de residencia de la persona
	 */
	@Column(name = "direccion_residencia")
	public String direccion;

	/**
	 * Contructor de la clase persona
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
