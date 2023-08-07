package com.midominio.evaluable2.app.model.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.midominio.evaluable2.app.model.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDAOImpl {

	@PersistenceContext
	private EntityManager em;
	
	public List<Usuario> findAll() {

		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	public void save(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() > 0)
			em.merge(usuario);
		else
			em.persist(usuario);
	}

	public Usuario findOne(Long id) {

		return em.find(Usuario.class, id);
	}

	public void delete(Long id) {
		em.remove(findOne(id));
	}
	
}
