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
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	// -----------------------------------------------------------------------
	/**
	 * Metodo que se encarga de agrgar el estado al colaborador
	 */
	@PrePersist
	public void prePersist() {
		this.estadoEnum = EstadoEnum.ACTIVO;
		this.createAt = LocalDate.now();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((contrasena == null) ? 0 : contrasena.hashCode());
		result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
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
		if (estadoEnum != other.estadoEnum)
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
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
