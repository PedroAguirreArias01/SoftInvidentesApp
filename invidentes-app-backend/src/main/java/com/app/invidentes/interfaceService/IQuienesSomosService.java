package com.app.invidentes.interfaceService;

import java.util.List;

import com.app.invidentes.models.entity.QuienesSomos;

public interface IQuienesSomosService {
	
	/**
	 * Metodo que obtiene toda la inforfmacion de quienes somos
	 * @return
	 */
	public List<QuienesSomos> findAll();
	
	/**
	 * Metodo encargado de crear la la informacion de quienes somos
	 */
	public QuienesSomos crear(QuienesSomos quienesSomos);
	
	/**
	 * Metodo encarga do de eliminar la informacion de quienes somos 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Metodo encargado de obtener los informacion de queienes por id
	 * @param id
	 * @return
	 */
	public QuienesSomos findById(Long id);

}
