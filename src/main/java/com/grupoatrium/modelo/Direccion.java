/**
 * 
 */
package com.grupoatrium.modelo;

/**
 * Clase de definición de Dirección
 * @author Elena
 *
 */
public class Direccion {

	// Definimos las propiedades de clase
	private String calle;
	private int numero;
	private String poblacion;
	private int cp;
	private String provincia;

	//--------------Métodos de acceso y modificación-------------

	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	// Método de prueba de inyecciones
	@Override
	public String toString() {
		return "Calle: " + calle + "; Número: " + numero + "; Población: " + poblacion + "; CP: " + cp
				+ "; Provincia: " + provincia
				+ "\n --------------------------";
	}

}
