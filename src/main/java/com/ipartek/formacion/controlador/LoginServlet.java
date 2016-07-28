package com.ipartek.formacion.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

	private RequestDispatcher dispatcher;

	// credenciales del usuario administrador
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";
	
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);

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
		LOG.trace("entramos");
		try{
			
			HttpSession session = request.getSession(true);
			
			//recoger parametros
			String pUsuario = request.getParameter("usuario");
			String pPassword = request.getParameter("password");
			LOG.debug("Parametro usuario= "+pUsuario);
			LOG.debug("Parametro pass= "+pPassword);
			//comprobar usuario valido
			if (USUARIO_NAME_ADMIN.equals(pUsuario) &&
					USUARIO_PASS_ADMIN.equals(pPassword)){
				LOG.info("logeado ["+pUsuario+","+pPassword+"]");
				//TODO recuperar de la BBDD
				//guardar usuario en Session
				Persona p = new Persona("Admin", "Gorriti", "Urrutia", "44444444L", "email@email.com");
				session.setAttribute("usuario_logeado", p);
				
				//Ir a Backoffice
			
				dispatcher = request.getRequestDispatcher("index.jsp");
				
			
			}else{
				LOG.warn("Usuario NO valido");
				session.setAttribute("usuario_logeado", null);
				//guardar mensaje de error como atributo
				request.setAttribute("msg", "Credenciales incorrectas");
				
				//Volver al login 
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
		
		}catch (Exception e){
			LOG.error("Excepcion "+e.getMessage());
			e.printStackTrace();
		}
		LOG.trace("salimos");
	}

}
