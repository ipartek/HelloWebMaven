package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.pojo.Planeta;

public class ServicePersonaImpArrayList implements ServicePersona {

	private static ServicePersonaImpArrayList INSTANCE = null;
	private ArrayList<Persona> personas = null;
	private int indice = 0;
	private static final int MOCKS_SIZE = 50;

	/**
	 * Constructor Privado para que no se llame desde fuera No se puede realizar
	 * un "new"
	 */
	private ServicePersonaImpArrayList() {
		personas = new ArrayList<Persona>();
		for (int i = 0; i < MOCKS_SIZE; i++) {
			personas.add(new Persona("persona" + i, i));
		}
		this.indice = MOCKS_SIZE;
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePersonaImpArrayList();
		}
	}

	/**
	 * Metodo Publico que nos da acceso a usar la Clase
	 * 
	 * @return
	 */
	public static ServicePersonaImpArrayList getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	@Override
	public List<Persona> getAll() {
		return this.personas;
	}

	@Override
	public Persona getById(long id) {
		Persona p = null;
		for (int i = 0; i < personas.size(); i++) {
			if (id == personas.get(i).getId()) {
				p = personas.get(i);
				break;
			}
		}
		return p;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		for (int i = 0; i < personas.size(); i++) {
			if (id == personas.get(i).getId()) {
				personas.remove(i);
				resul = true;
				break;
			}
		}
		return resul;
	}

	@Override
	public Persona save(Persona p) throws Exception {
		if (p.isNew()) {
			this.indice++;
			p.setId(this.indice);
			personas.add(p);			
		} else {
			for (int i = 0; i < personas.size(); i++) {
				if (p.getId() == personas.get(i).getId()) {
					personas.set(i, p);
					break;
				}
			}
		}
		return p;
	}

	@Override
	public List<Persona> search(String criterio) {
		ArrayList<Persona> resul = new ArrayList<Persona>();
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNombre().contains(criterio)) {
				resul.add(personas.get(i));
			}
		}
		return resul;
	}
}



