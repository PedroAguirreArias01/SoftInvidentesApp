package com.app.invidentes.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.invidentes.interfaceService.IQuienesSomosService;
import com.app.invidentes.models.entity.QuienesSomos;

@RestController
@CrossOrigin(origins = "*")
public class QuienesSomosRestController {

	@Autowired
	private IQuienesSomosService quienSomService;

	@GetMapping("/quienSomos")
	public List<QuienesSomos> findAll() {
		return (List<QuienesSomos>) quienSomService.findAll();
	}

	@PostMapping("/quienSomos")
	public ResponseEntity<?> crear(@RequestBody QuienesSomos quienSomos) {
		Map<String, Object> respuesta = new HashMap<>();
		QuienesSomos quienSomosActual = null;
		try {
			quienSomosActual = quienSomService.crear(quienSomos);
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al realizar la inserción en la base de datos");
			respuesta.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "Información guardada con exito");
		respuesta.put("quienesomos", quienSomosActual);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	}

	public QuienesSomos consultarId(Long id) {

		return quienSomService.findById(id);
	}
	@DeleteMapping("/quienSomos/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		Map<String, Object> respuesta = new HashMap<>();
		QuienesSomos quienSomosActual = null;
		
		try {
		quienSomosActual = consultarId(id);
			quienSomService.delete(quienSomosActual.getId());
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al eliminar de la base de datos");
			respuesta.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "Información eliminada con exito");
		respuesta.put("quienesomos", quienSomosActual);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);

	}
	
	@PutMapping("/quienSomos/{id}")
	public ResponseEntity<?> actualizar(@RequestBody QuienesSomos quieSomos, @PathVariable Long id ){
		Map<String, Object> respuesta = new HashMap<>();
		QuienesSomos quienSomosActual = consultarId(id);
		
		try {
		
		quienSomosActual.setDescripcion(quieSomos.getDescripcion());
		quienSomosActual.setTitulo(quieSomos.getTitulo());
		quienSomService.crear(quienSomosActual);
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al actualizar la información");
			respuesta.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("mensaje", "Información actualizada con exito");
		respuesta.put("quienesomos", quienSomosActual);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
	}

}
