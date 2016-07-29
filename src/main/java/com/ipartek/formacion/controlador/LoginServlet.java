package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.pojo.Usuario;
import com.ipartek.formacion.service.ServiceLogin;
import com.ipartek.formacion.service.ServiceLoginImplDB;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	private HttpSession session = null;
	

	private ServiceLogin serviceP = ServiceLoginImplDB.getInstance();
	Locale locale;
	ResourceBundle propIdioma;
	
	
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		session = request.getSession(true);
		String pIdioma = request.getParameter("idioma");
		//Locale por defecto Español
		if(request.getParameter("idioma")!=null){
			
			String language = pIdioma.split("_")[0];
			String country = pIdioma.split("_")[1];
			locale = new Locale(language,country);
			
		}else{
			locale = new Locale("es","ES");
		}
		
		session.setAttribute("idioma", pIdioma);
		
		//Debemos indicar el package y el nombre del /properties sin la extension 
		propIdioma = ResourceBundle.getBundle("i18nmesages",locale);
		
		LOG.debug("Cargado idioma "+locale);
		super.service(request, response);
	}
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
			String pUsuario = (String)request.getParameter("usuario");
			String pPassword = (String)request.getParameter("password");
			String pIdioma  = request.getParameter("idioma");
			
			LOG.debug("Parametro usuario=" + pUsuario);
			LOG.debug("Parametro pass=" + pPassword);
			LOG.debug("Parametro idioma=" + pIdioma);
			
			Usuario u = new Usuario();
			u = (Usuario)serviceP.getByNomAndPass(pUsuario, pPassword);
			if (u!=null){
				//comprobar usuario valido
				
					LOG.info("Logeado ["+ pUsuario+","+ pPassword +"]");
				
					//TODO recuperar de la BBDD
					//guardar usuario en Session
				
					session.setAttribute("usuario_logeado", u);
				
					//Ir a Backoffice
			
					dispatcher = request.getRequestDispatcher("index.jsp");
				
				
			}else{
				LOG.warn("usuario NO es valido");
				session.removeValue("usuario_logeado");
				//guardar mensaje de error como atributo
				request.setAttribute("msg", propIdioma.getString("login.error"));
				
				//Volver al login 
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			
			dispatcher.forward(request, response);
		
		}catch (Exception e){
			LOG.warn("Error al intentar logearse");
			e.printStackTrace();
		}
		LOG.trace("salimos");
	}

}