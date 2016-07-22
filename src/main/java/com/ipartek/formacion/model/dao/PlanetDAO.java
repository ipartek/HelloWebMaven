package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public interface PlanetDAO extends PersistAble<Planeta>{

	/**
	 * Busca planetas que contengan en el nombre el parámetro criterio
	 * @param criterio
	 * @return
	 */
	
	List<Planeta> search(String criterio);
	
	
}

