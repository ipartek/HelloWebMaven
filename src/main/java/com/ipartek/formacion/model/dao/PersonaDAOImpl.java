package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;


public class PersonaDAOImpl implements PersistAble<Persona> {

	private static PersonaDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;
	
	private final static Logger LOG = Logger.getLogger(PersonaDAOImpl.class);

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
		boolean resul = false;
		String sql = "{call insertPersona(?, ?, ?)}";
		CallableStatement cst = null;

		try {
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			// parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getEmail());

			if (cst.executeUpdate() == 1) {
				resul = true;
				pojo.setId(cst.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Excepcion en la ejecucion de InsertPersona" + e.getStackTrace());
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {
				e.printStackTrace();
				LOG.error("Excepcion al cerrar CallableStatement" + e.getStackTrace());
			}
			db.desconectar();
		}

		return resul;
	}

	@Override
	public List<Persona> getAll() {
		List<Persona> personas = null;
		String sql = "{call getAllPersonas()}";
		CallableStatement cSmt = null;
				
		try {
			conexion = db.getConexion();
			Persona p = null;
			cSmt = conexion.prepareCall(sql);
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
			LOG.error("Excepcion en la ejecucion de getAllPersonas" + e.getStackTrace());
		} finally {
			try {
				cSmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
				LOG.error("Excepcion al cerrar CallableStatement" + e.getStackTrace());
			}
			db.desconectar();
		}
		return personas;
	}

	@Override
	public Persona getById(long id) {

		Persona persona = null;
		String sql = "{call buscarPersona(?)}";
		CallableStatement cst = null;

		try {
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();

			if (rs.next()) {

				persona = new Persona();
				persona.setId(rs.getLong("id"));
				persona.setNombre(rs.getString("nombre"));
				persona.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Excepcion en la ejecucion de buscarPersona" + e.getStackTrace());
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {

				e.printStackTrace();
				LOG.error("Excepcion al cerrar CallableStatement" + e.getStackTrace());
			}
			db.desconectar();
		}
		return persona;

	}

	@Override
	public boolean update(Persona pojo) {
		boolean resul = false;
		String sql = "{call updatePersona(?, ?, ?)}";
		CallableStatement cst = null;

		try {
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			// parametros entrada
			cst.setString(1, pojo.getNombre());
			cst.setString(2, pojo.getEmail());
			cst.setLong(3, pojo.getId());

			// ejecutar
			if (cst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Excepcion en la ejecucion de updatePersona" + e.getStackTrace());
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {
				e.printStackTrace();
				LOG.error("Excepcion al cerrar CallableStatement" + e.getStackTrace());
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

		try {
			conexion = db.getConexion();
			cst = conexion.prepareCall(sql);
			// parametros entrada
			cst.setLong(1, id);

			// ejecutar
			if (cst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error("Excepcion en la ejecucion de deletePersona" + e.getStackTrace());
		} finally {
			try {
				cst.close();
			} catch (SQLException e) {
				e.printStackTrace();
				LOG.error("Excepcion al cerrar CallableStatement" + e.getStackTrace());
			}
			db.desconectar();
		}

		return resul;
	}

}
