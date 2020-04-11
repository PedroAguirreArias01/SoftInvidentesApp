package com.app.invidentes.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.invidentes.models.entity.Normatividad;
import com.app.invidentes.models.entity.TipoNormativa;
import com.app.invidentes.models.entity.Usuario;

public interface INormatividadDAO extends CrudRepository<Normatividad, Long>{
	
	public List<Normatividad> findByTipoNormativa(TipoNormativa tipoNormativa);
	
	public List<Normatividad> findByTitulo(String titulo);
	
	public List<Normatividad> findByDescripcion(String descripcion);
	
	public List<Normatividad> findByUsuario(Usuario usuario);

}
