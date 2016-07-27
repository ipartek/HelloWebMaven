package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.pojo.Persona;

public interface PersonaDAO extends PersistAble<Persona> {

	List<Persona> search(String criterio);
}
