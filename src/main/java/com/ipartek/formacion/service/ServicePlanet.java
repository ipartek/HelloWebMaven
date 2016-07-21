package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Interface de la capa Servicio
 * que declara la logica de negocio de los Planetas
 */
public interface ServicePlanet {
	/**
	 * retorna los ultimo 1000 planetas creados
	 * @return
	 */
	List<Planeta> getPlanetas();
	/**
	 * Busca planeta que contenga los mismo caracteres recibidos
	 * @param nombre
	 * @return
	 */
	List<Planeta> search(String nombre);
	/**
	 * Busca planeta por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planeta getPlanetaId(int id);
	/**
	 * Elimina planeta con el mismo id que se recibe
	 * @param id
	 * @return
	 */
	boolean delete(int id);
	/**
	 * Modifica o crea un nuevo planeta
	 * @param p
	 * @throws Si no se puede guardar el planeta
	 * @return Planeta salvado
	 */
	Planeta save(Planeta p) throws Exception;
	
}
