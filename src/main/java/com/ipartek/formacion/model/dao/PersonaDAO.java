package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Person;

public interface PersonaDAO extends PersistAble<Person> {

	/**
	 * Busca planetas que coincidan los nombre con el parametro crtierio
	 * @param criterio
	 * @return
	 */
	List<Person> search(String criterio);	
}