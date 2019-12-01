package com.app.invidentes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.models.dao.IColaboradorDAO;
import com.app.invidentes.models.entity.Colaborador;
import com.app.invidentes.models.entity.ResultadoDTO;

/**
 * Clase que implementa IClienteService gestiona los metodos del crud
 * @author pedro
 *
 */
@Service
public class ColaboradorServiceImpl implements IColaboradorService{

	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	private IColaboradorDAO colaboradorDAO;
	
	/**
	 * Metodo que retorna todos los colaboradores
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Colaborador> findAll() {
		return (List<Colaborador>) colaboradorDAO.findAll();
	}

	/**
	 * Metodo encargado de crear colaborador
	 */
	@Override
	@Transactional
	public ResultadoDTO crearColaborador(Colaborador colaborador) {
		colaboradorDAO.save(colaborador);
		return new ResultadoDTO(true, "Colaborador creado con exito");
	}

	@Override
	@Transactional
	public void delete(Long id) {
		colaboradorDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Colaborador findById(Long id) {
		return colaboradorDAO.findById(id).orElse(null);
	}

}
