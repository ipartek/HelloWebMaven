package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DatabaseConnectionImplTest {
	
	private DatabaseConnectionImpl db = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConection() {
		Connection con = db.getInstance().getConexion();
		assertNotNull(con);
	}
	
	@Test
	public void testDesconection() {
		
		Connection con = db.getInstance().getConexion();
		assertNotNull(con);
		db.getInstance().desconectar();
		
	}

}
