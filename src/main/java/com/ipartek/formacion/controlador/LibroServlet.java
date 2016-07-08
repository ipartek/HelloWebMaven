package com.ipartek.formacion.controlador;

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
				String parametroId = request.getParameter("id");
				
				//TODO buscar en BBDD el Libro
				
				//Crear Libro
				Libro l = null;
				
				 l = new Libro("Titulo"+parametroId);
				
				
				//guardar atributo <Libro> en request
				request.setAttribute("libro", l);
				
				//ir a candidato/detalleLibro.jsp, cargando el dispatcher con la url
				request.getRequestDispatcher("libro/detalleLibro.jsp").forward(request, response);
			}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
