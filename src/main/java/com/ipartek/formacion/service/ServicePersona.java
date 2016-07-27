package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

public interface ServicePersona {
	//Metodos basicos
		/**
		 * Devuelve los ultimos 1000 planetas creados
		 * @return
		 */
		List<Persona> getAll();
		/**
		 * Busca planeta por su identificador
		 * @param id
		 * @return Planeta si encuentra, null si no existe
		 */
		Persona getById(long id);
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
		Persona save(Persona p) throws Exception;
		//Metodos propios del proyecto
		/**
		 * Busca Planetas que contengan el <b>criterio</b> buscado en su nombre
		 * @param criterio
		 * @return
		 */
		List<Persona> search(String criterio);
}
