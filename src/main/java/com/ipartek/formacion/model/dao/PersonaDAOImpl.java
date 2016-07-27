package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;

public class PersonaDAOImpl<P> implements PersistAble<P> {

	private static PlanetDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	private PlanetDAOImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static PlanetDAOImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlanetDAOImpl();
		}
	}
	
	
	@Override
	public boolean create(P pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<P> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public P getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(P pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
