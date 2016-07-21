package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Interfaz de la capa Servicio para declarar la logica de negocio de los Planetas
 * @author Andoni Luna Moreno
 *
 */
public interface ServicePlanet {
	//Metodos basicos
	/**
	 * Devuelve los ultimos 1000 planetas creados
	 * @return
	 */
	List<Planeta> getAll();
	/**
	 * Busca planeta por su identificador
	 * @param id
	 * @return Planeta si encuentra, null si no existe
	 */
	Planeta getById(long id);
	/**
	 * Elimina Planeta por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	/**
	 * Modifica o Inserta un Planeta
	 * @param p
	 * @throws Si no se puede guardar planeta
	 * @return Planeta guardado
	 */
	Planeta save(Planeta p) throws Exception;
	//Metodos propios del proyecto
	/**
	 * Busca Planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Planeta> search(String criterio);
}
