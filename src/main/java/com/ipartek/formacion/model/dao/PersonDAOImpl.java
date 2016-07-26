package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Person;

public class PersonDAOImpl implements PersonDAO{

	private static PersonDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	

	private PersonDAOImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static PersonDAOImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonDAOImpl();
		}
	}

	@Override
	public boolean create(Person pojo) {
		boolean resul = false;
		String sql = "{call insertPersona(?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getEmail());
			
			if ( cst.executeUpdate() == 1 ){
				resul = true;			
				pojo.setId( cst.getInt(3) );
			}	
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
			db.desconectar();
		}		
		return resul;
	}

	@Override
	public List<Person> getAll() {
		List<Person> personas = null;
		String sql = "{call getAllPersonas()}";
		try {
			conexion = db.getConexion();		
			Person p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			personas = new ArrayList<Person>();
			while (rs.next()) {
				p = new Person();
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
	public Person getById(long id) {
		Person p = null;
		CallableStatement cst = null;
		String sql = "{call buscarPersona(?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				p = new Person();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				cst.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			db.desconectar();
		}
		return p;
	}

	@Override
	public boolean update(Person pojo) {
		boolean resul = false;
		String sql = "{call updatePersona(?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getEmail());
			cst.setLong(3, pojo.getId());
			
			//ejecutar
			if ( cst.executeUpdate() == 1 ){
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
			db.desconectar();
		}		
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		String sql = "{call deletePersona(?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);						
			cst.setLong(1, id );
			if ( cst.executeUpdate() == 1 ){
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
			db.desconectar();
		}		
		return resul;
	}

	@Override
	public List<Person> search(String criterio) {
		ArrayList<Person> listaResul = new ArrayList<Person>();
		Person p = null;
		try{
			conexion = db.getConexion();
			CallableStatement cst = conexion.prepareCall("{call buscarPersonas(?)}");
			cst.setString(1, criterio);
			
			ResultSet rs = cst.executeQuery();
			
			while( rs.next() ){
				p = new Person();
				p.setId( rs.getLong("id") );
				p.setNombre( rs.getString("nombre") );
				p.setEmail( rs.getString("email") );
				listaResul.add(p);
			}
						
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.desconectar();
		}			
		return listaResul;
	}

}
