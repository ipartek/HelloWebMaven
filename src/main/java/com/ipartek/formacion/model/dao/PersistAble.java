package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

/**
 * Declara la operaciones basicas de CRUD
 * <ol>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ol>
 * @author Curso
 *
 */

public interface PersistAble<P> {
	
	boolean create(P pojo);//create
	
	List<P> getAll();//read
	
	P getById(long id);//read
	
	boolean update(P pojo);//update
	
	boolean delete(long Id);//delete
	
	

}
