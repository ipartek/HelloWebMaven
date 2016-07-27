package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;

public class PersonaDAOImpl implements PersistAble<Persona> {

	private static PersonaDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	private PersonaDAOImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static PersonaDAOImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAOImpl();
		}
	}
	

	@Override
	public boolean create(Persona pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> getAll() {
		List<Persona> personas = null;
		String sql = "{call getAllPersonas()}";
		try {
			conexion = db.getConexion();
			Persona p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			personas = new ArrayList<Persona>();
			while (rs.next()) {
				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				// add en lista
				personas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return personas;
	}

	@Override
	public Persona getById(long id) {
		Persona p = null;
		
		try{
			conexion = db.getConexion();
			CallableStatement cst = conexion.prepareCall("{call getByIdPersona(?)}");
			cst.setLong(1, id);
			
			ResultSet rs = cst.executeQuery();
			if ( rs.next() ){
				p = new Persona();
				p.setId(id);
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.desconectar();
		}		
		
		return p;
	}

	@Override
	public boolean update(Persona pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		String sql = "{call deletePersona(?)}";
		CallableStatement cst= null;
		
		try {
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			
			//ejecutar
			if ( cst.executeUpdate() == 1){
				resul = true;			
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cst = null;
			db.desconectar();
		}
		
		return resul;
	}

}
