package com.app.invidentes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.invidentes.models.services.IUsuarioService;

import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.entity.Usuario;

/**
 * Clase de servicios rest para Usuarios
 * @author pedro
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	private IUsuarioService usuarioService;
	
	/**
	 * Servicio de obtener todos los Usuarios
	 * url = http://localhost:8080/api/usuarios
	 * @return
	 */
	@GetMapping("/usuarios")
	public java.util.List<Usuario> colaboradores(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	/**
	 * Metodo encargado de crear usuarios
	 * @param usuario
	 * @return
	 */
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO crearUsuario(@RequestBody Usuario usuario) {
		return usuarioService.crearUsuario(usuario);
	}
	
	/**
	 * Metodo encargado de actualizar colaborador 
	 * @param usuario
	 * @param id
	 * @return
	 */
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario UsuarioActual = usuarioService.findById(id);
		UsuarioActual.setNombre(usuario.getNombre());
		UsuarioActual.setApellido(usuario.getApellido());
		UsuarioActual.setEmail(usuario.getEmail());
		UsuarioActual.setUsuario(usuario.getUsuario());
		UsuarioActual.setContrasena(usuario.getContrasena());
		usuarioService.crearUsuario(UsuarioActual);
		return new ResultadoDTO(true, "Usuario actualizado con exito");
	}
	
	/**
	 * Metodo encargado de eliminar Usuarios
	 * @param id
	 */
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResultadoDTO delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return new ResultadoDTO(true, "Usuario eliminado con exito");
	}
}
