package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DataBaseConnectionImplTest {

	private DataBaseConnectionImpl db = null;
	
	@Test
	public void testConnection() {
		
		Connection con = db.getInstance().getConexion();
		assertNotNull(con);
		
	}
	
	@Test
	public void testDesConnection() {
		
		Connection con = db.getInstance().getConexion();
		assertNotNull(con);
		
		db.getInstance().desconectar();
		
	}

}
