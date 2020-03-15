package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Clase que representa las PQRS que relicen las personas
 * @author pedro
 *
 */
@Entity
@Table(name = "PQRS")
public class Pqrs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Atributo que representa el id de la entidad
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    /**
     * Atributo que representa la descripcion detallada de la problematica
     */
	private String descripcion;

    /**
     * Atributo que representa el tipo de informacion 
     * pregunta, queja, reclamo, sugerencia
     */
    @Enumerated(value = EnumType.STRING)
    private TipoPqrsEnum tipoPqrsEnum;

    /**
     * Lista de respuestas realizadas por los usuarios
     */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pqrs_id")
    private List<Respuesta> respuestas;
    /**
     * Atrbuto que representa a la persona quien realiza la pregunta queja reclamo o sugerencia
     */
	@JsonIgnoreProperties(value={"facturas", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
    
    /**
     * Atributo que representa la fecha de creacion de la pqrs
     */
    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
    
    /**
     * Atributo que representa la url de los archivos
     */
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pqrs_id")
    private List<Recurso> recursos;
    
    public Pqrs() {
		// TODO Auto-generated constructor stub
	}
    
    /**
	 * Metodo que se encarga de agrgar la fecha de creacion de la PQRS 
	 */
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = LocalDate.now();
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

	public TipoPqrsEnum getTipoPqrsEnum() {
		return tipoPqrsEnum;
	}

	public void setTipoPqrsEnum(TipoPqrsEnum tipoPqrsEnum) {
		this.tipoPqrsEnum = tipoPqrsEnum;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((recursos == null) ? 0 : recursos.hashCode());
		result = prime * result + ((respuestas == null) ? 0 : respuestas.hashCode());
		result = prime * result + ((tipoPqrsEnum == null) ? 0 : tipoPqrsEnum.hashCode());
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
		Pqrs other = (Pqrs) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (recursos == null) {
			if (other.recursos != null)
				return false;
		} else if (!recursos.equals(other.recursos))
			return false;
		if (respuestas == null) {
			if (other.respuestas != null)
				return false;
		} else if (!respuestas.equals(other.respuestas))
			return false;
		if (tipoPqrsEnum != other.tipoPqrsEnum)
			return false;
		return true;
	}
	
	
	
}
