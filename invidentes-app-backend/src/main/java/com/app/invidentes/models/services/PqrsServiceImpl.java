package com.app.invidentes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.interfaceService.IPqrsService;
import com.app.invidentes.models.dao.IPqrsDAO;
import com.app.invidentes.models.entity.Pqrs;

/**
 * Servicio que implementa los metodos del crud
 * @author pedro
 *
 */
@Service
public class PqrsServiceImpl implements IPqrsService{
	
	@Autowired
	private IPqrsDAO pqrsDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pqrs> findAll() {
		return (List<Pqrs>) pqrsDAO.findAll();
	}

	@Override
	@Transactional
	public Pqrs save(Pqrs pqrs) {
		return pqrsDAO.save(pqrs);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		pqrsDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pqrs findById(Long id) {
		return pqrsDAO.findById(id).orElse(null);
	}
}
