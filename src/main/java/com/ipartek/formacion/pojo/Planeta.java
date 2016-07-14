package com.ipartek.formacion.pojo;

public class Planeta {
	
     private String imagen;
     private String nombre;
     private String distancia;
     
     
          
     
     
	public Planeta(String imagen, String nombre, String distancia) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.distancia = distancia;
	}
	
	
	
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
     

}
