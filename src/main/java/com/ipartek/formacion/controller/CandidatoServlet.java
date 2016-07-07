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
		
		//recoger parámetro
		String parametroId = request.getParameter("id");
		String parametroApe = request.getParameter("ape");
		
		//TDOO buscar en BBDD el candidato
		
		//crear Candidato
		Candidato c = null;
		try{
			c = new Candidato("Candido" + parametroId, parametroApe, "apellido2", "dni", "email", 5);
		} catch(CandidatoException e){
			//TODO enviar a página de error
			e.printStackTrace();
		}
		
		//guardar atributo<Candidato> en request
		request.setAttribute("candidato", c);
		
		//ir a candidato/detalle.jsp
		request.getRequestDispatcher("candidato/detalle.jsp").forward(request, response);
				//(fordward dirige a ese jsp)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
