package com.ipartek.formacion.pojo;

/**
 * Clase Persona con atributos
 * <ol>
 * <li>usuario</li>
 * <li>juego</li>
 * <li>puntuacion</li>
 *</ol>
 */
public class Puntuacion {

	private int id;
	private String usuario;
	private String juego;
	private double puntuacion;
	
	/**
	 * Constructor de la clase Puntuacion
	 * @param usuario {@code String}
	 * @param juego {@code String}
	 * @param puntuacion {@code double}
	 */
	public Puntuacion(int id, String usuario, String juego, double puntuacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.juego = juego;
		this.puntuacion = puntuacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getJuego() {
		return juego;
	}

	public void setJuego(String juego) {
		this.juego = juego;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}  
	
}
