package com.ipartek.formacion.pojo;

public class Planeta {
	
	private int id;
	private String nombre,img,distancia;
	private static final int NEW = -1;

	public Planeta() {
		super();
		this.id = NEW;
		this.nombre = "Nuevo planeta";
		this.img = "https://cdn3.iconfinder.com/data/icons/solarsystem/PNG/128x128/mercury.png";
		
	}

	public Planeta(String nombre) {
		this();
		this.nombre = nombre;
	}
	
	public Planeta(String nombre,int id) {
	    this();
		this.nombre = nombre;
		this.id = id;
	}
	
	public boolean isNew(){
		return (this.id == NEW)?true:false;
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
