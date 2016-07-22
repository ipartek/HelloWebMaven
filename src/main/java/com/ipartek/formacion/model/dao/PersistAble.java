package com.ipartek.formacion.model.dao;

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
public interface PersistAble<P> {
	//Create
	boolean create(P pojo);
	//Read
	List<P> getAll();
	
	P getById(int id);
	//Update
	boolean update(P pojo);
	//Delete
	boolean delete(long id);
}
