package com.midominio.evaluable2.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.evaluable2.app.model.entity.Libro;

public interface ILibroService {
	Iterable<Libro> findAll();
	void save (Libro libro);
	Libro findOne (Long id);
	void delete (Long id);
	
	Page<Libro> listar (Pageable pageable);
}
