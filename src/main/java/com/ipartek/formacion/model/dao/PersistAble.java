package com.ipartek.formacion.model.dao;

import java.util.List;

/**
 * Declara las operaciones básicas de CRUD
 * <ul>
 * 	<li>Create</li>
 *  <li>Read</li>
 *  <li>Update</li>
 *  <li>Delete</li>
 * </ul>
 *
 */

public interface PersistAble<P> {

	//create
	boolean create(P pojo);	
	
	//read
	List<P> getAll();	
	P getById(long id);
	
	//update
	boolean update(P pojo);
	
	//delete
	boolean delete(long id);
	
}
