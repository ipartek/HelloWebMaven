package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Servlet implementation class PlanetaServlet
 */
public class PlanetaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final ArrayList<Planeta> listaPlanetas = new ArrayList<Planeta>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listaPlanetas.add(new Planeta());
		
		
		//enviar el atributo lista de planetas
		request.setAttribute("planetas", listaPlanetas);
				
		//ir a ejercicios/planetas.jsp	
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
