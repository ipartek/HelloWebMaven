package com.ipartek.formacion.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PersonaServlet;
import com.ipartek.formacion.model.dao.PersistAble;
import com.ipartek.formacion.model.dao.PersonaDAOImpl;
import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Persona;

public class ServicePersonaImplDB implements ServicePersona {

	private static ServicePersonaImplDB INSTANCE = null;

	private PersistAble<Persona> daoPersona;
	
	private final static Logger LOG = Logger.getLogger(ServicePersonaImplDB.class);

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
		LOG.debug("Llama a daoPersona.getAll()");
		return daoPersona.getAll();
	}

	@Override
	public Persona getById(long id) {
		LOG.debug("Llama a daoPersona.getById(id)");
		return daoPersona.getById(id);
	}

	@Override
	public boolean delete(long id) {
		LOG.debug("Llama a daoPersona.delete(id)");
		return daoPersona.delete(id);
	}

	@Override
	public Persona save(Persona p) throws Exception {
		boolean resul = false;
		if (p.isNew()){
			LOG.debug("Llama a daoPersona.create(p)");
			resul = daoPersona.create(p);
		}else {
			LOG.debug("Llama a daoPersona.update(p)");
			resul = daoPersona.update(p);
		}
		if (resul == false){
			LOG.error("Error en save Service Persona. Se lanza excepcion");
			throw new Exception ("Excepcion salvando Persona " + p.toString());
			
		}
		
		return p;
	}



	

}
