package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Person;
import com.ipartek.formacion.pojo.Usuario;

public class LoginDAOImpl implements LoginDAO{

	private static LoginDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	private final static Logger LOG = Logger.getLogger(LoginDAOImpl.class);

	private LoginDAOImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static LoginDAOImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LoginDAOImpl();
		}
	}
	
	
	@Override
	public boolean create(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(long id) {
		Usuario u = null;
		CallableStatement cst = null;
		String sql = "{call buscarUsuario(?,?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNombre(rs.getString("nombre"));
				u.setPass(rs.getString("pass"));				
			}

		} catch (SQLException e) {
			LOG.error("Error al intentar encontrar persona con id:"+id);
			e.printStackTrace();
		} finally {
			
			try {
				cst.close();
			} catch (SQLException e) {	
				LOG.error("Error al intentar cerrar cst de tipo CallableStatement");
				e.printStackTrace();
			}
			db.desconectar();
		}
		return u;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> search(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getByNomAndPass(String nombre, String pass){
		Usuario u = null;
		CallableStatement cst = null;
		String sql = "{call buscarUsuario(?,?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setString(1, nombre);
			cst.setString(2, pass);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				u = new Usuario();
				u.setId(rs.getLong("id"));
				u.setNombre(rs.getString("nombre"));
				u.setPass(rs.getString("pass"));				
			}

		} catch (SQLException e) {
			LOG.error("Error al intentar encontrar usuario con nombre: "+nombre+" - pass: "+pass);
			e.printStackTrace();
		} finally {
			
			try {
				cst.close();
			} catch (SQLException e) {	
				LOG.error("Error al intentar cerrar cst de tipo CallableStatement");
				e.printStackTrace();
			}
			db.desconectar();
		}
		return u;
		
		
	}

}
