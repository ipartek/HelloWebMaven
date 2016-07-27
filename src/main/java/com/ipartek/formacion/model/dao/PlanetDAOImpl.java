package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Planeta;

public class PlanetDAOImpl implements PlanetDAO {

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
	public boolean create(Planeta pojo) {
		boolean resul = false;
		String sql = "{call insertPlaneta(?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getImagen());
			
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
	public List<Planeta> getAll() {
		List<Planeta> planetas = null;
		String sql = "{call getAllPlanetas()}";
		try {
			conexion = db.getConexion();		
			Planeta p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			planetas = new ArrayList<Planeta>();
			while (rs.next()) {
				p = new Planeta();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));
				// add en lista
				planetas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return planetas;
	}

	@Override
	public Planeta getById(long id) {
		Planeta p = null;
		CallableStatement cst = null;
		String sql = "{call buscarPlaneta(?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				p = new Planeta();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));				
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
	public boolean update(Planeta pojo) {
		boolean resul = false;
		String sql = "{call updatePlaneta(?,?,?)}";
		CallableStatement cst = null;
		try{
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			//parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getImagen());
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
		String sql = "{call deletePlaneta(?)}";
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
	public List<Planeta> search(String criterio) {
		ArrayList<Planeta> listaResul = new ArrayList<Planeta>();
		Planeta p = null;
		try{
			conexion = db.getConexion();
			CallableStatement cst = conexion.prepareCall("{call buscarPlanetas(?)}");
			cst.setString(1, criterio);
			
			ResultSet rs = cst.executeQuery();
			
			while( rs.next() ){
				p = new Planeta();
				p.setId( rs.getLong("id") );
				p.setNombre( rs.getString("nombre") );
				p.setImagen( rs.getString("imagen") );
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
