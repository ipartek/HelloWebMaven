package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Planeta;
import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PlanetaServlet
 */
public class PlanetaServlet extends HttpServlet {
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
		
		ArrayList<Planeta> listaPlanetas = new ArrayList<Planeta>();
		
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/1/1e/Kepler22b-artwork.jpg", "Kepler22b", "620"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/2/2a/Nh-pluto-in-true-color_2x_JPEG-edit-frame.jpg", "Pluto", "320"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/1/1e/Kepler22b-artwork.jpg", "c", "620"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/1/1e/Kepler22b-artwork.jpg", "d", "620"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/1/1e/Kepler22b-artwork.jpg", "ee", "620"));
			
		
		
		request.setAttribute("Planetas", listaPlanetas);
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
	}

}
