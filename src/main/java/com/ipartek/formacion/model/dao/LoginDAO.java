package com.ipartek.formacion.model.dao;


import java.util.List;


import com.ipartek.formacion.pojo.Usuario;

public interface LoginDAO extends PersistAble<Usuario>{

	/**
	 * Busca usuarios que coincidan los nombres con el parametro criterio
	 * @param criterio
	 * @return
	 */
	List<Usuario> search(String criterio);
	
	Usuario getByNomAndPass(String nombre, String pass);
}
