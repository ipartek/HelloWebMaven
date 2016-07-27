package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

public class Person {

	private long id;
	private String nombre;
	private String email;
	
	private static final int NEW = -1;

	public Person() {
		super();
		this.id = NEW;
		this.nombre = "Nombre";
		this.email = "email@email.com";
	}

	public Person(long id, String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
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
		this.nombre = Utilidades.capitalizar(nombre);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isNew(){
		
		return (NEW == this.id)?true:false;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
}
