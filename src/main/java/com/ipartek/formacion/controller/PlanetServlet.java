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
 * Servlet implementation class PlanetasServlet
 */
public class PlanetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	
	//TODO cargar de BaseDatos
	private ArrayList<Planeta> planetas = null;
	
   /**
    * Se ejecuta solo la primera vez que alguien llama al servlet
    */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		planetas = new ArrayList<Planeta>();
		Planeta p = null;
		for (int i=0; i<50; i++){
			/*p= new Planeta();
			  p.setNombre("planeta" + i);
			  planetas.add(p);
			  
			  todo lo anterior se puede hacer con la siguiente linea*/
			planetas.add(new Planeta("planet"+i, i) );
		}
				
	}
	
	/*
	 * Este metodo se ejecuta al Destruirse el Servlet,
	 * por ejemplo cuando se para el servidor
	 */
	@Override
	public void destroy() {
		super.destroy();
		planetas=null;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Antes de doGet y doPost");
		super.service(request, response);
		System.out.println("Despues de doGet y doPost");
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros
		int op = Integer.parseInt(request.getParameter("op") );
		
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

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));  //recoger el id
		String msg ="Planeta no eliminado";
		for (int i=0; i<planetas.size(); i++){
				
			if (id == planetas.get(i).getId() ) {
				
				planetas.remove(id);
				msg="Planeta["+id+"] Eliminado corrrectamente";
				break;
				
			}
		}
		
		
		
		request.setAttribute("msg", msg);
		listar(request, response); //esta linea es lo mismo que escribir
		//dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST );
		
	}

	
	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Planeta p = null;
		for (int i=0; i<planetas.size(); i++){
			
			if (id == planetas.get(i).getId() ) {
				p= planetas.get(i);
				break;
			}
		}
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
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
	
		//recoger parametros
				int op = Integer.parseInt(request.getParameter("op") );
				
				switch (op) {
				case Constantes.OP_SEARCH:
					buscar(request, response);
					break;
				
				}
				
				dispatch.forward(request, response);
		
	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		
		String busqueda= request.getParameter("s");
		ArrayList<Planeta> planetasBusqueda = new ArrayList<Planeta>();
		for (int i=0; i< planetas.size(); i++){
			if ( planetas.get(i).getNombre().contains(busqueda) ){
				planetasBusqueda.add(planetas.get(i));
			}
		}
		request.setAttribute("list", planetasBusqueda);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
		String msg = "Busqueda [" + busqueda + "] con 0 coincidencias";
		if (!planetasBusqueda.isEmpty()){
			msg = "Busqueda [" + busqueda + "] " + planetasBusqueda.size()+" coincidencias";
		}
		
		request.setAttribute("msg", msg);
		
		
	}


}
