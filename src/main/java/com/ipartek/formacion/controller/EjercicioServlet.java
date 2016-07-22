package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjercicioServlet
 */
public class EjercicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro1 = request.getParameter("p1");
		String parametro2 = request.getParameter("p2");
		
		
		request.setAttribute("atributo1get", parametro1 );
		request.setAttribute("atributo2get", parametro2 );
		

		//le digo donde tengo que mandarlo la ruta, que en este caso es resultado.jsp
		request.getRequestDispatcher("ejercicios/resultados.jsp").forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recogo los parametros que son de tipo string
		
		String parametro1 = request.getParameter("post1");
		String parametro2 = request.getParameter("post2");
		
		
		request.setAttribute("atributo1post", parametro1 );
		request.setAttribute("atributo2post", parametro2 );
		
		
		//le digo donde tengo que mandarlo la ruta, que en este caso es resultado.jsp
		request.getRequestDispatcher("ejercicios/resultados.jsp").forward(request, response);
		
		
		
	}

}
