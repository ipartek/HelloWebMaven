package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.pojo.Planeta;
import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PlanetasServlet
 */
public class PlanetasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String IMG_MERCURIO = "/img/mercurio.png";
	public static final String DIST_MERCURIO = "91.690.000";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = "hola";
		ArrayList<Planeta> aPuntuaciones = new ArrayList<Planeta>();
		aPuntuaciones.add(new Planeta(IMG_MERCURIO, "Mercurio", "91.690.000"));
		
		
		request.setAttribute("planetas", aPuntuaciones);
		
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
