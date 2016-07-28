package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);
	
	
	private RequestDispatcher dispatcher;
	
	//credenciales del usuario administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";

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
			
			HttpSession session = request.getSession(true);
			
			//recoger parametros
			String pUsuario = request.getParameter("usuario"); 
			String pPass    = request.getParameter("pass");
			String pIdioma = request.getParameter("idioma");
			LOG.debug("parametro usuario"+ pUsuario);
			LOG.debug("parametro pass"+ pPass);
			
			//crear y guardar cookie de idioma
			Cookie cIdioma = new Cookie("cIdioma", pIdioma);
			cIdioma.setMaxAge(60*60*24*30);
			
			response.addCookie(cIdioma);
			
			
					
			
			
			//comprobar usuario valido
			if ( USUARIO_NAME_ADMIN.equals(pUsuario) && 
				 USUARIO_PASS_ADMIN.equals(pPass)	){
				LOG.info("Logeado "+ pUsuario+ " ," + pPass + "]");
				//TODO recuperar de la BBDD
				//guardar usuario en Session
				Persona p = new Persona("Admin", "Gorriti", "Urrutia", "1111111H", "admin@ipartek.com");
				session.setAttribute("usuario_logeado",p);
				
				//Ir a Backoffice
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else{	
				LOG.debug("usuario no es valido");
				session.removeValue("usuario_logeado");
				//guardar mensaje como attributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//Volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		
		LOG.trace("salimos");
	}
	
	
    
}
