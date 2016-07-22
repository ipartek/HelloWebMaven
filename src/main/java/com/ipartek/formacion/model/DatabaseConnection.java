package com.ipartek.formacion.model;

import java.sql.Connection;

public interface DatabaseConnection {
	
	void conectar();
	
	void desconectar();
	
	Connection getConexion();

}
