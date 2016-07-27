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
		System.out.println("Buscado ultimos 1.000 planetas ");
		return daoPersona.getAll();
	}

	@Override
	public Persona getById(long id) {
		System.out.println("Buscado planeta [" + id + "]" );
		return daoPersona.getById(id);
	}

	@Override
	public boolean delete(long id) {
		System.out.println("Eliminado planeta [" + id + "]" );
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
			throw new Exception("Excepcion salvando Planeta " + p.toString() );
		}
		
		return p;
	}

	@Override
	public List<Persona> search(String criterio) {
		System.out.println("Buscar planetas criterio " + criterio  );
		return daoPersona.search(criterio);
	}

}
