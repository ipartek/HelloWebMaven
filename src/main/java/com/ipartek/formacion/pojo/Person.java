package com.ipartek.formacion.pojo;

import com.ipartek.formacion.Utilidades;

/**
 * Clase Persona con atributos
 * <ol>
 * <li>nombre</li>
 * <li>email</li>
 * </ol>
 */

public class Person {

	private static final long NEW = -1;
	
	protected Long id;//
	protected String nombre;//
	protected String email;//

	/**
	 */
	public Person(long id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	

	public Person() {
		super();
		this.id = NEW;
		this.nombre = "Nuevo nombre";
		this.email = "email@email.com";
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
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
		return (this.id==NEW)?true:false;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}
	

}
