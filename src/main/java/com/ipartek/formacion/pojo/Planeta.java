package com.ipartek.formacion.pojo;

public class Planeta {
	
	private long id;
	private String imagen;
	private String nombre;
	
	public Planeta() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
	}
	
	public Planeta(String nombre) {
		this();
		this.nombre = nombre;
		
	}
	
	public Planeta(String nombre, int id) {
		this();
		this.nombre = nombre;
		this.id = id;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", imagen=" + imagen + ", nombre=" + nombre + "]";
	}
	
	
	
	

	
	

}
