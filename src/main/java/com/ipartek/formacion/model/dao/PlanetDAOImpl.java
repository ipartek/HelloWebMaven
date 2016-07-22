package com.ipartek.formacion.model.dao;

import java.util.List;

import com.ipartek.formacion.model.DataBaseConnection;
import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Planet;

public class PlanetDAOImpl implements PlanetDAO {
	
	private static PlanetDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	

	public PlanetDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Planet pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Planet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planet getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Planet pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Planet> search(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

}
