package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Person;

public class ServicePersonImpArrayList implements ServicePerson {

	private static ServicePersonImpArrayList INSTANCE = null;
	private ArrayList<Person> personas = null;
	private int indice = 0;
	private static final int MOCKS_SIZE = 50;

	/**
	 * Constructor Privado para que no se llame desde fuera No se puede realizar
	 * un "new"
	 */
	private ServicePersonImpArrayList() {
		personas = new ArrayList<Person>();
		for (long i = 0; i < MOCKS_SIZE; i++) {
			personas.add(new Person());
		}
		this.indice = MOCKS_SIZE;
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServicePersonImpArrayList();
		}
	}

	/**
	 * Metodo Publico que nos da acceso a usar la Clase
	 * 
	 * @return
	 */
	public static ServicePersonImpArrayList getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	@Override
	public List<Person> getAll() {
		return this.personas;
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
	public Person save(Person p) throws Exception {
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
	public Person getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
