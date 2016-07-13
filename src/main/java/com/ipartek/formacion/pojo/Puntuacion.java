package com.ipartek.formacion.pojo;

public class Puntuacion {
	private int id;
	private String nombreUsuario;
	private String juego;
	private double puntuacion;
	
	
	
	public Puntuacion(int id, String nombreUsuario, String juego, double puntuacion) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.juego = juego;
		this.puntuacion = puntuacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
