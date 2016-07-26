package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Person;

public interface PersonDAO extends PersistAble<Person>{
	/**
	 * Busca planetas que coincidan los nombres con el parametro criterio
	 * @param criterio
	 * @return
	 */
	List<Person> search(String criterio);
}
