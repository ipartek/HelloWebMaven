package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PersistAble;
import com.ipartek.formacion.model.dao.PersonaDAOImpl;
import com.ipartek.formacion.pojo.Persona;

public class ServicePersonaImplDB implements PersistAble<Persona> {

	private static ServicePersonaImplDB INSTANCE = null;
	private PersistAble<Persona> daoPersona;

	private ServicePersonaImplDB() {
		daoPersona = PersonaDAOImpl.getInstance();
	}

	public static ServicePersonaImplDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePersonaImplDB();
		}
	}

	@Override
	public List<Persona> getAll() {
		return daoPersona.getAll();
	}

	@Override
	public Persona getById(long id) {
		return daoPersona.getById(id);
	}

	@Override
	public boolean delete(long id) {
		return daoPersona.delete(id);
	}

	@Override
	public boolean create(Persona pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Persona pojo) {
		// TODO Auto-generated method stub
		return false;
	}



}
