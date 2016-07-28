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

import com.ipartek.formacion.pojo.Persona;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG =Logger.getLogger(LoginServlet.class);
	
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
	LOG.trace("entrada");
		try {
			
			HttpSession session = request.getSession(true);
			
			//recoger parametros
			String pUsuario = request.getParameter("usuario"); 			
			String pPass    = request.getParameter("pass");
			String pIdioma    = request.getParameter("idioma");
			LOG.debug("parametro usuario= "+ pUsuario);
			
			//guardar cookie de idioma
			Cookie cIdioma=new Cookie("cidioma", pIdioma);
			cIdioma.setMaxAge(-1);
			response.addCookie(cIdioma);
			
			//comprobar usuario valido
			if ( USUARIO_NAME_ADMIN.equals(pUsuario) && 
				 USUARIO_PASS_ADMIN.equals(pPass)	){
				
				
				//TODO recuperar de la BBDD
				LOG.info("Logeado ["+pUsuario+","+pPass+"]");
				//guardar usuario en Session
				Persona p = new Persona("Admin", "Gorriti", "Urrutia", "1111111H", "admin@ipartek.com");
				session.setAttribute("usuario_logeado",p);
				
				//Ir a Backoffice
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else{
				LOG.warn("Usuariono no es valido");
				session.removeValue("usuario_logeado");
				//guardar mensaje como attributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//Volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			
			LOG.error("Excepcion "+e.getMessage());
			e.printStackTrace();
		}
		
		LOG.trace("salida");
	}
	
	

}
