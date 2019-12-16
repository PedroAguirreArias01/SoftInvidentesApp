package com.app.invidentes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.models.dao.IPqrsDAO;
import com.app.invidentes.models.entity.Pqrs;
import com.app.invidentes.models.entity.ResultadoDTO;

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
	public ResultadoDTO crear(Pqrs pqrs) {
		pqrsDAO.save(pqrs);
		return  new ResultadoDTO(true, "Informacion guardada conexito");
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
