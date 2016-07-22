package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public interface PlanetDAO extends PersistAble<Planeta>{
	
	/**
	 * Busca planetas cuyo nombre coincida con el parametro criterio
	 * @param criterio
	 * @return
	 */

	List<Planeta> search(String criterio);
	
}
