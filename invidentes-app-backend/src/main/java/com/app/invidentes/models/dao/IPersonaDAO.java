package com.app.invidentes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.invidentes.models.entity.Persona;
/**
 * Clase que implementa los metodos del crud 
 * @author pedro
 *
 */
public interface IPersonaDAO extends CrudRepository<Persona, Long>{

}
