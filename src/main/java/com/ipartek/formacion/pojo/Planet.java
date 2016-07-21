package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

public class Planet {

	private long id;
	private String nombre;
	private String imagen;
	
	private static final int NEW = -1;
	
	
	
	public Planet() {
		super();
		this.id = NEW;
		this.nombre = "Nuevo Planeta";
		this.imagen = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
	}
	
	


	public Planet(String nombre, long id) {
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

	public boolean isNew(){
		
		return (NEW == this.id)?true:false;
	}
	

	@Override
	public String toString() {
		return "Planet [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
	
	
	
	
	
}
