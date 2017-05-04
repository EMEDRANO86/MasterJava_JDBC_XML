/**
 * 
 */
package com.grupoatrium.modelo;

/**
 * Clase de definición de Editorial
 * @author Elena
 *
 */
public class Editorial {

	// Definimos las propiedades de clase
	private String nombre;
	private String direccion;
	private String nif;

	// Constructor para definir propiedades de clase
	public Editorial(String nombre, String direccion, String nif) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
	}

	//--------------Métodos de acceso y modificación-------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	// Método de prueba de inyecciones
	@Override
	public String toString() {
		return "Nombre: " + nombre + "; Dirección: " + direccion + "; Nif: " + nif
				+ "\n --------------------------";
	}

}
