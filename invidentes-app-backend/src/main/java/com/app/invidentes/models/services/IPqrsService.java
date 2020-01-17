package com.app.invidentes.models.services;

import java.util.List;

import com.app.invidentes.models.entity.Pqrs;
import com.app.invidentes.models.entity.ResultadoDTO;

/**
 * Interfaz que contiene los metodos del crud
 * @author pedro
 *
 */
public interface IPqrsService {

	/**
	 * Metodo que obtiene toda la normatividad
	 * @return
	 */
	public List<Pqrs> findAll();
	
	/**
	 * Metodo encargado de crear pqrs
	 */
	public Pqrs save(Pqrs pqrs);
	
	/**
	 * Metodo encarga do de eliminar la Normatividad
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Metodo encargado de obtener Normatividad por id
	 * @param id
	 * @return
	 */
	public Pqrs findById(Long id);
}
