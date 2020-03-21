package com.app.invidentes.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.invidentes.interfaceService.IUsuarioService;
import com.app.invidentes.models.dao.IRolDAO;
import com.app.invidentes.models.entity.Rol;
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
	 * Atributo de inyeccion de dependencias del rol del usuario
	 */
	@Autowired
	private IRolDAO rolDao;
	
	/**
	 * url = http://localhost:8080/api/usuarios/rol
	 * @param rol
	 * @return
	 */
	@PostMapping("/usuarios/rol/")
	public ResponseEntity<?> crearRol(@RequestBody Rol rol) {
		Rol rolActual = null;
		Map<String, Object> response = new HashMap<>();
		try {
			rolActual = rolDao.save(rol);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El rol ha sido creado con exito");
		response.put("usuario", rolActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * Servicio de obtener todos los roles
	 * url = http://localhost:8080/api/usuarios/rol
	 * @return
	 */
	@GetMapping("/usuarios/rol/")
	public java.util.List<Rol> getRoles(){
		return (List<Rol>) rolDao.findAll();
	}
	
	/**
	 * Servicio de obtener todos los Usuarios
	 * url = http://localhost:8080/api/usuarios
	 * @return
	 */
	@GetMapping("/usuarios")
	public java.util.List<Usuario> colaboradores(){
		return usuarioService.findAll();
	}
	
	/**
	 * Servicio para obtener los usuarios por id especifico
	 * @param id
	 * @return
	 */
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();
		try {
			usuario = usuarioService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		if (usuario == null) {
			response.put("mensaje", "El usuario ID ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	/**
	 * Metodo encargado de crear usuarios
	 * @param usuario
	 * @return
	 */
	@PostMapping("/usuarios")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNuevo = null;
		/*Rol rol  = new Rol();
		rol = usuario.getRol();
		rolDao.save(rol);*/
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioNuevo = usuarioService.crearUsuario(usuario);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con exito");
		response.put("usuario", usuarioNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * Metodo encargado de actualizar colaborador 
	 * @param usuario
	 * @param id
	 * @return
	 */
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioActualizado = null;
		if (usuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el cliente ID: ".concat(id.toString().concat(" no existe")));
		}
		try {
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellido(usuario.getApellido());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setUsuario(usuario.getUsuario());
			usuarioActual.setRol(usuario.getRol());
			usuarioActual.setContrasena(usuario.getContrasena());
			usuarioActualizado = usuarioService.crearUsuario(usuarioActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido actualizado con éxito!");
		response.put("usuario", usuarioActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * Metodo encargado de eliminar Usuarios
	 * @param id
	 */
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuario en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido eliminado de la base de datos!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
