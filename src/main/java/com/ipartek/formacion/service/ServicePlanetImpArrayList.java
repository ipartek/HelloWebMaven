package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public class ServicePlanetImpArrayList implements ServicePlanet{

	private static ServicePlanetImpArrayList INSTANCE = null;
	private ArrayList<Planeta> planetas = null;
	private int indice = 0;
	/**
	 * Constructor privado para que no se llame desde fuera
	 * No se puede realizar un "new"
	 */
	private ServicePlanetImpArrayList(){
		planetas = new ArrayList<Planeta>();
		for (int i = 0; i < 50; i++) {
			planetas.add(new Planeta("planeta" + i, i));
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
     * Metodo publico que nos da acceso a usar la Clase
     * @return
     */
    public static ServicePlanetImpArrayList getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
	
	@Override
	public List<Planeta> getAll() {
		return this.planetas;
	}

	@Override
	public Planeta getById(long id) {
		Planeta p = null;
		for(int i=0; i<planetas.size(); i++){			
			if (id==planetas.get(i).getId()){
				p = planetas.get(i);
				break;
			}
		}	
		return p;
	}

	@Override
	public boolean delete(long id) {
		boolean dev=false;
		for (int i = 0; i < planetas.size(); i++){
			if (id == planetas.get(i).getId()){
				planetas.remove(i);
				dev=true;
				break;
			}
		}
		return dev;
	}

	@Override
	public Planeta save(Planeta p) throws Exception {
		if (p.isNew()){
			if (planetas.isEmpty()){
				p.setId(1);
			}else{
				p.setId(planetas.get(planetas.size()-1).getId()+1);
			}
			planetas.add(p);
		}else{
			for (int i = 0; i < planetas.size(); i++){
				if (p.getId() == planetas.get(i).getId()){
					planetas.set(i, p);
					break;
				}
			}
		}
		return p;
	}

	@Override
	public List<Planeta> search(String criterio) {
		ArrayList<Planeta> planetasBusqueda = new ArrayList<Planeta>();
		for (int i=0; i<planetas.size(); i++){
			if (planetas.get(i).getNombre().contains(criterio)){
				planetasBusqueda.add(planetas.get(i));
			}
		}
		return planetasBusqueda;
	}

}
