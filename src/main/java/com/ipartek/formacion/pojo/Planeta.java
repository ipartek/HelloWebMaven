package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

public class Planeta {

	
	protected String img;
	protected String nombre;
	protected String distancia;
	
	
	public Planeta() {
		super();
	}


	public Planeta(String img, String nombre, String distancia) {
		super();
		this.img = img;
		this.setNombre(nombre);
		this.distancia = distancia;
	}


	public Planeta(String nombre) {
		this();
		this.setNombre(nombre);
	}


	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
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
		this.nombre = Utilidades.capitalizar(nombre);
	}


	/**
	 * @return the distancia
	 */
	public String getDistancia() {
		return distancia;
	}


	/**
	 * @param distancia the distancia to set
	 */
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	

}
