/**
 * 
 */
package com.grupoatrium.modelo;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PreDestroy;

/**
 * Clase de definición de Libro
 * @author Elena
 *
 */
public class Libro {

	// Definimos las propiedades de clase
	private String isbn;
	private String titulo;
	private String autores;
	private String editorial;
	private int publicacion;
	private double precio;
	private String descripcion;

	//--------------Métodos de acceso y modificación-------------

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Método de prueba de inyecciones
	@Override
	public String toString() {
		return "- ISBN: " + isbn + "\n- Titulo: " + titulo	+ "\n- Autores: "
				+ autores + "\n- Editorial: "
				+ editorial + "\n- Publicacion: " + publicacion + "\n- Precio: " + precio + "\n- Descripción: " + descripcion
				+ "\n --------------------------";
	}

}
