package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Person;

public interface ServicePerson {

	/**
	 * retorna las ultimas 100 personas creadas
	 * @return
	 */
	List<Person> getAll();

	/**
	 * Busca personas por su identificador
	 * @param id
	 * @return Persona si encuentra, null si no existe
	 */
	Person getById(long id);

	/**
	 * Elimina Persona por su identificador
	 * @param id
	 * @return
	 */
	boolean delete(long id);

	/**
	 * Modifica o crea una  nueva Persona
	 * @param p
	 * @throws Si no se puede guardar Persona
	 * @return Persona salvada 
	 */
	Person save(Person p) throws Exception;

	/**
	 * Busca Personas que contengan el <b>criterio</b> buscado en su nombre
	 * @param criterio
	 * @return
	 */
	List<Person> search(String criterio);

}
