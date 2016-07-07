package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Libro;



/**
 * Servlet implementation class LibroServlet
 */
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parámetro
				String parametroId = request.getParameter("id");
							
				//TDOO buscar en BBDD el candidato
				
				//crear Libro
				Libro l = new Libro("Titulo" + parametroId);
				
				//guardar atributo<Candidato> en request
				request.setAttribute("libro", l);
				
				//ir a libro/detalleLibro.jsp
				request.getRequestDispatcher("libro/detalleLibro.jsp").forward(request, response);
						//(fordward dirige a ese jsp)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
