package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Person;

/**
 *  Interface de la capa Servicio 
 *  que declara la logica de negocio de las Pesonas
 */
public interface ServicePerson {

	/**
	 * retorna los ultimos 100 personas creadas
	 * @return
	 */
	List<Person> getAll();	
	
	
	/**
	 * Elimna Persona por su identifador
	 * @param id
	 * @return
	 */
	boolean delete(long id);
	
	/**
	 * Modifica o crea un nueva persona 
	 * @param p
	 * @throws Si no se puede guardar persona
	 * @return Persona guardada
	 */
	Person save(Person p) throws Exception;


	Person getById(long id);
	
}