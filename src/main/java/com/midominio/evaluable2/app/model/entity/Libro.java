package com.midominio.evaluable2.app.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Se requiere un titulo de libro")
	@Size(min = 2, message = "Se requiere un mínimo de 2 caracteres")
	private String titulo;

	@NotEmpty(message = "Se requiere un nombre de autor")
	@Size(min = 2, message = "Se requiere un mínimo de 2 caracteres")
	private String autor;

	@NotEmpty(message = "Se requiere un género novelístico")
	@Size(min = 2, message = "Se requiere un mínimo de 2 caracteres")
	private String genero;

	@NotEmpty(message = "Se requiere un nombre de editorial")
	@Size(min = 2, message = "Se requiere un mínimo de 2 caracteres")
	private String editorial;

	@Column(name = "numero_ejemplares")
	@NotNull
	@Min(1)
	private int numEjemplares;
	
	private String foto;

	public Libro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
