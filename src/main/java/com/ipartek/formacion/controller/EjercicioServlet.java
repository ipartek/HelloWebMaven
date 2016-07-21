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

		//recoger parametros
		String parametro1 = request.getParameter("p1");
		String parametro2 = request.getParameter("p2");
		
		//enviar atributos
		//1.-Guardar atributo parametro1 como "nombre" en request
		request.setAttribute("nombre", parametro1 );
		//2.-hacer la request para ir a "ejercicios/resultado.jsp"
		request.getRequestDispatcher("ejercicios/resultado.jsp").forward(request, response);
		
		
	//idem para el parametro2
		request.setAttribute("edad", parametro2 );
		request.getRequestDispatcher("ejercicios/resultado.jsp").forward(request, response);	
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recoger parametros
				String parametro1 = request.getParameter("p1");
				int parametro2 = Integer.parseInt(request.getParameter("p2") );
				
				//enviar atributos
				//1.-Guardar atributo parametro1 como "nombre" en request
				request.setAttribute("nombre", parametro1 );
				//2.-hacer la request para ir a "ejercicios/resultado.jsp"
				request.getRequestDispatcher("ejercicios/resultado.jsp").forward(request, response);
				
		
	}

}
