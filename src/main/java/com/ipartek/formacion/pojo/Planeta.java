package com.ipartek.formacion.pojo;

public class Planeta {

	private long id;
	private String nombre;
	private String imagen;
	
	
	public Planeta() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
	

	
	
	
	
	
}
