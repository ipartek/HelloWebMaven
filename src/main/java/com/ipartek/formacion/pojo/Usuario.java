package com.ipartek.formacion.pojo;

public class Usuario {

	
	private long id;
	private String nombre;
	private String pass;
	
	private static final int NEW = -1;
	
	public Usuario() {
		super();
		this.id = NEW;
		this.nombre = "nombre";
		this.pass = "pass";
	}


	public Usuario(long id, String nombre, String pass) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}


	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + "]";
	}
	

}
