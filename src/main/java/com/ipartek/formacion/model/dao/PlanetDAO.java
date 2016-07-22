package com.ipartek.formacion.model.dao;

import java.util.List;


import com.ipartek.formacion.pojo.Planet;

public interface PlanetDAO extends PersistAble<Planet>{

	/**
	 * Busca planetas que coincidan los nombres con el parametro criterio
	 * @param criterio
	 * @return
	 */
	List<Planet> search(String criterio);
	
	
	
	
}
