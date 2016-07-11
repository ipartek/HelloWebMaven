package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dispatcher;
	
	//CREDENCIALES DEL USUARIO ADMINISTADOR
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces (request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces (request, response);
	}

	
	private void doProcces(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			//RECOGER PARAMETROS
			String pUsuario  = request.getParameter("usuario");
			String pPass = request.getParameter("pass");
			
			//COMPROBAR USUARIO VALIDO
			if ( USUARIO_NAME_ADMIN.equals(pUsuario) && 
					USUARIO_PASS_ADMIN.equals(pPass)){
				//Ir a Backoffice
				dispatcher = request.getRequestDispatcher("backoffice/index.jsp");
				
			}else{
				
				//guardar mensaje como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//Volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
