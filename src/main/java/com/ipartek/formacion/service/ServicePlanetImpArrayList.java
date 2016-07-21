package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Planet;

public class ServicePlanetImpArrayList implements ServicePlanet{

	private static ServicePlanetImpArrayList INSTANCE = null;
	private ArrayList<Planet> planetas = null;
	private int indice = 0;
	
	/**
	 * Constructor Privado para que no se llame desde fuera
	 * No se puede realizar un "new"
	 */
	private ServicePlanetImpArrayList() {
		planetas = new ArrayList<Planet>();

		for (int i = 0; i < 50; i++) {

			planetas.add(new Planet("planet " + i, i));
		}
		this.indice=50;
	}
	
	// creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new ServicePlanetImpArrayList();
        }
    }
    
    /**
     * Metodo Publico que nos da acceso a usar la Clase
     * @return
     */
    public static ServicePlanetImpArrayList getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

	@Override
	public List<Planet> getAll() {
		return this.planetas;
	}

	@Override
	public Planet getById(long id) {
		Planet p = null;
		for (int i = 0; i < planetas.size(); i++) {
			if (id == planetas.get(i).getId()) {
				p = planetas.get(i);
				break;
			}
		}
		return p;
	}

	@Override
	public boolean delete(long id) {
		
		
		boolean eliminado = false;
		for (int i = 0; i < planetas.size(); i++) {
			if (id == planetas.get(i).getId()) {
				planetas.remove(i);
				eliminado = true;
				break;
			}

		}
		return eliminado;
	}

	@Override
	public Planet save(Planet p)  throws Exception{
		
		Planet pl = new Planet(p.getNombre(), p.getId());
		pl.setImagen(p.getImagen());
		if (pl.isNew()) {
			if (planetas.isEmpty()) {
				pl.setId(1);
			} else {
				pl.setId((planetas.get(planetas.size() - 1).getId() + 1));
			}
			planetas.add(pl);
		} else {
			for (int i = 0; i < planetas.size(); i++) {
				if (pl.getId() == planetas.get(i).getId()) {
					planetas.set(i, pl);
					break;
				}
			}
		}
		return pl;
	}

	@Override
	public List<Planet> search(String criterio) {
		
		String bus = criterio;
		ArrayList<Planet> planetasBusqueda = new ArrayList<Planet>();
		for (int i = 0; i < planetas.size(); i++) {

			if (planetas.get(i).getNombre().contains(bus)) {

				planetasBusqueda.add(planetas.get(i));
			}
		}
		return planetasBusqueda;
	}

}
