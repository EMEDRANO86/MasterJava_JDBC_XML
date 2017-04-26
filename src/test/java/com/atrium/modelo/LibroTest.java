package com.atrium.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.grupoatrium.modelo.Libro;

public class LibroTest {

	@Test
	public void testGetTitulo() {
		
		Libro libro = new Libro();
		libro.setTitulo("Los viajes de Lola y Pipo");
		String titulo = libro.getTitulo();
		
		assertEquals("Los viajes de Lola y Pipo", titulo);
	}

}
