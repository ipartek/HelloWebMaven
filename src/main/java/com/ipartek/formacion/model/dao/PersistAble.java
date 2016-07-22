package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

/**
 * Declara las operaciones basicas de CRUD
 * <ul>
 * 	<li>Create
 *  <li>Read
 *  <li>Update
 *  <li>Delete
 * </ul>
 * @author Curso
 *
 */
public interface PersistAble<P> {

	boolean create(P pojo);
	
	List<P> getAll();
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);	
	
}
