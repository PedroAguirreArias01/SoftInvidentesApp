package com.app.invidentes.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.invidentes.interfaceService.IPqrsService;
import com.app.invidentes.models.dao.IPersonaDAO;
import com.app.invidentes.models.dao.IRecursoDAO;
import com.app.invidentes.models.entity.Persona;
import com.app.invidentes.models.entity.Pqrs;
import com.app.invidentes.models.entity.Recurso;
import com.app.invidentes.models.entity.Usuario;

@RestController
@CrossOrigin(origins = "*")
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
	
	private List<Recurso> listFiles = new ArrayList();
	
	@Autowired
	private IRecursoDAO recursoDAO;
	
	@GetMapping("/pqrs")
	public List<Pqrs> findAll() {
		return (List<Pqrs>) pqrsService.findAll();
	}

	@PostMapping("/pqrs")
	@ResponseStatus(HttpStatus.CREATED)
	public Pqrs crear(@RequestBody Pqrs pqrs) {
		Persona personaActual = pqrs.getPersona();
		Persona persona = new Persona();
		persona.setApellido(personaActual.getApellido());
		persona.setDireccion(personaActual.getDireccion());
		persona.setNombre(personaActual.getNombre());
		persona.setNumIdentificacion(personaActual.getNumIdentificacion());
		personaDAO.save(persona);
		for (Recurso recurso : listFiles) {
			this.recursoDAO.save(recurso);
		}
		Pqrs pqrsActual = mapeoPqrsServicio(pqrs, persona);
		pqrsActual.setRecursos(listFiles);
		listFiles.clear();
		 return pqrsService.save(pqrsActual);
	}
	
	/**
	 * Metodo que se encarga del mapeo del objeto del servicio
	 * al objeto de la logica 
	 * @param pqrs
	 * @param persona
	 * @return
	 */
	private Pqrs mapeoPqrsServicio(Pqrs pqrs, Persona persona) {
		Pqrs pqrsActual = new Pqrs();
		pqrsActual.setDescripcion(pqrs.getDescripcion());
		pqrsActual.setPersona(persona);
		pqrsActual.setRecursos(pqrs.getRecursos());
		pqrsActual.setTipoPqrsEnum(pqrs.getTipoPqrsEnum());
		pqrsActual.setRespuestas(pqrs.getRespuestas());
		return pqrsActual;
	}
	
	@PutMapping("/pqrs/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Pqrs update(@RequestBody Pqrs pqrs, @PathVariable Long id) {
		Pqrs pqrsActual = pqrsService.findById(id);
		pqrsActual.setDescripcion(pqrs.getDescripcion());
		pqrsActual.setPersona(pqrs.getPersona());
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
	
	
	/**
	 * Metodo encargado de actualizar Los recursos de una pqrs 
	 * @param usuario
	 * @param id
	 * @return
	 */
	@PostMapping("/recursos")
	public ResponseEntity<?> update(@RequestParam("file") MultipartFile file) {
		String message;
		Recurso recurso = new Recurso();
	      try {
	         try {
	            //Files.copy(file.getInputStream(), this.rootLocation.resolve("file_name.pdf"));
	        	 recurso.setData(file.getBytes());
	        	 recurso.setNombre(file.getName());
	        	 recurso.setTipo(file.getContentType());
	         } catch (Exception e) {
	            throw new RuntimeException("FAIL!");
	         }
	         //listFiles.add(file.getOriginalFilename());
	         listFiles.add(recurso);

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	}
}
