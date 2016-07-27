package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;



public interface ServicePersona {
	
	/**
	 * retorna los ultimos mil personas creadas
	 * @return
	 */
	
	List<Persona> getAll();
	
	/**
	 * busca persona por su identificador
	 * @param id
	 * @return persona si encuentra, null si no existe
	 */
	
	Persona getById(long id);
	
	/**
	 * elimina persona por su identificador
	 * @param id
	 * @return
	 */
	
	boolean delete(long id);
	
	/**
	 * modifica o crea un nuevo persona
	 * @param p
	 * @throws si no se puede guardar persona
	 * @return persona salvado, 
	 */
	
	Persona save(Persona p) throws Exception;
	
	/**
	 * busca personas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	
	List<Persona> search(String nombrePersona);

}
