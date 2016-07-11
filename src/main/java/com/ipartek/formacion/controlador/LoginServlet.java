package com.ipartek.formacion.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_ADMIN = "admin";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String pagina = "";
		if(USER_ADMIN.equalsIgnoreCase(user) && "admin1".equals(pass)){
			request.setAttribute("nombre", user);
			pagina = "bienvenido.jsp";
		}else{
			request.setAttribute("error", "El usuario no es valido");
			pagina = "login.jsp";
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}
