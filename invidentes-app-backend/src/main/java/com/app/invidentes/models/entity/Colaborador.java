package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
/**
 * Clase colaborador que contiene los atributos del colaborador
 * @author pedro
 *
 */
@Entity
@Table(name = "COLABORADORES")
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
	@Column(name = "create_at")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (createAt == null) {
			if (other.createAt != null)
				return false;
		} else if (!createAt.equals(other.createAt))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}
