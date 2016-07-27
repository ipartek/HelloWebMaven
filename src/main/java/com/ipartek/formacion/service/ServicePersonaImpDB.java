package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PersistAble;
import com.ipartek.formacion.model.dao.PersonaDAOImpl;
import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Persona;

public class ServicePersonaImpDB implements ServicePersona {

	private static ServicePersonaImpDB INSTANCE = null;
	private PersistAble<Persona> daoPersona;

	private ServicePersonaImpDB() {
		daoPersona = PersonaDAOImpl.getInstance();
	}

	public static ServicePersonaImpDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePersonaImpDB();
		}
	}
	
	
	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Persona save(Persona p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> search(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

}
