package com.app.invidentes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.invidentes.models.dao.IPersonaDAO;
import com.app.invidentes.models.entity.Persona;
import com.app.invidentes.models.entity.Pqrs;
import com.app.invidentes.models.services.IPqrsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PqrsRestController {

	/**
	 * Atributo que representa la crud de la persona 
	 */
	@Autowired
	private IPersonaDAO personaDAO;
	
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
	public Pqrs crear(@RequestBody Pqrs pqrs) {
//		Persona personaActual = pqrs.getPersona();
//		Persona persona = new Persona();
//		persona.setApellido(personaActual.getApellido());
//		persona.setDireccion(personaActual.getDireccion());
//		persona.setNombre(personaActual.getNombre());
//		personaDAO.save(persona);
		 return pqrsService.save(pqrs);
	}
	
	@PutMapping("/pqrs/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Pqrs update(@RequestBody Pqrs pqrs, @PathVariable Long id) {
		Pqrs pqrsActual = pqrsService.findById(id);
		pqrsActual.setDescripcion(pqrs.getDescripcion());
//		pqrsActual.setPersona(pqrs.getPersona());
		pqrs.setRespuestas(pqrs.getRespuestas());
		pqrs.setTipoPqrsEnum(pqrs.getTipoPqrsEnum());
		return this.pqrsService.save(pqrsActual);
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
