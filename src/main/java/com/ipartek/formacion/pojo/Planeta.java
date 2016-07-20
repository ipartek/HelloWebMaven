package com.ipartek.formacion.pojo;

public class Planeta {
	
	private int id;
	private String img;
	private String nombre;
	private String distancia;
	
	public Planeta(String img, String nombre, String distancia) {
		super();
		this.img = img;
		this.nombre = nombre;
		this.distancia = distancia;
	}
	public Planeta() {
		super();
		this.id = -1;
		this.img = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
		this.nombre = "";
		this.distancia = "";
	}
	public Planeta(String nombre) {
		this();
		this.nombre = nombre;
	}
	public Planeta(String nombre, int id) {
		this();
		this.nombre = nombre;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Planeta [id=" + id + ", img=" + img + ", nombre=" + nombre + ", distancia=" + distancia + "]";
	}
	
}
