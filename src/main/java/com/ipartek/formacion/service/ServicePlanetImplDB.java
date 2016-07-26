package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Planeta;

public class ServicePlanetImplDB implements ServicePlanet {

	private static ServicePlanetImplDB INSTANCE = null;
	private PlanetDAO daoPlaneta;

	private ServicePlanetImplDB() {
		daoPlaneta = PlanetDAOImpl.getInstance();
	}

	public static ServicePlanetImplDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePlanetImplDB();
		}
	}

	@Override
	public List<Planeta> getAll() {		
		return daoPlaneta.getAll();
	}

	@Override
	public Planeta getById(long id) {
		
		return daoPlaneta.getById(id);
	}

	@Override
	public boolean delete(long id) {
		
		return daoPlaneta.delete(id);
	}

	@Override
	public Planeta save(Planeta p) throws Exception {
		boolean resul = false;
		if (p.isNew()){
			resul = daoPlaneta.create(p);
		}else {
			resul = daoPlaneta.update(p);
		}
		if (resul == false){
			throw new Exception ("Excepcion salvando Planeta " + p.toString());
		}
		
		return p;
	}

	@Override
	public List<Planeta> search(String criterio) {		
		return daoPlaneta.search(criterio);
	}

}