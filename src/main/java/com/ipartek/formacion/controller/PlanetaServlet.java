package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Planeta> lista = new ArrayList<Planeta>();
		
		
		
		lista.add(new Planeta("Marte", "http://fegar.eu/web/wp-content/uploads/2015/04/marte.jpg", "227.900.000 km"));
		lista.add(new Planeta("Jupiter", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQpCg-TzM-Ah1jJjh5XygaKplIathR0Jowra0TaWm7-DLiVhdkQIg", " 778.500.000 km"));
		lista.add(new Planeta("Saturno","https://i.ytimg.com/vi/IWVyGBPiLSM/maxresdefault.jpg"," 1,429 * 10^9 km"));
		lista.add(new Planeta("Urano","http://s03.s3c.es/imag/_v0/580x400/0/7/3/urano-getty.jpg", "2,877 * 10^9 km"));
		
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
		
			
		
	}

}
