package com.ipartek.formacion.pojo;

public class Planeta {
	
	private long id; 
	private String img;
	private String nombre;
	private String distancia;
	
	private static final int NEW = -1;
	
	/**
	 * Constructor de la clase Planeta sin atributos. Atributos:
	 * @param id {@code long}
	 * @param img {@code String}
	 * @param nombre {@code String}
	 * @param distancia {@code String} en años luz
	 */
	public Planeta() {
		super();
		this.id = NEW;
		this.img = "https://cms-assets.tutsplus.com/uploads/users/107/posts/22984/image/25a-space-flat-icons-photoshop-saturn.jpg";
		this.nombre = "Nuevo Planeta";
		this.distancia = "0";
	}
	
	/**
	 * Constructor de la clase Planeta con dos atributos. Atributos:
	 * @param id {@code long}
	 * @param img {@code String}
	 * @param nombre {@code String}
	 * @param distancia {@code String} en años luz
	 */
	public Planeta(long id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}
	
	/**
	 * Constructor de la clase Planeta. Atributos:
	 * @param id {@code long}
	 * @param img {@code String}
	 * @param nombre {@code String}
	 * @param distancia {@code String} en años luz
	 */
	public Planeta(String img, String nombre, String distancia) {
		super();
		this.id = -1;
		this.img = img;
		this.nombre = nombre;
		this.distancia = distancia;
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
	
	public boolean isNew(){
		return (this.id==NEW)?true: false;
	}
	
	
	
}
