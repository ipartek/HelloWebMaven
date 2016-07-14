package com.ipartek.formacion.pojo;

public class Planeta {
	
	public String nombre,img,distancia;

	public Planeta(String nombre, String img, String distancia) {
		super();
		this.nombre = nombre;
		this.img = img;
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	
	

}
