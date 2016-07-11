package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
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
		int val1 = Integer.parseInt(request.getParameter("valor1"));
		int val2 = Integer.parseInt(request.getParameter("valor2"));
		String sum = request.getParameter("suma");
		String rest = request.getParameter("resta");
		String div = request.getParameter("division");
		String mult = request.getParameter("multiplicacion");
		String sel = request.getParameter("select");
		
		
		if(sel.equals(sum)){
			int resul = val1 + val2;
		}
		
	}

}
