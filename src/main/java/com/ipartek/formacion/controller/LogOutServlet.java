package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

/**
 * Servlet implementation class LogOutServlet
 */
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

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
			
			HttpSession session = request.getSession(true);  //obtenemos la session. 
			//Con true le inicializamos la sesion en caso de que no tenga datos ya que sino cascaría
			session.invalidate();     //invalidamos la session
			
			//le indicamos que vaya a la pantalla de login
			request.getRequestDispatcher("login.jsp").forward(request, response);	
			
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
	}


}
