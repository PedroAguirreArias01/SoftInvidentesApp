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
import org.springframework.web.bind.annotation.RestController;
import com.app.invidentes.interfaceService.INormatividadService;
import com.app.invidentes.models.dao.ItipoNormatividadDAO;
import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.TipoNormativa;
import com.app.invidentes.models.entity.Usuario;

@RestController
@CrossOrigin(origins = "*")
public class NormatividadRestController {

	/**
	 * Inyeccion de dependencias 
	 */
	@Autowired
	private INormatividadService normatividadSer;
	/**
	 * 
	 */
	@Autowired
	private ItipoNormatividadDAO tipoNormatividadSer;
	
	
	/**
	 * url = http://localhost:8080/normatividad/tipoNormatividad/
	 * @param tipoNormativa
	 * @return
	 */
	@PostMapping("/normatividad/tipoNormatividad")
	public ResponseEntity<?> crearTipoNormatividad(@RequestBody TipoNormativa tipoNormativa) {
		TipoNormativa tipoNormatividadActual = null;
		Map<String, Object> response = new HashMap<>();
		try {
			tipoNormatividadActual = this.tipoNormatividadSer.save(tipoNormativa);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de normatividad ha sido creado con exito");
		response.put("body", tipoNormatividadActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	/**
	 * Servicio de obtener todos los tipos de normatividad que existen en la base de datos
	 * url = http://localhost:8080/normatividad/tipoNormatividad/
	 * @return
	 */
	@GetMapping("/normatividad/tipoNormatividad")
	public java.util.List<TipoNormativa> getTipoNormatividad(){
		return (List<TipoNormativa>) tipoNormatividadSer.findAll();
	}
	
	/**
	 * Metodo encargado de eliminar tipo de normatividad
	 * @param id
	 */
	@DeleteMapping("/normatividad/tipoNormatividad/{id}")
	public ResponseEntity<?> deleteTipoNormatvidad(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			tipoNormatividadSer.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo de normatividad en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de normatividad ha sido eliminado de la base de datos!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PutMapping("/normatividad/tipoNormatividad/{id}")
	public ResponseEntity<?> actualizarTipoNormatividad(@RequestBody TipoNormativa tipoNormativa,  @PathVariable Long id){
		TipoNormativa tipoNormativaActual = this.tipoNormatividadSer.findById(id).orElse(null);
		Map<String, Object> response = new HashMap<>();
		TipoNormativa tipoNormativaActualizado = null;
		if (tipoNormativaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el tipo normatividad ID: ".concat(id.toString().concat(" no existe en la base de datos")));
		}
		try {
			tipoNormativaActual.setNombre(tipoNormativa.getNombre());
			tipoNormativaActualizado = this.tipoNormatividadSer.save(tipoNormativaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo de normatividad ha sido actualizado con éxito!");
		response.put("body", tipoNormativaActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/normatividad")
	public List<Normatividad> findAll() {
		return (List<Normatividad>) normatividadSer.findAll();
	}

	@PostMapping("/normatividad")
	public ResponseEntity<?>  crear(@RequestBody Normatividad normatividad) {
		Normatividad normatividadActual = null;
		Map<String, Object> response = new HashMap<>();
		try {
			normatividadActual = this.normatividadSer.crear(normatividad);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La información normativa ha sido creado con exito!");
		response.put("body", normatividadActual);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	
	@DeleteMapping("/normatividad/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			normatividadSer.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la información normativa en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La informacion normativa ha sido eliminado de la base de datos!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@PutMapping("/normatividad/{id}")
	public ResponseEntity<?> actualizarNormativa(@RequestBody Normatividad normatividad,  @PathVariable Long id){
		Normatividad normativaActual = this.normatividadSer.findById(id);
		Map<String, Object> response = new HashMap<>();
		Usuario tipoNormativaActualizado = null;
		if (normativaActual == null || id == null) {
			response.put("mensaje", "Error: no se pudo editar, la normatividad con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
		}
		try {
			normativaActual.setTitulo(normatividad.getTitulo());
			normativaActual.setDescripcion(normatividad.getDescripcion());
			normativaActual.setContenido(normatividad.getContenido());
			normativaActual.setTipoNormativa(normatividad.getTipoNormativa());
			this.normatividadSer.crear(normativaActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la información en la base de datos!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El la información normativa ha sido actualizado con éxito!");
		response.put("body", tipoNormativaActualizado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/normatividad/{id}")
	public Normatividad findById(Long id) {
		return normatividadSer.findById(id);
	}
}
