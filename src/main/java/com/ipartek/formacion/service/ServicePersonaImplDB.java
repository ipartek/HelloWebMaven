package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.model.dao.PersonaDAO;
import com.ipartek.formacion.model.dao.PersonaDAOImp;
import com.ipartek.formacion.pojo.Persona;

public class ServicePersonaImplDB implements ServicePersona {
	private static ServicePersonaImplDB INSTANCE = null;
	private PersonaDAO daoPersona;

	private ServicePersonaImplDB() {
		daoPersona = PersonaDAOImp.getInstance();
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
		System.out.println("Buscado ultimos 1.000 personas ");
		return daoPersona.getAll();
	}

	@Override
	public Persona getById(long id) {
		System.out.println("Buscado persona [" + id + "]" );
		return daoPersona.getById(id);
	}

	@Override
	public boolean delete(long id) {
		System.out.println("Eliminado persona [" + id + "]" );
		return daoPersona.delete(id);
	}

	@Override
	public Persona save(Persona p) throws Exception {
		boolean resul = false;
		if ( p.isNew() ){
			resul = daoPersona.create(p);
			System.out.println("Insertado " + p.toString()  );
		}else{
			System.out.println("Modificado " + p.toString()  );
			resul = daoPersona.update(p);
		}
				
		if (resul==false){
			System.out.println("Excepcion " + p.toString()  );
			throw new Exception("Excepcion salvando persona " + p.toString() );
		}
		
		return p;
	}

	@Override
	public List<Persona> search(String criterio) {
		System.out.println("Buscar personas criterio " + criterio  );
		return daoPersona.search(criterio);
	}

}
