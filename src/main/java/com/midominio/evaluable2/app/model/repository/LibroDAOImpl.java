package com.midominio.evaluable2.app.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.midominio.evaluable2.app.model.entity.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroDAOImpl {

	@PersistenceContext
	private EntityManager em;

	public List<Libro> findAll() {

		return em.createQuery("from Libro", Libro.class).getResultList();
	}

	public void save(Libro libro) {
		if (libro.getId() != null && libro.getId() > 0)
			em.merge(libro);
		else
			em.persist(libro);
	}

	public Libro findOne(Long id) {

		return em.find(Libro.class, id);
	}

	public void delete(Long id) {
		em.remove(findOne(id));
	}
}
