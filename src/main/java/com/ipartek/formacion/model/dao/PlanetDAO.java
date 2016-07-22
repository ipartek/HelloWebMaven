package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public interface PlanetDAO extends PersistAble<Planeta> {

	/**
	 * Busca planetas que coincidan los nombre con el parametro crtierio
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
	
	
	
}
