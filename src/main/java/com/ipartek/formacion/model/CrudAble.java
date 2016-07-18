package com.ipartek.formacion.model;

import java.util.List;

/**
 * 



</ul>
//declara las operaciones basicas de crud
<ul>
<li>Create</li>
<li>Read</li>
<li>Update</li>
<li>Delete</li>

 */
public interface CrudAble<P> {

	
	boolean create( P pojo );
	
	List<P> getAll();
	P getById(long id);
	boolean update (P pojo);
	
	boolean delete(long id);
	
	
}
