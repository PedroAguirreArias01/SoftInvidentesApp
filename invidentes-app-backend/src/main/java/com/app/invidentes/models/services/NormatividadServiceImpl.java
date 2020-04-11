package com.app.invidentes.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.invidentes.interfaceService.INormatividadService;
import com.app.invidentes.models.dao.INormatividadDAO;
import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.TipoNormativa;

/**
 * Clase encergada de implementar los metodos del crud
 * @author pedro
 *
 */
@Service
public class NormatividadServiceImpl implements INormatividadService{
	
	@Autowired
	private INormatividadDAO normatividadDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Normatividad> findAll() {
		return (List<Normatividad>) normatividadDAO.findAll();
	}

	@Override
	@Transactional
	public Normatividad crear(Normatividad normatividad) {
		 return normatividadDAO.save(normatividad);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		normatividadDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Normatividad findById(Long id) {
		return normatividadDAO.findById(id).orElse(null);
	}

	@Override
	public List<Normatividad> obtenerNormatividadPorTipo(TipoNormativa tipoNormativa) {
		// TODO Auto-generated method stub
		return normatividadDAO.findByTipoNormativa(tipoNormativa);
	}

}
