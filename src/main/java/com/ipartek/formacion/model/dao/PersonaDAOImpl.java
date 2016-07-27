package com.ipartek.formacion.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;


/**
 * Clase que gestiona la conexión a la BBDD para realizar las operaciones CRUD
 * @author JOSU HERNANDEZ
 *
 * @param <P> 
 */
public class PersonaDAOImpl<P> implements PersistAble<P> {

	private static PersonaDAOImpl INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conexion;

	//Patron SINGLETON *********************************
	
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
	//Fin patrón SINGLETON*******************************
	
	@Override
	public boolean create(P pojo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<P> getAll() {
		List<P> personas = null;
		String sql = "{call getAllPersonas()}";     //llamada a la rutina almacenada en BBDD getAllPersonas()
		
		
//		System.out.println("sql=" + sql);
		try {
		    conexion = db.getConexion();
			Persona p = null;
			CallableStatement cSmt = conexion.prepareCall(sql);
			ResultSet rs = cSmt.executeQuery();
			personas = new ArrayList<P>();
//			System.out.println("personas antes=" + personas);
			while (rs.next()) {
				p = new Persona();
				p.setId(rs.getLong("id"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				// add en lista
				personas.add((P) p);
//				System.out.println("personas antes=" + personas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return (List<P>) personas;
	}

	@Override
	public P getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(P pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
