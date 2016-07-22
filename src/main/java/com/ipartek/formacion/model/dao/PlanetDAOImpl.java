package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseHelperImpl;
import com.ipartek.formacion.pojo.Planeta;

public class PlanetDAOImpl implements PlanetDAO {
	
	private static PlanetDAOImpl INSTANCE = null;
		private static DataBaseHelperImpl db;
		private Connection conexion;
	
		private PlanetDAOImpl() {
			db = DataBaseHelperImpl.getInstance();
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
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public List<Planeta> getAll() {
			List<Planeta> planetas = null;
			String sql = "{call getAllPlanetas()}";
			conexion = db.getConexion();
			try {
				Planeta p = null;
				CallableStatement cSmt = conexion.prepareCall(sql);
				ResultSet rs = cSmt.executeQuery();
				planetas = new ArrayList<Planeta>();
				while (rs.next()) {
					p = new Planeta();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setImg(rs.getString("imagen"));
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
		public Planeta getById(int id) {
			Planeta p = null;
			/*for(int i=0;i<planetas.size();i++){
				if(id==planetas.get(i).getId()){
					p= planetas.get(i);
					break;
				}
			}	
			return p;
		*/
			return  p;
		}
	
		@Override
		public boolean update(Planeta pojo) {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public boolean delete(long id) {
			// TODO Auto-generated method stub
			return false;
		}
	
		@Override
		public List<Planeta> search(String criterio) {
			ArrayList<Planeta> resul = new ArrayList<Planeta>();
			Planeta p = null;
			try {
				conexion = db.getConexion();
				CallableStatement cst = conexion.prepareCall("{call buscarPlanetas(?)}");
				cst.setString(1, criterio);
				ResultSet rs = cst.executeQuery();
				while (rs.next()){
					p= new Planeta();
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setImg(rs.getString("imagen"));
					resul.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				db.desconectar();
			}
			return resul;
		}
	
	}