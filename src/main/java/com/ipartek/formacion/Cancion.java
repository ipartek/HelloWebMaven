package com.ipartek.formacion;

public class Cancion {
	
	private String nombre;
	private String duracion;
	private String genero;
	
	
	public Cancion(String nombre) {
		super();
		this.nombre = nombre;
		this.duracion = "00:00";
		this.genero = "";
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", duracion=" + duracion + ", genero=" + genero + "]";
	}
	
}
