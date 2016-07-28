package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.pojo.Persona;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(LoginServlet.class);
	
	private Properties props = null;	
	private RequestDispatcher dispatcher;
	
	HttpSession session = null;
	String pUsuario = ""; 
	String pPass    = "";
	String pIdioma  = "";
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		LOG.trace("init");
		super.init(config);
		props = (Properties) getServletContext().getAttribute(InitListener.ATTRIBUTE_PROPS_NAME);
	}
	
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
			
			session = request.getSession(true);
			
			//recoger parametros
			pUsuario = request.getParameter("usuario"); 
			pPass    = request.getParameter("pass");
			pIdioma  = request.getParameter("idioma");
						
			LOG.debug("Parametro usuario=" + pUsuario);
			LOG.debug("Parametro pass=" + pPass);
			LOG.debug("Parametro idioma=" + pIdioma);
			
			//crear y guardar cookie de idioma			
			Cookie cIdioma = new Cookie("cidioma", pIdioma);
			cIdioma.setMaxAge(60*60*24*30); // 1 mes			
			response.addCookie(cIdioma);	
			LOG.debug("cookie idioma creada " + pIdioma );
				
			
			//comprobar usuario valido
			login(request,response);
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			LOG.error("Excepcion " + e.getMessage() );
			e.printStackTrace();
		}
		
		LOG.trace("salimos");
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
				
		//TODO txapuza absoluta por llamar direcatament al procedimiento almacenado
		try{
			DataBaseConnectionImpl db = DataBaseConnectionImpl.getInstance();
			Connection con = db.getConexion();
			CallableStatement cst = con.prepareCall("{call login(?,?)}");
			cst.setString(1, pPass );
			cst.setString(2, pUsuario );
			
			ResultSet rs = cst.executeQuery();
			if ( rs.next() ){
				
				LOG.info("Logeado ["+ pUsuario+","+ pPass +"]");
	
				Persona p = new Persona( rs.getLong("id"), rs.getString("nombre"), rs.getString("email"));
				session.setAttribute("usuario_logeado",p);
				
				//Ir a Backoffice
				dispatcher = request.getRequestDispatcher(props.getProperty("view.index"));
				
			}else{
				LOG.warn("Usuario NO valido");
				session.setAttribute("usuario_logeado",null);
				//guardar mensaje como attributo			
				request.setAttribute("msg", "Credenciales incorrectas");
				//Volver al Login
				dispatcher = request.getRequestDispatcher( props.getProperty("view.login"));
			}
			
			rs.close();
			cst.close();
			con.close();
			
		}catch(Exception e){
			LOG.fatal("No funciona Login");
			e.printStackTrace();
			
		}
					
	}
	
	

}
