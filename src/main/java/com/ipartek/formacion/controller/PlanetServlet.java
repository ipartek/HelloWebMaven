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
import com.ipartek.formacion.service.ServicePlanetImplDB;

/**
 * Servlet implementation class PlanetServlet
 */
public class PlanetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	private ServicePlanet serviceP = ServicePlanetImplDB.getInstance();
	
	
	/**
	 * Se ejecuta solo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {		
		super.init(config);	
		
	}
	
	
	/**
	 * Este metodo se ejecuta al Destruirse el servlet,
	 * por ejemplo cuando paramos el Servidor 
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ANTES de doGet o doPost");
		super.service(request, response);
		System.out.println("DESPUES de doGet o doPost");
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

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombrePlaneta = serviceP.getById(id).getNombre();
		String msg = "Planeta NO eliminado";
		
		if (serviceP.delete(id)){
			msg = "Planeta &quot;" + nombrePlaneta + "&quot; eliminado correctamente";
		}
		
		request.setAttribute("msg",  msg);
		listar(request, response);
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("detail", serviceP.getById(id));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANETA_DETAIL);		
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("detail", new Planeta() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANETA_DETAIL);	
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", serviceP.getAll());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANETA_LIST);
		
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


	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		//Recoger parametros formulario
		long id = Long.parseLong(request.getParameter("id"));
		String img = request.getParameter("img");
		String nombre = request.getParameter("nombre");
		//String distancia = request.getParameter("distancia");
		
		//Crear planeta		
		Planeta p = new Planeta();
		p.setId(id);
		p.setNombre(nombre);
		p.setImg(img);
		//p.setDistancia(distancia);	
		
		String msg = null;
		
		try {
			serviceP.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			msg="Error al guardar planeta " + p.toString();
		}
		
		msg = "Los datos de "+nombre+" se han guardado correctamente.";
		request.setAttribute("msg", msg);
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANETA_DETAIL);
		
		
	}


	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		String busqueda = request.getParameter("s");
		
		ArrayList<Planeta> planetasBusqueda = (ArrayList<Planeta>) serviceP.search(busqueda);
		request.setAttribute("list", planetasBusqueda );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANETA_LIST);
		
		String msg = "La b&uacute;squeda &quot;" + busqueda + "&quot; devolvi&oacute; 0 resultados";
		if ( !planetasBusqueda.isEmpty() ){
			msg = "La b&uacute;squeda &quot;" + busqueda + "&quot; devolvi&oacute; "+serviceP.search(busqueda).size()+" resultado(s)";
		}
		
		request.setAttribute("msg", msg);
		
	}

}
