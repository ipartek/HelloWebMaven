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
	
	//Credenciales del usuario administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";
	
	Persona p= new Persona("Admin","admin@gmail.com");
	
	
	
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
		try{
			
			HttpSession session = request.getSession(true);
			
			//recoger parametros
			String pUsuario = request.getParameter("usuario");
			String pPassword = request.getParameter("password");
			String pIdioma = request.getParameter("idioma");
			
			LOG.debug("Parametro usuario="+pUsuario);
			LOG.debug("Parametro contraseña="+pPassword);
			LOG.debug("Parametro idioma="+pIdioma);
			
			//guardar cookie de idioma
			Cookie cIdioma = new Cookie("cidioma", pIdioma);
			cIdioma.setMaxAge(60*60*24*30); // 1 mes
			response.addCookie(cIdioma);
			
			
			//comprobar usuario valido
			if (USUARIO_NAME_ADMIN.equals(pUsuario) && USUARIO_PASS_ADMIN.equals(pPassword)){
				
				LOG.info("Logeado ["+pUsuario+","+pPassword+"]");
				//TODO recuperar la persona de la BBDD
				//Guardar usuario en Session
				session.setAttribute("usuario_logeado", p);
				
				//Ir a Inicio
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else{
				LOG.warn("Usuario NO valido");
				session.removeValue("usuario_logeado");
				//Guardar mensaje como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				//Volver al Login
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch (Exception e){
			LOG.error("Excepcion "+e.getMessage());
			e.printStackTrace();
		}
		LOG.trace("Salimos");
	}

}
