package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

public interface PersonaDAO extends PersistAble<Persona> {
	/**
	 * Busca personas cuyo nombre coincida con el parametro criterio
	 * @param criterio
	 * @return
	 */

	List<Persona> search(String criterio);

}
