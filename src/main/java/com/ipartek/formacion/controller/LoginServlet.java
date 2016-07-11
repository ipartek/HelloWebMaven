package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.pojo.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;

	// credenciales e administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";

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
		try {
			
			 HttpSession session = request.getSession(true);

			// recoger parametros
			String pUsuario = request.getParameter("usuario");
			String pPassword = request.getParameter("password");

			// comprobar usuario valido

			if (USUARIO_NAME_ADMIN.equals(pUsuario) && USUARIO_PASS_ADMIN.equals(pPassword)) {
				// acceso
				dispatcher=request.getRequestDispatcher("backoffice/index.jsp");	
				
				// guardar usuario en sesion
				Persona p = new Persona("admin", "gorriti", "urrutia", "345672h", "email@gmail.com");
				session.setAttribute("usuario", p);
				
			} else {
				session.setAttribute("usuario",null);
				// volver al login
				dispatcher=request.getRequestDispatcher("login.jsp");
				
				//guardar mensaje como atributo
				request.setAttribute("msg", "Crendeciales incorrectas");
			}

			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
