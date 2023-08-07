package com.midominio.evaluable2.app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.evaluable2.app.model.entity.Usuario;

public interface IUsuarioDAO extends PagingAndSortingRepository<Usuario, Long>, 
										CrudRepository<Usuario, Long> {

}
