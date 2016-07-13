package com.ipartek.formacion.pojo;

public class Puntuacion {
	private int id;
	private String usuario;
	private String juego;
	private double puntuacion;
	
	public Puntuacion(int id,String usuario, String juego, double puntuacion) {
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
