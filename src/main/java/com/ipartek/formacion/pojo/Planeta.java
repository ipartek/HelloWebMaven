package com.ipartek.formacion.pojo;

public class Planeta {
	
	private long id;
	private String img;
	private String nombre;
	private String distancia;
	
	private static final int NEW = -1;
	
	public Planeta(String img, String nombre, String distancia) {
		super();
		this.img = img;
		this.nombre = nombre;
		this.distancia = distancia;
	}
	public Planeta() {
		super();
		this.id = NEW;
		this.img = "http://icdn.pro/images/en/a/s/astroid-moon-planet-icone-5626-128.png";
		this.nombre = "Planeta Nuevo";
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	//Metodos propios
	public boolean isNew(){
		return (this.id==NEW)?true:false;
	}
	
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", img=" + img + ", nombre=" + nombre + ", distancia=" + distancia + "]";
	}
	
}
