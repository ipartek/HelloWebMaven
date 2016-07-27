package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.service.ServicePlanet;
import com.ipartek.formacion.service.ServicePlanetImplDB;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	private ServicePlanet serviceP = ServicePlanetImplDB.getInstance();
       

	/**
	 * Se ejecuta solo la primera vez que alguien llama al servlet
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);	
	}

	/**
	 * Este metodo se ejecuta al Destruirse el Servlet, 
	 * por ejemplo cuando paramos el Servidor
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
		case Constantes.OP_DELETE:
			eliminar(request, response);
			break;			
		default:
			listar(request, response);
			break;
		}
		
		dispatch.forward(request, response);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", serviceP.getAll() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_LIST);
		
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	

	

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case Constantes.OP_SEARCH:
			buscar(request, response);
			break;
		case Constantes.OP_SAVE:
			guardar(request, response);
			break;	
		default:
			listar(request, response);
			break;
		}
		
		
		dispatch.forward(request, response);
		
	}

}
