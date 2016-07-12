package com.ipartek.formacion.pojo;

public class Puntuacion {

	private int id;
	private String nombreUsuario;
	private String juego;
	private double puntuacion;


	public Puntuacion (int id, String nombreUsuario, String juego, double puntuacion){
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.juego = juego;
		this.puntuacion = puntuacion;
	}


	public int getId() {
		return id;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getJuego() {
		return juego;
	}


	public double getPuntuacion() {
		return puntuacion;
	}
	
	
}
