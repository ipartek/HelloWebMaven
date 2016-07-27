package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

/**
 * Clase Persona con atributos
 * <ol>
 * <li>nombre</li>
 * <li>apellido1</li>
 * <li>apellido2</li>
 * <li>dni</li>
 * <li>email</li>
 *</ol>
 */

public class Persona {
    private long id;
	private String nombre;
	private String email;
	
	private static final int NEW = -1;
	
	/**
	 * Constructor de Persona que tiene como par�metros
	 * @param nombre {@code String}
	 * @param apellido1 {@code String}
	 * @param apellido2 {@code String}
	 * @param dni {@code String}
	 * @param email {@code String}
	 */
	public Persona() {
		super();
		//this.nombre = nombre;
		//this.apellido1 = apellido1;
		//this.apellido2 = apellido2;
		this.id = NEW;
		this.nombre = "Nuevo Nombre";
		this.email = "Nuevo Email";
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
		
	}

	
	
	
	
}
