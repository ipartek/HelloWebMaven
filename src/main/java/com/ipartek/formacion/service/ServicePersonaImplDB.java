package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PersistAble;
import com.ipartek.formacion.model.dao.PersonaDAOImpl;
import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Persona;

public class ServicePersonaImplDB implements ServicePersona {

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
	public Persona save(Persona p) throws Exception {
		boolean resul = false;
		if (p.isNew()){
			resul = daoPersona.create(p);
		}else {
			resul = daoPersona.update(p);
		}
		if (resul == false){
			throw new Exception ("Excepcion salvando Persona " + p.toString());
		}
		
		return p;
	}



	

}
