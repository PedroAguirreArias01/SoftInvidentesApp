package com.app.invidentes.models.services;

import java.util.List;

import com.app.invidentes.models.entity.Colaborador;
import com.app.invidentes.models.entity.ResultadoDTO;
/**
 * Interfaz los contiene los metodos del crud
 * @author pedro
 *
 */
public interface IColaboradorService {

	/**
	 * Metodo que obtiene todos los colaboradores
	 * @return
	 */
	public List<Colaborador> findAll();
	
	/**
	 * Metodo encargado de crear el colaborador
	 */
	public ResultadoDTO crearColaborador(Colaborador colaborador);
	
	/**
	 * Metodo encarga do de eliminar un colaborador
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Metodo encargado de obtener colaborador por id
	 * @param id
	 * @return
	 */
	public Colaborador findById(Long id);
	
}
