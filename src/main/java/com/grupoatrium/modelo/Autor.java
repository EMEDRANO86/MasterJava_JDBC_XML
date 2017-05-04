/**
 * 
 */
package com.grupoatrium.modelo;

/**
 * Clase de definición de Autores
 * @author Elena
 *
 */
public class Autor {
	
	//Definimos las propiedades de clase
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	
	//--------------Métodos de acceso y modificación-------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	//Método de prueba de inyecciones
	@Override
	public String toString() {
		return "Nombre: "+nombre
				+"; Nacionalidad: "+nacionalidad
				+"; Comentarios: "+comentarios
				+ "\n --------------------------";
	}


}
