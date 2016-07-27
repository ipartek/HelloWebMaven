package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;

public class PersonaDaoImpl implements PersonaDAO {
	private static PersonaDaoImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;
	
	private final static Logger LOG = Logger.getLogger(InitListener.class);

	private PersonaDaoImpl() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static PersonaDaoImpl getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDaoImpl();
		}
	}

	@Override
	public boolean create(Persona pojo) {
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
			}else{
				LOG.debug("Ha ocurrido un error al realizar el INSERT en la BD");
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
		CallableStatement cst = null;
		String sql = "{call buscarPersona(?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				p = new Persona();
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
	public boolean update(Persona pojo) {
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
			}else{
				LOG.debug("Ha ocurrido un error al hacer el UPDATE en la BD");
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
			}else{
				LOG.warn("Ha ocurrido un error al hacer el DELETE en la BD");
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
	public List<Persona> search(String criterio) {
		ArrayList<Persona> listaResul = new ArrayList<Persona>();
		Persona p = null;
		try{
			conexion = db.getConexion();
			CallableStatement cst = conexion.prepareCall("{call buscarPersonas(?)}");
			cst.setString(1, criterio);
			
			ResultSet rs = cst.executeQuery();
			
			while( rs.next() ){
				p = new Persona();
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
