package com.ipartek.formacion.pojo;

public class Puntuacion {

	private int id; 
	private String nombreUsuario;
	private String juego; // Identificador o dni del Libro
	private double puntuacion;
	
	public Puntuacion() {
		// TODO Auto-generated constructor stub
	}

	public Puntuacion(int id, String nombreUsuario, String juego, double puntuacion) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.juego = juego;
		this.puntuacion = puntuacion;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the juego
	 */
	public String getJuego() {
		return juego;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(String juego) {
		this.juego = juego;
	}

	/**
	 * @return the puntuacion
	 */
	public double getPuntuacion() {
		return puntuacion;
	}

	/**
	 * @param puntuacion the puntuacion to set
	 */
	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	

}
