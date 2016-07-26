package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PlanetDAO;
import com.ipartek.formacion.model.dao.PlanetDAOImpl;
import com.ipartek.formacion.pojo.Planet;

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
	public List<Planet> getAll() {		
		System.out.println("Buscado ultimos 1.000 planetas ");
		return daoPlaneta.getAll();
	}

	@Override
	public Planet getById(long id) {
		System.out.println("Buscado planeta [" + id + "]" );
		return daoPlaneta.getById(id);
	}

	@Override
	public boolean delete(long id) {	
		System.out.println("Eliminado planeta [" + id + "]" );
		return daoPlaneta.delete(id);
	}

	@Override
	public Planet save(Planet p) throws Exception {
		boolean resul = false;
		if ( p.isNew() ){
			resul = daoPlaneta.create(p);
			System.out.println("Insertado " + p.toString()  );
		}else{
			System.out.println("Modificado " + p.toString()  );
			resul = daoPlaneta.update(p);
		}
				
		if (resul==false){
			System.out.println("Excepcion " + p.toString()  );
			throw new Exception("Excepcion salvando Planeta " + p.toString() );
		}
		
		return p;
	}

	@Override
	public List<Planet> search(String criterio) {
		System.out.println("Buscar planetas criterio " + criterio  );
		return daoPlaneta.search(criterio);
	}

}