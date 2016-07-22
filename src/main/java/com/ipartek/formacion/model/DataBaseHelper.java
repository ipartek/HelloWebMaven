package com.ipartek.formacion.model;

import java.sql.Connection;

public interface DataBaseHelper {
	
	void conectar();
	
	void desconectar();
	
	Connection getConexion();
	

}
