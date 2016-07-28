package com.ipartek.formacion.service;

import com.ipartek.formacion.pojo.Person;
import com.ipartek.formacion.pojo.Usuario;

public interface ServiceLogin {

	/**
	 * Busca si estan el nombre y contraseña
	 * @param String nombre, String pass
	 * @return objeto Usuario con id negativo si no está
	 */
	Usuario getByNomAndPass(String nombre, String pass);
}
