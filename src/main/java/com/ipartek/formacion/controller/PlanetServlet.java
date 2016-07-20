package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.pojo.Planeta;

	/**
	 * Servlet implementation class PlanetServlet
	 */
public class PlanetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	//TODO Cargar de BBDD
	private ArrayList<Planeta> planetas = null;
	
	/**
	 * ESTE INIT SE EJECUTA SOLO LA PRIMERA VEZ QUE ALGUIEN LLAMA AL SERVLET
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		planetas = new ArrayList<Planeta>();
		Planeta p = null;
		for(int i=0;i<50;i++){
			planetas.add(new Planeta("planeta"+1));
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case Constantes.OP_LIST:
			listar(request,response);
			break;
		case Constantes.OP_NEW:
			nuevo(request,response);
			break;
		case Constantes.OP_DETAIL:
			detalle(request,response);
			break;
		case Constantes.OP_SEARCH:
			buscar(request,response);
			break;	

		default:
			listar(request,response);
			break;
		}
		
		dispatch.forward(request, response);
	}
	
	

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
