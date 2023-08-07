package com.midominio.evaluable2.app.model.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.evaluable2.app.model.entity.Libro;

public interface ILibroDAO extends PagingAndSortingRepository<Libro, Long>,
									CrudRepository<Libro, Long>{

}
