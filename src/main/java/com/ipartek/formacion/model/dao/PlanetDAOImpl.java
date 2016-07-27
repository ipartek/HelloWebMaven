package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controlador.listener.InitListener;
import com.ipartek.formacion.model.DataBaseConnection;
import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Planet;

public class PlanetDAOImpl implements PlanetDAO {
	
	private static PlanetDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;
	
	private final static Logger LOG = Logger.getLogger(PlanetDAOImpl.class);

	

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
	public boolean create(Planet pojo) {
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
			LOG.warn("Error al conectar a la BBDD para crear el planeta"+pojo.getNombre()+","+pojo.getImagen());
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
		return resul;
	}

	@Override
	public List<Planet> getAll() {
		List<Planet> planetas = null;
		String sql = "{call getAllPlanetas()}";
		try {
			conexion = db.getConexion();		
			Planet p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			planetas = new ArrayList<Planet>();
			while (rs.next()) {
				p = new Planet();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));
				// add en lista
				planetas.add(p);
			}

		} catch (SQLException e) {
			LOG.warn("Error al intentar conectarse a la BBDD para listar todos los planetas");
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return planetas;
	}

	@Override
	public Planet getById(long id) {
		Planet p = null;
		CallableStatement cst = null;
		String sql = "{call buscarPlaneta(?)}";
		try {
			conexion = db.getConexion();			
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();			
			while (rs.next()) {
				p = new Planet();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setImagen(rs.getString("imagen"));				
			}

		} catch (SQLException e) {
			LOG.warn("Error al intentar conectarse a la BBDD encontrar planeta con id:"+id);
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
		return p;
	}

	@Override
	public boolean update(Planet pojo) {
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
			LOG.warn("Error al intentar conectarse a la BBDD para modificar planeta: "+pojo.getId()+","+pojo.getNombre()+","+pojo.getImagen());
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
			LOG.warn("Error al intentar conectarse a la BBDD para eliminar planeta con id: "+id);
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
		return resul;
	}

	@Override
	public List<Planet> search(String criterio) {
		ArrayList<Planet> listaResul = new ArrayList<Planet>();
		Planet p = null;
		try{
			conexion = db.getConexion();
			CallableStatement cst = conexion.prepareCall("{call buscarPlanetas(?)}");
			cst.setString(1, criterio);
			
			ResultSet rs = cst.executeQuery();
			
			while( rs.next() ){
				p = new Planet();
				p.setId( rs.getLong("id") );
				p.setNombre( rs.getString("nombre") );
				p.setImagen( rs.getString("imagen") );
				listaResul.add(p);
			}
						
		}catch(Exception e){
			LOG.warn("Error al intentar listar planetas con criterio: "+criterio);
			e.printStackTrace();
		}finally{
			db.desconectar();
		}			
		return listaResul;
	}

}