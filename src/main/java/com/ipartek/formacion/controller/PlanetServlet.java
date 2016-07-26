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
import com.ipartek.formacion.service.ServicePlanet;
import com.ipartek.formacion.service.ServicePlanetImpArrayList;
import com.ipartek.formacion.service.ServicePlanetImplDB;

/**
 * Servlet implementation class PlanetServlet
 */
public class PlanetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	//TODO cargar de BaseDatos
	private ArrayList<Planeta> planetas = null;
	
	private ServicePlanet servicioPlaneta= ServicePlanetImplDB.getInstance();
	
	/**
	 * Se ejecuta solo la primera vez que alguien llama al servlet
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
		case Constantes.OP_DELETE:
			eliminar(request, response);
			break;			
		default:
			listar(request, response);
			break;
		}
		
		
		dispatch.forward(request, response);
		
		
	}



	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
			
		request.setAttribute("detail", servicioPlaneta.getById(id));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
	}

	

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("detail", new Planeta());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", servicioPlaneta.getAll());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
		
	}
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("msg", servicioPlaneta.delete(id));		
		listar(request,response);				
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

	
	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		
		String busqueda = request.getParameter("s");		
 		ArrayList<Planeta> planetasBusqueda = (ArrayList<Planeta>) servicioPlaneta.search(busqueda);
 		request.setAttribute("list", planetasBusqueda );
 		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
	}
	
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		//recoger parametros formulario
		long id       = Long.parseLong(request.getParameter("id"));
		String imagen = request.getParameter("imagen");
		String nombre = request.getParameter("nombre");
		
		//crear Planeta
		Planeta p = new Planeta();
		p.setId(id);
		p.setImagen(imagen);
		p.setNombre(nombre);
		
		
		try {
			request.setAttribute("detail", servicioPlaneta.save(p));
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("no se ha podido crear planeta");
		}
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
	}
	
}