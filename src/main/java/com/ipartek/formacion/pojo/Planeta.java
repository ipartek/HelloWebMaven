package com.ipartek.formacion.pojo;

/**
 * Clase para crear planetas. 
 * @
 * @author Josu Hernandez
 *
 */
public class Planeta {

	//Atributos  
		private String img;
		private String nombre;
		private Float distancia;
	
	/**
	 * Constructor de la clase Planeta
	 * @param img {@code String}  contiene URL con imagen del planeta
	 * @param nombre {@code String}  nombre del planeta
	 * @param distancia {@code Float}  distancia al planeta desde la Tierra en UA (Unidades Astronomicas 1UA=150.000.000 km)
	 */
	public Planeta(String img, String nombre, Float distancia) {
		
		this.img = img;
		this.nombre = nombre;
		this.distancia = distancia;
		
		
	}

	public String getImg() {
		return img;
	}

	
	public String getNombre() {
		return nombre;
	}


	public Float getDistancia() {
		return distancia;
	}


}
