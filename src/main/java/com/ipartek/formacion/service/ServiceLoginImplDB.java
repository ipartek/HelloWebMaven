package com.ipartek.formacion.service;

import com.ipartek.formacion.model.dao.PersonDAO;
import com.ipartek.formacion.model.dao.PersonDAOImpl;
import com.ipartek.formacion.pojo.Usuario;

public class ServiceLoginImplDB implements ServiceLogin {

	private static ServiceLoginImplDB INSTANCE = null;
	private LoginDAO daoLogin;
	
	private ServiceLoginImplDB() {
		daoLogin = LoginDAOImpl.getInstance();
}

	public static ServiceLoginImplDB getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceLoginImplDB();
		}
	}

	@Override
	public Usuario getByNomAndPass(String nombre, String pass) {
		
		
	}

}
