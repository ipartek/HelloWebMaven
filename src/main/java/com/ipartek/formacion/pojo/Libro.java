package com.ipartek.formacion.pojo;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private int paginas;

	/**
	 * Constructor de la clase Libro. Atributos:
	 * <ul>
	 * <li>isbn {@code String}
	 * <li>titulo {@code String}
	 * <li>autor {@code String}
	 * <li>paginas {@code int}
	 * @param isbn {@code String}
	 */
	public Libro(String isbn, String titulo, String autor, int paginas) {
		super();
		setIsbn(isbn);
		setTitulo(titulo);
		setAutor(autor);
		setPaginas(paginas);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + "]";
	}
	
	
	
}
