package com.ipartek.formacion.pojo;

public class Planetas {

	private String distance;

	private String name;

	private String img;

	/**
	 * @param distance
	 * @param nameplanet
	 */
	public Planetas(String distance, String name) {
		super();
		this.distance = distance;
		this.name = name;
		this.img = img;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
