package com.ipartek.formacion.pojo;

public class Persona {

	private long id;
	private String nombre;
	private String email;
	
	private static final int NEW = -1;
	
	public Persona() {
		super();
		this.id = NEW;
		this.nombre = "Nueva Persona";
		this.email = "https://d30y9cdsu7xlg0.cloudfront.net/png/12462-200.png";
	}

	public Persona(String nombre) {
	    this();
		this.nombre = nombre;		
	}

	public Persona(String nombre, int id) {
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNew(){
		return (this.id==NEW)?true:false;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	

	
	
	
	
	
}
