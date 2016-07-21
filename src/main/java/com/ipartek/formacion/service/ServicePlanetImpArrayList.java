package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Planeta;

public class ServicePlanetImpArrayList implements ServicePlanet {

	private static ServicePlanetImpArrayList INSTANCE = null;
		
	private ServicePlanetImpArrayList() {
		// TODO Auto-generated constructor stub
	}
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE = new ServicePlanetImpArrayList();
		}
	}
	
	public static ServicePlanetImpArrayList getInstance(){
		if(INSTANCE == null) createInstance();
		return INSTANCE;
	}
	
	@Override
	public List<Planeta> getPlanetas() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Planeta> search(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planeta getPlanetaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Planeta save(Planeta p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
