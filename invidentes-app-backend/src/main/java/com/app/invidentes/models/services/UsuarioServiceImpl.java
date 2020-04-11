package com.app.invidentes.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.invidentes.interfaceService.IUsuarioService;
import com.app.invidentes.models.dao.IUsuarioDAO;
import com.app.invidentes.models.entity.EstadoEnum;
import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.entity.Usuario;

/**
 * Clase que implementa IClienteService gestiona los metodos del crud
 * @author pedro
 *
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService{

	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
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
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioDAO.save(usuario);
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

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUsuario(username);
		if(usuario == null) {
			logger.error("Error en el inicio de sesion: no existe el usuario!");
			throw new UsernameNotFoundException("Error en el inicio de sesion: no existe el usuario!");
		}
		SimpleGrantedAuthority rol = new SimpleGrantedAuthority(usuario.getRol().getNombre());
		List<GrantedAuthority> listAuthoritys = new ArrayList<>();
		listAuthoritys.add(rol);
		logger.info("Rol: "+rol.getAuthority());
		Boolean habilitado = false;
		if (usuario.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
			habilitado = true;
		}
		return new User(usuario.getUsuario(), usuario.getContrasena(), habilitado, true, true, true, listAuthoritys);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsuario(String usuario) {
		return usuarioDAO.findByUsuario(usuario);
	}

}
