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
		
	private ServicePlanet serviceP = ServicePlanetImplDB.getInstance();
	
	/**
	 * Se ejecurta solo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);		
	}
	
	/**
	 * Este metodo se ejecuta al Destruirse el Servlet, 
	 * por ejemplo cuando paramos el Servidor
	 */
	@Override
	public void destroy() {		
		super.destroy();		
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
		request.setAttribute("detail", serviceP.getById(id));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
	}

	

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {		
		request.setAttribute("detail", new Planeta() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", serviceP.getAll() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
	}
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		String msg = "Planeta No Elimnado";		
		int id = Integer.parseInt(request.getParameter("id"));		
		if ( serviceP.delete(id)){
			msg = "Planeta["+id+"] Elimado Correctamente";	
		}		
		request.setAttribute("msg", msg);		
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
		
		ArrayList<Planeta> planetasBusqueda = (ArrayList<Planeta>) serviceP.search(busqueda);
		request.setAttribute("list", planetasBusqueda );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
		String msg = "Busqueda [" + busqueda+ "] 0 coincidencias";
		if ( !planetasBusqueda.isEmpty() ){
			msg = "Busqueda [" + busqueda+ "] "+planetasBusqueda.size()+" coincidencias";
		}
		request.setAttribute("msg", msg);
		
		
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
		
		String msg = null;
		try {
			serviceP.save(p);			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error al salvar planeta " + p.toString() ;
		}
		request.setAttribute("msg", msg );
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
	}
	
}