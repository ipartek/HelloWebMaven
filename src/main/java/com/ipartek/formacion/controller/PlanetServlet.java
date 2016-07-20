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
	
	//TODO cargar de BaseDatos
	private ArrayList<Planeta> planetas = null;
	
	/**
	 * Se ejecurta solo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);		
		planetas = new ArrayList<Planeta>();		
		for (int i=0; i < 50; i++ ){		
			planetas.add( new Planeta("planet"+i, i ) );
		}
	}
	
	/**
	 * Este metodo se ejecuta al Destruirse el Servlet, 
	 * por ejemplo cuando paramos el Servidor
	 */
	@Override
	public void destroy() {		
		super.destroy();
		planetas = null;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Antes de doGet o doPost");
		super.service(request, response);
		System.out.println("Despues de doGet o doPost");
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case Constantes.OP_LIST:
			listar(request, response);
			break;
		case Constantes.OP_NEW:
			nuevo(request, response);
			break;	
		case Constantes.OP_DETAIL:
			detalle(request, response);
			break;			
		case Constantes.OP_SEARCH:
			buscar(request, response);
			break;			
		default:
			listar(request, response);
			break;
		}
		
		
		dispatch.forward(request, response);
		
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Planeta p = planetas.get(id);
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", planetas);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
