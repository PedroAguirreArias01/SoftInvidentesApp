package com.app.invidentes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.invidentes.interfaceService.INormatividadService;
import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.ResultadoDTO;

@RestController
@CrossOrigin(origins = "*")
public class NormatividadRestController {

	/**
	 * Inyeccion de dependencias 
	 */
	@Autowired
	private INormatividadService normatividadSer;
	
	@GetMapping("/normatividad")
	public List<Normatividad> findAll() {
		return (List<Normatividad>) normatividadSer.findAll();
	}

	@PostMapping("/normatividad")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO crear(@RequestBody Normatividad normatividad) {
		 return normatividadSer.crear(normatividad);
	}

	@DeleteMapping("/normatividad/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		normatividadSer.delete(id);
	}

	@GetMapping("/normatividad/{id}")
	public Normatividad findById(Long id) {
		return normatividadSer.findById(id);
	}
}
