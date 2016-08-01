package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Persona;
import com.mysql.jdbc.log.Log;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginServlet.class);
	private Properties props = null;
	
	private RequestDispatcher dispatcher;
	private HttpSession session = null;
	
	//CREDENCIALES DEL USUARIO ADMINISTADOR
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";
	
	Locale locale =null;
	ResourceBundle propIdioma = null;

	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		LOG.trace("init");
		super.init(config);
		props = (Properties) getServletContext().getAttribute(InitListener.ATTRIBUTE_PROPS_NAME);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true);
		String pIdioma = request.getParameter("idioma");
		
		//Locale o idioma seleccionado por el usuario
		if ( request.getParameter("idioma") != null ){			
			String language = pIdioma.split("_")[0];
			String country  = pIdioma.split("_")[1];			
			locale = new Locale( language, country );			
		}else{
			locale = new Locale("es","ES");
		}	
		
		session.setAttribute("idioma", pIdioma );
		
		// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale 
		propIdioma = ResourceBundle.getBundle("i18nmesages", locale );
		
		LOG.debug("Cargado Idioma " + locale );
		super.service(request, response);
	}


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
		LOG.trace("init");
		try{
			
			//recuperamos la sesion de la peticion de usuario
			HttpSession session = request.getSession(true);
			
			//RECOGER PARAMETROS
			String pUsuario  = request.getParameter("usuario");
			String pPass = request.getParameter("pass");
			
			//COMPROBAR USUARIO VALIDO
			if ( USUARIO_NAME_ADMIN.equals(pUsuario) && 
					USUARIO_PASS_ADMIN.equals(pPass)){
				
				LOG.debug("usuario logeado");
				//TODO RECUPERAR DE LA BASE DE DATOS
				
				//guardar usuario en Session
				Persona p = new Persona("Admin", "Gorriti", "Urrutia", "1111111H", "admin@ipartek.com" );
				session.setAttribute("usuario_logeado", p);
				
				//Ir a Backoffice
				dispatcher = request.getRequestDispatcher("index.jsp");
				
			}else{
				LOG.debug("usuario no es valido");
				session.removeAttribute("usuario_logeado");
				//guardar mensaje como atributo
				request.setAttribute("msg", propIdioma.getString("login.error") );
				//Volver al Login
				dispatcher = request.getRequestDispatcher( props.getProperty("view.login"));
			}
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
}
