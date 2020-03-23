package com.app.invidentes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.interfaceService.IQuienesSomosService;
import com.app.invidentes.models.entity.QuienesSomos;
import com.app.invidentes.models.dao.IQuienesSomosDAO;

@Service
public class QuienesSomosService implements IQuienesSomosService{
	
	@Autowired
	private IQuienesSomosDAO quienSomDao;

	@Override
	@Transactional(readOnly = true)
	public List<QuienesSomos> findAll() {
		
		return (List<QuienesSomos>) quienSomDao.findAll();
	}

	@Override
	@Transactional
	public QuienesSomos crear(QuienesSomos quienesSomos) {
		
		return quienSomDao.save(quienesSomos);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		quienSomDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public QuienesSomos findById(Long id) {
		return quienSomDao.findById(id).orElse(null);
	}

}
