package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Puntuacion> listaUser = new ArrayList<Puntuacion>();
		
		for (int i = 0; i < 10; i++) {
			listaUser.add(new Puntuacion(i, "usuario" + i, "pokemon", Math.round(Math.random()*10)));
		}
		
		//enviar el atributo resultado del cálculo
		request.setAttribute("tablaPuntuaciones", listaUser);
		
		//ir a calculadora/calculadora.jsp		
		request.getRequestDispatcher("ejercicios/puntuaciones.jsp").forward(request, response);
			
		
	}

}
