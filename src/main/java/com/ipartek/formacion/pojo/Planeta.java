package com.ipartek.formacion.pojo;

public class Planeta {
	
	private String img;
	private String nombre;
	private String distancia;
	
	public Planeta(String img, String nombre, String distancia) {
		this.img = img;
		this.nombre = nombre;
		this.distancia = distancia;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Planeta [img=" + img + ", nombre=" + nombre + ", distancia=" + distancia + "]";
	}
	
	

}
