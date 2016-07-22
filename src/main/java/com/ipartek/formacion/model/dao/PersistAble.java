/**
 * 
 */
package com.ipartek.formacion.model.dao;

import java.util.List;

/**
 *Declara las operaciones básias de CRUD
 * <ul>
 * 	<li>Create</li>
 * 	<li>Read</li>
 * 	<li>Update</li>
 * 	<li>Delete</li>
 * </ul>
 *
 */
public interface PersistAble<P> {   
	
	//sin <P> utilizariamos el siguiente codigo y solo seria valido para el objeto Persona
	//boolean create(Persona p);    
	//con esto crea la persona y me devuelve true o false si la crea o no

								//asi nos implementaria cualquier clase pojo
	boolean create(P pojo);		//para poder Create en la BBDD
	
	List<P> getAll();   		//para poder Read todos los datos de la BBDD
	
	P getById(long id);			//para poder Read los datos de un id de la BBDD
	
	boolean update(P pojo);		//para poder Update en la BBDD
	
	boolean delete(long id);	//para poder Delete en la BBDD
}
