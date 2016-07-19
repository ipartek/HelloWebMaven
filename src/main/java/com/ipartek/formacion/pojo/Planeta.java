package com.ipartek.formacion.pojo;

/**
 * Clase para crear planetas. 
 * @
 * @author Josu Hernandez
 *
 */
public class Planeta {

	//Atributos  
		private long id;
		private String img;
		private String nombre;
;
	
	/**
	 * Constructor de la clase Planeta
	 * @param img {@code String}  contiene URL con imagen del planeta
	 * @param nombre {@code String}  nombre del planeta
	 * @param distancia {@code Float}  distancia al planeta desde la Tierra en UA (Unidades Astronomicas 1UA=150.000.000 km)
	 */
	public Planeta(String img, String nombre, Float distancia) {
		
		super();
		this.id = -1;   //lo inicializo con un valor que nunca va a tener un planeta
		this.img = "http://www.freeiconspng.com/uploads/science-planet-icon-png-22.png";
		this.nombre = "";

		
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
	
	
	@Override
	public String toString() {
		return "Planeta [id=" + id + ", img=" + img + ", nombre=" + nombre + "]";
	}

	

}
