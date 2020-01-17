package com.app.invidentes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.invidentes.models.entity.Usuario;

/**
 * Clase IColaboradorDAO contiene los metodos basicos para un crud
 * y se puen implementar nuestros propios metodos con anotaciones @Query
 * @author pedro
 *
 */
public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{

	
}
