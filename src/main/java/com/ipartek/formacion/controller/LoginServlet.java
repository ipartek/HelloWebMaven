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
	
	// credenciales del usuario administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";
	
	private RequestDispatcher dispatcher;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			//recoger parámetros
			String pUsuario = request.getParameter("usuario");
			String pPass = request.getParameter("pass");
			
			//comprobar usuario válido
			if(USUARIO_NAME_ADMIN.equals(pUsuario) && USUARIO_PASS_ADMIN.equals(pPass)){
				//ir a Backoffice
				dispatcher = request.getRequestDispatcher("backoffice/index.jsp");
			}else{
				//guardar mansaje como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
				dispatcher.forward(request, response);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}

}
