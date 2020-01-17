package com.app.invidentes.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.models.dao.IUsuarioDAO;
import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.entity.Usuario;

/**
 * Clase que implementa IClienteService gestiona los metodos del crud
 * @author pedro
 *
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	/**
	 * Metodo que retorna todos los colaboradores
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	/**
	 * Metodo encargado de crear colaborador
	 */
	@Override
	@Transactional
	public ResultadoDTO crearUsuario(Usuario usuario) {
		usuarioDAO.save(usuario);
		return new ResultadoDTO(true, "Colaborador creado con exito");
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}

}
