package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PuntuacionesServlet
 */
public class PuntuacionesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//Crear ArrayList con 10 puntuaciones
		ArrayList<Puntuacion> listaPuntuaciones = new ArrayList<Puntuacion>();
		for (int i = 0; i < 10; i++) {
			listaPuntuaciones.add( new Puntuacion(i, "usuario"+i, "juego"+i, i) );
		}
		
		//guardar lista como atributo
		request.setAttribute("puntuaciones", listaPuntuaciones);
		//request.setAttribute("mejorJugador", new Persona("","");
		
		//forward a puntuaciones.jsp
		request.getRequestDispatcher("ejercicios/puntuaciones.jsp").forward(request, response);
		
	}

}
