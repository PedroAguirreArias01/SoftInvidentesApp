package com.app.invidentes.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quienes_somos")
public class QuienesSomos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo", length = 10000)
	private String titulo;
	@Column(name = "descripcion", length = 10000)
	private String descripcion;
	//private Recurso img;
	
	public QuienesSomos() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**public Recurso getImg() {
		return img;
	}

	public void setImg(Recurso img) {
		this.img = img;
	}*/
	


}
