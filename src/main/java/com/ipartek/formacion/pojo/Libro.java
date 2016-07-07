package com.ipartek.formacion.pojo;

public class Libro {

}

package com.ipartek.formacion.nombreproyecto.pojo;


/**
 * Clase para generar objetos de tipo Libro
 * 
 * @author Curso
 *
 */
package com.ipartek.formacion.pojo;

public class Libro {
	
	
	//Atributos  (Variables)
	private String titulo;
	private int numeroPaginas;
	private String autor;
	private String isbn;     //Identificador o dni del libro

	
	//crear el constructor -- Source-->Generate Constructor using Fields
	/**
	 * Constructor que nos pide obligatoriamente un "titulo" de <code>Libro</code>.<br>
	 * El resto de atributos del <code>Libro</code> se inicializan:
	 * <ul>
	 * 		<li><code>String</code> autor = " anonimo" </li>
	 * 		<li><code>String</code> isbn = " "</li>
	 * 		<li><code>int</code> numeropaginas = 0</li>
	 * </ul>
	 * @param titulo <code>String</code>  corresponde al titulo del libro.
	 */
	public Libro(String titulo) {
		super();
		this.titulo = titulo;
		this.numeroPaginas = 0;
		this.autor = "anonimo";
		this.isbn = "";
	}

	
	
	//getters y setters
	//Source-->Generate Getters and Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	

	public int getNumeroPaginas() {
		return numeroPaginas;
	}



	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}



	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	//metodo ToString que devuelve los datos del libro
	//Source-->Generate toString()...
	@Override   //indica que sobreescribimos al padre
	public String toString() {
		return "Libro [titulo=" + titulo + ", numeroPaginas=" + numeroPaginas + ", autor=" + autor + ", isbn=" + isbn
				+ "]";
	}
		
	
}