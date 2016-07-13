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
 * Servlet implementation class PuntuacionesServlet
 */
public class PuntuacionesServlet extends HttpServlet {
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
		
		
		private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		
		ArrayList<Puntuacion> lista = new ArrayList<Puntuacion>();
		for (int i = 0; i < 10; i++) {
			lista.add(new Puntuacion(i, "usuario"+ i, "oca"+ i, Math.round(Math.random() * 10) ));
		}	
		
		request.setAttribute("tblPuntuaciones",lista);
		
		request.getRequestDispatcher("ejercicios/puntuaciones.jsp").forward(request, response);
	}

}
