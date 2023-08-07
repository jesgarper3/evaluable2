package com.midominio.evaluable2.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.evaluable2.app.model.entity.Usuario;

public interface IUsuarioService {
	Iterable<Usuario> findAll();
	void save (Usuario libro);
	Usuario findOne (Long id);
	void delete (Long id);
	
	Page<Usuario> listar (Pageable pageable);
}
