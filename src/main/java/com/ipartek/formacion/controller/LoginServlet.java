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
	private static final String USUARIO_NAME_ADMIN = "admin";
	private static final String USUARIO_PASS_ADMIN = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session = request.getSession(true);
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			
			if(USUARIO_NAME_ADMIN.equals(usuario) && USUARIO_PASS_ADMIN.equals(password)){
				Persona p = new Persona("admin", "bo", "boa", "123423453425g", "admin@gmail.com");
				session.setAttribute("userLog", p);
				dispatcher = request.getRequestDispatcher("index.jsp");
			}else{
				session.setAttribute("userLog", null);
				request.setAttribute("msg", "Credenciales incorrectas");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
