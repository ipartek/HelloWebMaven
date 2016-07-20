package com.ipartek.formacion.model;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

/**
 * Declara las operaciones basicas de CRUD
 * 
 * 	<ul>
 * 		<li>Create</li>
 * 		<li>Read</li>
 * 		<li>Update</li>
 * 		<li>Delete</li>
 * 	</ul>
 */
public interface CrudAble<P> {
	//Create
	boolean create(P pojo);
	//Read
	List<P> getAll();
	P getById(long id);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
