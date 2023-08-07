package com.midominio.evaluable2.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.evaluable2.app.model.entity.Libro;
import com.midominio.evaluable2.app.model.repository.ILibroDAO;



@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroDAO libroDAO;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Libro> findAll() {
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		libroDAO.save(libro);
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findOne(Long id) {
		return libroDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		libroDAO.deleteById(id);


	}

	@Override
	@Transactional(readOnly = true)
	public Page<Libro> listar(Pageable pageable) {
		return libroDAO.findAll(pageable);
	}
}
