package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Candidato;
import com.ipartek.formacion.pojo.exception.CandidatoException;

/**
 * Servlet implementation class CandidatoServlet
 */
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recoger parametro
		String parametroId = request.getParameter("id");
		//TODO buscar en BBDD el candidato
		
		//crear candidato
		Candidato c = null;
		try {
			c = new Candidato("Ernesto"+parametroId, "Pecho", "Presto", "5494964g", "pechopresto@gmail.com", 5);
		} catch (CandidatoException e) {
			//TODO enviar a pagina de error
			e.printStackTrace();
		}
		request.setAttribute("candidato", c);
		
		//guardar atributo<Candidato> en request
		
		//ir a candidato/detail.jsp
		 request.getRequestDispatcher("candidato/detalle.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
