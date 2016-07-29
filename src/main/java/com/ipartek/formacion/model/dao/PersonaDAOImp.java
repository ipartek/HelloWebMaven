package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;

public class PersonaDAOImp implements PersonaDAO{

	private static PersonaDAOImp INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	private PersonaDAOImp() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static PersonaDAOImp getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PersonaDAOImp();
		}
	}
	
	@Override
	public boolean create(Persona pojo) {
		boolean resul = false;
		String sql = "{call insertar(?,?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getApellido());
			cst.setString(3, pojo.getDni());
			cst.setString(4, pojo.getEmail());
			
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
	public List<Persona> getAll() {
		List<Persona> personas = null;
		String sql = "{call getPersonas()}";
		try {
			conexion = db.getConexion();		
			Persona p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			personas = new ArrayList<Persona>();
			while (rs.next()) {
				p = new Persona();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
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
		String sql = "{call getPersonaId(?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				p = new Persona();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
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
		String sql = "{call editar(?,?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setInt(1, pojo.getId());
			cst.setString(2, pojo.getNombre());
			cst.setString(3, pojo.getApellido());
			cst.setString(4, pojo.getDni());
			cst.setString(5, pojo.getEmail());
			
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
		String sql = "{call borrar(?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);						
			cst.setLong(1, id);
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
			CallableStatement cst = conexion.prepareCall("{call buscar(?)}");
			cst.setString(1, criterio);
			ResultSet rs = cst.executeQuery();
			while( rs.next() ){
				p = new Persona();
				p.setId( rs.getInt("id") );
				p.setNombre( rs.getString("nombre") );
				p.setApellido( rs.getString("apellido") );
				p.setDni( rs.getString("dni") );
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
