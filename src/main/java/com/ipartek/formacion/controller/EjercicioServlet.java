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
       
	public static final int TIPO_GET = 1;
	public static final int TIPO_POST = 2;
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recoger parametros
		String parametro1 = request.getParameter("pget1");
		String parametro2 = request.getParameter("pget2");
		
		//enviar atributos
			
			//1.-Guardar atributo parametro1 como "nombre" en request
		request.setAttribute("saludo", parametro1 );
		request.setAttribute("despedida", parametro2 );
		request.setAttribute("tipoEnvio", TIPO_GET );
		
			//2.-hacer la request para ir a "ejercicios/resultado.jsp"
		request.getRequestDispatcher("ejercicios/resultado.jsp").forward(request, response);	
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recoger parametros
				String ppost1 = request.getParameter("post1");
				String ppost2 = request.getParameter("post2");
				
				//enviar atributos
				//1.-Guardar atributo ppost1 como "resultadoPost1" en request
				request.setAttribute("resultadoPost1", ppost1 );
				request.setAttribute("resultadoPost2", ppost2 );
				request.setAttribute("tipoEnvio", TIPO_POST );
				
				//2.-hacer la request para ir a "ejercicios/resultado.jsp"
				request.getRequestDispatcher("ejercicios/resultado.jsp").forward(request, response);
				
		
				
	}

}
