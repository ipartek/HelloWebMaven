package com.ipartek.formacion.model;

import java.util.List;


/**
 * Declara las operaciones basicas de CRUD
 * <ul>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ul>
 * @author Curso
 *
 */
public interface CrudAble<P> {
	
	boolean create(P pojo);
	
	List<P> getAll();
	
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);

}
