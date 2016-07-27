package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;


public interface PeopleDAO extends PersistAble<Persona> {
	
	/**
	 * Busca personas cuyos nombres coincidan con el parametro crtierio
	 * @param criterio
	 * @return
	 */
	List<Persona> search(String criterio);

}
