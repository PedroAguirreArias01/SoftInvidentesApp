package com.app.invidentes.interfaceService;

import java.util.List;

import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.ResultadoDTO;

/**
 * Interfaz que contiene los metodos del crus 
 * @author pedro
 *
 */
public interface INormatividadService {

	/**
	 * Metodo que obtiene toda la normatividad
	 * @return
	 */
	public List<Normatividad> findAll();
	
	/**
	 * Metodo encargado de crear la Normatividad
	 */
	public ResultadoDTO crear(Normatividad normatividad);
	
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
	public Normatividad findById(Long id);
}
