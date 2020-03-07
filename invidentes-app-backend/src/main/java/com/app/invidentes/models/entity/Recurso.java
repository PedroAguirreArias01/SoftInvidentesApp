package com.app.invidentes.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "recursos")
public class Recurso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Atributo que representa el id del recurso 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Atribut que representa el nombe del recurso
	 */
	private String nombre;
	/**
	 * Atribut que representa el tipo del recurso
	 */
	private String tipo;
	/**
	 * Atributo que representa la data del recurso
	 */
	@Lob
	private Byte[] data;
	
	public Recurso() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que obtiene el id de un recurso
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Metodo que se encarga de modificar el id del recurso
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Metodo que se encarga de obtener el nombre del recurso
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que se encarga de modificar el nombre del recurso
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo que se encarga de modificar el nombre del recurso
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Metodo que se encraga de modificar el tipo de recurso
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Metodo que obtiene la data del recurso
	 * @return
	 */
	public Byte[] getData() {
		return data;
	}
	/**
	 * Metodo que modifica la data del recurso
	 * @param data
	 */
	public void setData(Byte[] data) {
		this.data = data;
	}
	
	
}
