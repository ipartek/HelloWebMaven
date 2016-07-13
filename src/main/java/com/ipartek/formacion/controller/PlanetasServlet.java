package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Planeta;

/**
 * Servlet implementation class PlanetasServlet
 */
public class PlanetasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//crear los planetas
		Planeta jupiter = new Planeta("http://canal44.com/wp-content/uploads/2016/07/Jupiter.jpg", "Jupiter", 4.2f);
		Planeta marte = new Planeta("https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Schiaparelli_Hemisphere_Enhanced.jpg/280px-Schiaparelli_Hemisphere_Enhanced.jpg", "Marte", 0.5f);
		Planeta saturno = new Planeta("http://casanchi.com/ast/anillos00.jpg", "saturno", 8.5f);
	 
		//crear ArrayList con planetas
		ArrayList<Planeta> listaPlanetas =  ArrayList<Planeta>();
		listaPlanetas.add(jupiter);
		listaPlanetas.add(marte);
		listaPlanetas.add(saturno);
		
		//guardar la tabla de Puntuaciones como atributo en request
		request.setAttribute("planetas", listaPlanetas);
		
		//forward  para ir a planetas.jsp
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
