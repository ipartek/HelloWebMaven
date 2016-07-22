package com.ipartek.formacion.model.dao;

import java.util.List;

public interface PersistAble<P> {

	boolean create(P pojo);
	
	List<P> getAll();
	
	P getById(long id);
	
	boolean update(P pojo);
	
	boolean delete(long id);
	
}
