package com.app.invidentes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.invidentes.models.entity.Pqrs;

/**
 * Interfaz contiene la crud de PQRS
 * @author pedro
 *
 */
public interface IPqrsDAO extends CrudRepository<Pqrs, Long>{

}
