package com.app.invidentes.interfaceService;

import java.util.List;

import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.entity.TipoNormativa;

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
	public Normatividad crear(Normatividad normatividad);
	
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
	
	/**
	 * Metodo que obtiene una lista de normatividad por el tipo por ejemplo leyes--> deccretos
	 * Ordenanzas--Acuerdos dado el id de dicho tipo de normatividad
	 * @param id
	 * @return
	 */
	public List<Normatividad> obtenerNormatividadPorTipo(TipoNormativa tipoNormativa);
}
