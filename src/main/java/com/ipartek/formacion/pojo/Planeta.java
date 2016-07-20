package com.ipartek.formacion.pojo;

public class Planeta {
	
	private int id;
	private String nombre,img,distancia;

	public Planeta() {
		super();
		this.id = -1;
		this.nombre = "";
		this.img = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
		this.distancia = "";
	}

	public Planeta(String nombre) {
		this();
		this.nombre = nombre;
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


	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", img=" + img + ", distancia=" + distancia + "]";
	}
	
	

}
