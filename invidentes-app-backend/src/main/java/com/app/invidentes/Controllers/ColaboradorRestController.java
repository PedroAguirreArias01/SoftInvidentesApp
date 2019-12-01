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

import com.app.invidentes.models.services.IColaboradorService;

import com.app.invidentes.models.entity.Colaborador;
import com.app.invidentes.models.entity.ResultadoDTO;

/**
 * Clase de servicios rest
 * @author pedro
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ColaboradorRestController {

	/**
	 * Inyeccion de dependencias
	 */
	@Autowired
	private IColaboradorService colaboradorService;
	
	/**
	 * Servicio de obtener todos los colaborandores
	 * url = http://localhost:8080/api/colaboradores
	 * @return
	 */
	@GetMapping("/colaboradores")
	public java.util.List<Colaborador> colaboradores(){
		return colaboradorService.findAll();
	}
	
	@GetMapping("/colaboradores/{id}")
	public Colaborador buscarPorId(@PathVariable Long id) {
		return colaboradorService.findById(id);
	}
	
	/**
	 * Metodo encargado de crear colaborador
	 * @param colaborador
	 * @return
	 */
	@PostMapping("/colaboradores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO crearColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorService.crearColaborador(colaborador);
	}
	
	/**
	 * Metodo encargado de actualizar colaborador 
	 * @param colaborador
	 * @param id
	 * @return
	 */
	@PutMapping("/colaboradores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadoDTO update(@RequestBody Colaborador colaborador, @PathVariable Long id) {
		Colaborador colaboradorActual = colaboradorService.findById(id);
		colaboradorActual.setNombre(colaborador.getNombre());
		colaboradorActual.setApellido(colaborador.getApellido());
		colaboradorActual.setEmail(colaborador.getEmail());
		colaboradorActual.setUsuario(colaborador.getUsuario());
		colaboradorActual.setPassword(colaborador.getPassword());
		colaboradorService.crearColaborador(colaboradorActual);
		return new ResultadoDTO(true, "Colaborador actualizado con exito");
	}
	
	/**
	 * Metodo encargado de eliminar colaborador
	 * @param id
	 */
	@DeleteMapping("/colaboradores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		colaboradorService.delete(id);
	}
}
