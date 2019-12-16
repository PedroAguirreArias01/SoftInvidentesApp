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
import com.app.invidentes.models.entity.Pqrs;
import com.app.invidentes.models.entity.ResultadoDTO;
import com.app.invidentes.models.services.IPqrsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PqrsRestController {

	/**
	 * Inyeccion de dependencias 
	 */
	@Autowired
	private IPqrsService pqrsService;
	
	@GetMapping("/pqrs")
	public List<Pqrs> findAll() {
		return (List<Pqrs>) pqrsService.findAll();
	}

	@PostMapping("/pqrs")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO crear(@RequestBody Pqrs pqrs) {
		 return pqrsService.crear(pqrs);
	}

	@DeleteMapping("/pqrs/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		pqrsService.delete(id);
	}

	@GetMapping("/pqrs/{id}")
	public Pqrs findById(Long id) {
		return pqrsService.findById(id);
	}
}
