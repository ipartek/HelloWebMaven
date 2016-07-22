package com.ipartek.formacion.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection {

	private Connection conexion;
	private static DatabaseConnectionImpl INSTANCE = null;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/hwm";
	private static final String USER = "root";
	private static final String PASS = "";

	private DatabaseConnectionImpl() {
		conexion = null;
		conectar();
	}

	public static DatabaseConnectionImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}

		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DatabaseConnectionImpl();
		}
	}

	@Override
	public void conectar() {

		if (conexion == null) {
			try {
				Class.forName(DRIVER);
				conexion = DriverManager.getConnection(URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				System.out.println("Falta libreria para driver " + DRIVER);
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("No se puede establecer conexion " + URL);
				e.printStackTrace();
			}
		}

	}

	@Override
	public void desconectar() {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar conexion");
				e.printStackTrace();
			}
		}

	}

	@Override
	public Connection getConexion() {
		conectar();
		return conexion;
}

}
