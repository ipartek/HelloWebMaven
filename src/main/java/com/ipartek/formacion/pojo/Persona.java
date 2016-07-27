package com.ipartek.formacion.pojo;

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

	protected int id;
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected String email;
	
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
	}
	
	public Persona(int id, String nombre, String apellido, String dni, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
				+ ", getDni()=" + getDni() + ", getEmail()=" + getEmail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	
	
	
	
}
