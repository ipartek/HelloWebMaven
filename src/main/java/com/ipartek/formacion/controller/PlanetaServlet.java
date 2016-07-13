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
		
		listaPlanetas.add(new Planeta("http://1.bp.blogspot.com/-FYA_RI8Jz38/U53z0KW0HOI/AAAAAAAAAEY/v3t1soQjhAM/s1600/1.jpg", "Kepler-22 b", "620"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/1/19/Planet_around_HR_8799.jpg", "HR 8799 b", "129"));
		listaPlanetas.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/a/a2/ESO_OGLE-2005-BLG-390Lb.jpg", "OGLE-05-390L b", "6500"));
		listaPlanetas.add(new Planeta("http://astronaut.com/wp-content/uploads/2015/08/Screen-Shot-2015-08-01-at-9.29.50-AM.png", "Gliese 581 c", "6,21"));
		listaPlanetas.add(new Planeta("https://s-media-cache-ak0.pinimg.com/564x/9e/03/6d/9e036dce0c76967940954b7a4a045930.jpg", "1SWASP J1407 b", "420"));
			
		
		
		request.setAttribute("Planetas", listaPlanetas);
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
	}

}
