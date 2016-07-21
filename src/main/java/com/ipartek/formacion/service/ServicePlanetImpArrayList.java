package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public class ServicePlanetImpArrayList implements ServicePlanet {

	private static ServicePlanetImpArrayList INSTANCE = null;
	private ArrayList<Planeta> planetas = null;
	
	/**
	 * Constructor Privado para que no se llame desde fuera
	 * No se puede realizar un "new"
	 */
	private ServicePlanetImpArrayList(){
		planetas = new ArrayList<Planeta>();		
		for (int i=0; i < 50; i++ ){		
			planetas.add( new Planeta("planet"+i, i ) );
		}
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
	public List<Planeta> getAll() {		
		return this.planetas;
	}

	@Override
	public Planeta getById(long id) {
		Planeta p = null;
		for( int i=0; i < planetas.size() ; i++ ){			
			if ( id == planetas.get(i).getId() ){
				p = planetas.get(i);
				break;
			}
		}	
		return p;
	}

	@Override
	public boolean delete(long id) {
		int id = Integer.parseInt(request.getParameter("id"));
		String msg = "Planeta No Elimnado";
		for( int i=0; i < planetas.size() ; i++ ){			
			if ( id == planetas.get(i).getId() ){
				planetas.remove(i);
				msg = "Planeta["+id+"] Elimado Correctamente";
				break;
			}
		}
		return ;
	}

	@Override
	public Planeta save(Planeta p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planeta> search(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

}