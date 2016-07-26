package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
	
	
	//private ArrayList<Planeta> planetas = null;
	//private ServicePlanetImpArrayList servicioPlaneta = ServicePlanetImpArrayList.getInstance();

	private ServicePlanet servicioPlaneta = ServicePlanetImplDB.getInstance();
	
	/**
	 * Se ejecuta sólo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		
	}
	
	/**
	 * Este método de ejecuta al Destruirse el Servlet, por ejemplo, cuando paramos el Servidor
	 */
	
	@Override
	public void destroy() {
		
		super.destroy();
	//	planetas = null;
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		super.service(request, response);
		
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
		case Constantes.OP_DELETE:
			borrar(request,response);
			break;
		default:
			listar(request,response);
			break;
		}
		
		dispatch.forward(request, response);
	}



	private void borrar(HttpServletRequest request, HttpServletResponse response) {
		
		String mensaje = "Planeta No Eliminado";
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (servicioPlaneta.delete(id)){
			mensaje = "Planeta " + id + " eliminado correctamente";
		}	
		
		request.setAttribute("mensaje", mensaje);
		listar(request,response);
		
	}

	


	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		
		int pId = Integer.parseInt(request.getParameter("id"));
	
		request.setAttribute("planeta", servicioPlaneta.getById(pId));
		
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
		
	}



	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("planeta", new Planeta());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
	}



	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", servicioPlaneta.getAll());
		
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int op = Integer.parseInt(request.getParameter("op"));
				
				switch (op) {
				
		
				case Constantes.OP_SEARCH:
					buscar(request,response);
					break;
				case Constantes.OP_SAVE:
					guardar(request,response);
					break;
				/*case Constantes.OP_UPDATE:
					modificar(request,response);
					break;*/
				
				default:
					listar(request,response);
					break;
				}
				
				dispatch.forward(request, response);
			
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		String mensaje = "Planeta guardado";
		
		//recoger parámetros formulario
		long id = Long.parseLong(request.getParameter("id"));
		String imagen = request.getParameter("imagen");
		String nombre = request.getParameter("nombre");
		
		//crear Planeta
		Planeta p = new Planeta();
		p.setId(id);
		p.setImagen(imagen);
		p.setNombre(nombre);
		
		
		try {
			request.setAttribute("planeta", (Planeta)servicioPlaneta.save(p));
		} catch (Exception e) {
			mensaje = "No se ha podido guardar";
			e.printStackTrace();
		}		
		
		request.setAttribute("planeta", p);
		request.setAttribute("mensaje", mensaje);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
		
	}

	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		
			String busqueda = request.getParameter("s");
		
			ArrayList<Planeta> planetasBusqueda = (ArrayList<Planeta>)servicioPlaneta.search(busqueda);
			
			request.setAttribute("list", planetasBusqueda);
			String mensaje = "Busqueda [" + busqueda + "] 0 coincidencias";
			if (!planetasBusqueda.isEmpty()){
				mensaje = "Busqueda [" + busqueda + "] " + planetasBusqueda.size() ;
			}
			
			request.setAttribute("mensaje", mensaje);
			
			dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
			
			
	}

	
}
