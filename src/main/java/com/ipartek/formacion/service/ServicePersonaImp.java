package com.ipartek.formacion.service;



import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Persona;


public class ServicePersonaImp implements ServicePersona {

	private static ServicePersonaImp INSTANCE = null;
	
	private int indice = 0;
	private static final int MOCKS_SIZE = 50;



	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePersonaImp();
		}
	}

public static ServicePersonaImp getInstance() {
	if (INSTANCE == null)
		createInstance();
	return INSTANCE;
}



	@Override
	
	public List<Persona> getAll() {
		return this.persona
	}

	@Override
	public Persona getById(long id) {
		Persona p = null;
		for (int i = 0; i < Persona.size(); i++) {
			if (id == planetas.get(i).getId()) {
				p = planetas.get(i);
				break;
			}
		}
		return p;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		for (int i = 0; i < planetas.size(); i++) {
			if (id == planetas.get(i).getId()) {
				planetas.remove(i);
				resul = true;
				break;
			}
		}
		return resul;
	}

	@Override
	public persona save(persona p) throws Exception {
		if (p.isNew()) {
			this.indice++;
			p.setId(this.indice);
			planetas.add(p);			
		} else {
			for (int i = 0; i < planetas.size(); i++) {
				if (p.getId() == planetas.get(i).getId()) {
					planetas.set(i, p);
					break;
				}
			}
		}
		return p;
	}

	

}
