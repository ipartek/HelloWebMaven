package com.ipartek.formacion.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.service.ServicePersonaImplDB;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);
	
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
		LOG.trace("entramos");
		try {
			
			//recupero la sesión de la request del usuario
			HttpSession session = request.getSession(true);
			
			//recoger parámetros
			String pUsuario = request.getParameter("usuario");
			String pPass = request.getParameter("pass");
			LOG.debug("Parametro usuario=" + pUsuario);
			LOG.debug("Parametro pass=" + pPass);
			
			//comprobar usuario válido
			if(USUARIO_NAME_ADMIN.equals(pUsuario) && USUARIO_PASS_ADMIN.equals(pPass)){
				
				LOG.info("Logeado [" + pUsuario + ", "+ pPass + "]");
				//TODO recuperar la persona en la BBDD
				//guardar usuario en session, y podremos obtenerla desde cualquier sitio
				Persona p = new Persona("Admin", "Gorriti", "Urrutia", "11111111H", "admin@ipartek.com");
				session.setAttribute("usuario_logeado", p);
				
				//ir a Backoffice
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else{
				LOG.warn("Usuario no valido");
				session.setAttribute("usuario_logeado", null);
				
				//guardar mansaje como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
				dispatcher.forward(request, response);
			
			} catch (Exception e) {
				LOG.error("Excepcion " + e.getMessage());
				e.printStackTrace();
			}
		LOG.trace("salimos");
	}

}
