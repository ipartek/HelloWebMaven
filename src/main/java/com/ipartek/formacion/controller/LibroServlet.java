package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Libro;

/**
 * Servlet implementation class LibroServlet
 */
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametro
		String parametroIsbn = request.getParameter("isbn");
		
		//TODO buscar el Libro en BBDD
		
		//crear Libro
		Libro l = null;
		
		l = new Libro(parametroIsbn, "Titulo desconocido", "Anonimo", 100);
				
		//Guardar atributo<candidato> en request
		request.setAttribute("libro", l);
		
		//ir a candidato/detalle.jsp
		request.getRequestDispatcher("libro/detalle.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
