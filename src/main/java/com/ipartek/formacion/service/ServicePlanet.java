package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planet;

/*
 * Interface de la capa Servicio 
 * declara la logica de negocio de los Planetas
 */
public interface ServicePlanet {

	/**
	 * retorna los ultimos 100 planetas creados
	 * @return
	 */
	List<Planet> getAll();

	/**
	 * Busca planetas por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planet getById(long id);

	/**
	 * Elimina Planeta por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	/**
	 * Modifica o crea un  nuevo Planeta
	 * @param p
	 * @throws Si no se puede guardar Planeta
	 * @return Planeta salvado 
	 */
	Planet save(Planet p) throws Exception;

	/**
	 * Busca Planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Planet> search(String criterio);

}
