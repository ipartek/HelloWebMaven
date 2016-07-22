package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;

/**
 * Servlet implementation class EjerServlet
 */
public class EjerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros
		String saludo = request.getParameter("p1");
		String despedida = request.getParameter("p2");
		
		//setea variables de los parametros recogidos
		request.setAttribute("saludo", saludo);
		request.setAttribute("despedida", despedida);
		
		//enviar atributos
		request.getRequestDispatcher(Constantes.VIEW_RESULTADO).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
