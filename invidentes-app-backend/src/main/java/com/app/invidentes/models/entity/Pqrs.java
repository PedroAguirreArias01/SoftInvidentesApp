package com.app.invidentes.models.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    @OneToMany
    private List<Respuesta> respuestas;
    /**
     * Atrbuto que representa a la persona quien realiza la pregunta queja reclamo o sugerencia
     */
    @OneToMany(fetch = FetchType.LAZY)
    private Persona persona;
    
    /**
     * Atributo que representa la fecha de creacion de la pqrs
     */
    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
    
    /**
     * Atributo que representa la url de los archivos
     */
    @Lob
    private Byte[] recursos;
    
    public Pqrs() {
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

	public Byte[] getRecursos() {
		return recursos;
	}

	public void setUrlRecursos(Byte[] recursos) {
		this.recursos = recursos;
	}
}
