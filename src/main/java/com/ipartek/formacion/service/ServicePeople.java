package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

public interface ServicePeople {
	/**
	 * retorna las ultimas 100 personas creadas
	 * @return
	 */
	List<Persona> getAll();	
	
	/**
	 * Busca persona por su identifador
	 * @param id
	 * @return Persona si encuentra, null si no existe
	 */
	Persona getById(long id);
	
	/**
	 * Elimna Persona por su identifador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea una nueva persona 
	 * @param p
	 * @throws Si no se puede guardar persona
	 * @return Persona guardada
	 */
	Persona save(Persona p) throws Exception;
	
	/**
	 * Busca planetas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Persona> search(String criterio);

}
