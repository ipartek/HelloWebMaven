package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PeopleDAO;
import com.ipartek.formacion.model.dao.PeopleDAOImpl;
import com.ipartek.formacion.pojo.Persona;

public class ServicePeopleImplDB implements ServicePeople {

	private static ServicePeopleImplDB INSTANCE = null;
	private PeopleDAO daoPeople;

	private ServicePeopleImplDB() {
		daoPeople = PeopleDAOImpl.getInstance();
	}

	public static ServicePeopleImplDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePeopleImplDB();
		}
	}

	@Override
	public List<Persona> getAll() {		
		System.out.println("Buscado ultimas 100 personas ");
		return daoPeople.getAll();
	}

	@Override
	public Persona getById(long id) {
		System.out.println("Buscado persona [" + id + "]" );
		return daoPeople.getById(id);
	}

	@Override
	public boolean delete(long id) {	
		System.out.println("Eliminado persona [" + id + "]" );
		return daoPeople.delete(id);
	}

	@Override
	public Persona save(Persona p) throws Exception {
		boolean resul = false;
		if ( p.isNew() ){
			resul = daoPeople.create(p);
			System.out.println("Insertado " + p.toString()  );
		}else{
			System.out.println("Modificado " + p.toString()  );
			resul = daoPeople.update(p);
		}
				
		if (resul==false){
			System.out.println("Excepcion " + p.toString()  );
			throw new Exception("Excepcion salvando Persona " + p.toString() );
		}
		
		return p;
	}

	@Override
	public List<Persona> search(String criterio) {
		System.out.println("Buscar personas criterio " + criterio  );
		return daoPeople.search(criterio);
	}

}