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

	protected long id;
	protected String nombre;
	protected String email;
	
	private static final int NEW = -1;
	
	/**
	 * Constructor de Persona que tiene como par�metros
	 * @param id {@code Long}
	 * @param nombre {@code String}
	 * @param email {@code String}
	 */
	public Persona() {
		super();
		this.id = NEW;
		this.nombre = "Nuevo Candidato";
		this.email = "candidato@gmail.com";
	}
	public Persona(String nombre, String email) {
		this();
		this.nombre = nombre;
		this.email = email;
	}
	
	public Persona(String nombre, long id){
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
	
}
