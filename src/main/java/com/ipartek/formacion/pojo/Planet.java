package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

public class Planet {

	private long id;
	private String nombre;
	private String imagen;
	
	
	
	public Planet() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
	}
	
	


	public Planet(String nombre, int id) {
		this();
		this.setNombre(nombre);
		this.id = id;
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
		this.nombre =Utilidades.capitalizar(nombre);
	}



	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}



	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Planet [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
	
	
	
	
	
}
