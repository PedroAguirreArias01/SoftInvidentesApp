package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Clase que representa a los usuarios del sistema
 * @author pedro
 *
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

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
	@Column(name = "nombre", nullable = false)
	private String nombre;
    /**
     * Atributo que representa el apellido del colaborador
     */
	@Column(name = "apellido")
	private String apellido;
    /**
     * Atributo que representa la fecha de creacion del colaborador 
     */
	@Column(name = "fecha_creacion")
	private LocalDate createAt;
    /**
     * Atributo que representa el email del colaborador
     */
	@Column(name = "correo", nullable = false, unique = true)
	private String email;
	
	/**
	 * Atributo que representa el estado del colaborador
	 */
	@Column(name="estado_colaborador")
	@Enumerated(value = EnumType.STRING)
	private EstadoEnum estadoEnum;


	// ------------------ INFORMACIÓN DE AUTENTICACIÓN------------------------

	@NotNull
	@Column(unique = true, nullable = false, length = 20)
	private String usuario;

	@NotNull
	@Column(length = 60)
	private String contrasena;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private Rol rol;
	

	// -----------------------------------------------------------------------
	/**
	 * Metodo que se encarga de agrgar el estado al colaborador
	 */
	@PrePersist
	public void prePersist() {
		this.estadoEnum = EstadoEnum.ACTIVO;
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

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	// ------------------ INFORMACIÓN DE AUTENTICACIÓN------------------------
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
