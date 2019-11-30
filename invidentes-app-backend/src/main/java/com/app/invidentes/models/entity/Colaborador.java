package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Clase colaborador que contiene los atributos del colaborador
 * @author pedro
 *
 */
@Entity
@Table(name = "COLABORADOR")
public class Colaborador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * atributo que representa el id del colaborador
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Atributo que representa el nombre del colaborador
     */
	@Column(name = "nombre")
    public String nombre;
    /**
     * Atributo que representa el apellido del colaborador
     */
	@Column(name = "apellido")
    public String apellido;
    /**
     * Atributo que representa la fecha de creacion del colaborador 
     */
	@Column(name = "fecha_creacion")
    public LocalDate createAt;
    /**
     * Atributo que representa el email del colaborador
     */
	@Column(name = "correo")
    public String email;
    /**
     * Atributo que representa el usuario con el que iniciara sesion el colaborador
     */
	@Column(name = "nombre_usuario")
    public String usuario;
    /**
     * Atributo que representa la contraseña del colaborador
     */
	@Column(name = "password")
    public String password;
    /**
     * Contructor de la calse colaborador
     */
    public Colaborador() {
    	this.createAt = LocalDate.now();
	}
    
    /**
     * Metodo encargado de retornar el id del colaborador 
     * @return id
     */
	public Long getId() {
		return id;
	}
	/**
	 * Metodo que modifica el atributo id del colaborador
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 *Metodo que retorna el nombre del colaborador 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que modifica el atributo nombre del colaborador
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que retorna el apellido 
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo que modifica el apellido 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo que obtiene la fecha de creacion del colaborador
	 * @return
	 */
	public LocalDate getCreateAt() {
		return createAt;
	}
	/**
	 * Metodo que modifica la fecha de creacion del colaborador
	 * @param createAt
	 */
	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}
	/**
	 * Metodo que obtiene el email del colaborador
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo que modifica el email del colaborador
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodo que obtiene el usuario del colaborador
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * Metodo que modifica el usuario del colaborador
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo que obtiene la password del colaborador
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Metodo que modifica el password del colaborador
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    
}
