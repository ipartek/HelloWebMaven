package com.ipartek.formacion;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;

public class LibroTest {

	@Test
	public void testLibro() {
		
		String titulo = "Java 6";
		Libro l1 = new Libro(titulo);
		
		assertTrue( titulo.equals( l1.getTitulo() ) );
		assertTrue( l1.getAutor().equals("anonimo"));
		assertTrue( l1.getIsbn().equals("Desconocido"));
		assertTrue( l1.getPaginas() == 0);
		
		
		
	}

}
