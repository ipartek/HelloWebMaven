package com.ipartek.formacion.controlador;

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

	// credenciales del usuario administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";
	private static final String PASSWORD_ADMIN = "administrador";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			//recoger parametros
			String pUsuario = request.getParameter("usuario");
			String pPassword = request.getParameter("password");
		
			//comprobar usuario valido
			if(USUARIO_NAME_ADMIN.equals(pUsuario) && PASSWORD_ADMIN.equals(pPassword)){
			//Ir a Backoffice
			
				dispatcher = request.getRequestDispatcher("backoffice/index.jsp");
				
			
			}else{
				
				//guardar mensaje de error como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				
			//Volver al login 
			dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
		
		}catch (Exception e){
			
			e.printStackTrace();
		}
	}

}
