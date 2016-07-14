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
		ArrayList<Planeta> lista = new ArrayList<Planeta>();
		lista.add(new Planeta("http://recursostic.educacion.es/ciencias/biosfera/web/alumno/1ESO/planeta_habitado/imagenes/planetatierra.jpg","Tierra","0 años luz"));
		lista.add(new Planeta("http://cdn.20m.es/img2/recortes/2011/05/26/21134-485-400.jpg?v=20120323010608","Marte","0,5 años luz"));
		lista.add(new Planeta("https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/Mercury_in_color_-_Prockter07_centered.jpg/280px-Mercury_in_color_-_Prockter07_centered.jpg","Mercurio","0,6 años luz"));
		lista.add(new Planeta("http://static.elobservador.com.uy/adjuntos/184/imagenes/000/303/0000303514.jpg","Venus","0,3 años luz"));
		request.setAttribute("ListaPlanetas", lista);
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
	}

}
