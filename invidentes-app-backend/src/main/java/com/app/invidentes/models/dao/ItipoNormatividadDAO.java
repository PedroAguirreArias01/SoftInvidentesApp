package com.app.invidentes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.invidentes.models.entity.TipoNormativa;

/**
 * clase que representa la crud de repositorio 
 * @author pedro
 *
 */
public interface ItipoNormatividadDAO extends CrudRepository<TipoNormativa, Long> {

}
