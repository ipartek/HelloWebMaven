package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PuntuacionServlet
 */
public class PuntuacionServlet extends HttpServlet {
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
	
		//Crear ArraList con 10 puntuaciones
		ArrayList<Puntuacion> listaPuntuaciones = new ArrayList<Puntuacion>();
		for (int i=0; i<10; i++){
			listaPuntuaciones.add(new Puntuacion(i, "usuario" + i, "juego" + i, i));
		}
		
		//guardar la tabla de Puntuaciones como atributo en request
		request.setAttribute("puntuaciones", listaPuntuaciones);
		
		//forward  para ir a candidato/detalle.jsp
		request.getRequestDispatcher("ejercicios/puntuaciones.jsp").forward(request, response);
		
		
		
	}

}
