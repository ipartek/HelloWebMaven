package com.ipartek.formacion.pojo;

public class Planeta {

	private long id;
	private String nombre;
	private String imagen;
	
	private static final int NEW = -1;
	
	public Planeta() {
		super();
		this.id = NEW;
		this.nombre = "Nuevo Planeta";
		this.imagen = "http://orig06.deviantart.net/b0d8/f/2013/183/b/6/planet_icon_by_flutterbr0-d6bouaz.png";
	}

	public Planeta(String nombre) {
	    this();
		this.nombre = nombre;		
	}

	public Planeta(String nombre, int id) {
	    this();
	    this.id = id;
		this.nombre = nombre;		
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

	public boolean isNew(){
		return (this.id==NEW)?true:false;
	}
	
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + "]";
	}
	

	
	
	
	
	
}