package com.app.invidentes.models.services;

import java.util.List;

import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.entity.Usuario;
/**
 * Interfaz los contiene los metodos del crud
 * @author pedro
 *
 */
public interface IUsuarioService {

	/**
	 * Metodo que obtiene todos los usuarios
	 * @return
	 */
	public List<Usuario> findAll();
	
	/**
	 * Metodo encargado de crear usuarios del sistema
	 */
	public ResultadoDTO crearUsuario(Usuario usuario);
	
	/**
	 * Metodo encarga do de eliminar un usuario
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Metodo encargado de obtener usuario por id
	 * @param id
	 * @return
	 */
	public Usuario findById(Long id);
	
}
