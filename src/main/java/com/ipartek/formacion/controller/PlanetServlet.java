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

/**
 * Servlet implementation class PlanetServlet
 */
public class PlanetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;

	// TODO cargar de BaseDatos
	private ArrayList<Planeta> planetas = null;
	private ServicePlanet servicioPlaneta = ServicePlanetImpArrayList.getInstance();

	/**
	 * Se ejecuta solo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}

	/**
	 * Este metodo se ejecuta al destruirse el Servlet, por ejemplo cuando
	 * paramos el Servidor
	 */
	@Override
	public void destroy() {
		super.destroy();
		planetas = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de doGet o doPost");
		super.service(request, response);
		System.out.println("Despues de doGet o doPost");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("detail", new Planeta());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", servicioPlaneta.getAll());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		String mensaje = "Planeta no eliminado";
		long id = Long.parseLong(request.getParameter("id"));

		if (servicioPlaneta.delete(id)==true){
			mensaje = "El planeta[" + id + "] ha sido eliminado correctamente";
		}

		request.setAttribute("msg", mensaje);
		listar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
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
		
		request.setAttribute("list", planetasBusqueda);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
		String msg = "Busqueda ["+busqueda+"] 0 coincidencias";
		if (!planetasBusqueda.isEmpty()){
			msg = "Busqueda ["+busqueda+"] "+planetasBusqueda.size()+" coincidencias";
		}
		request.setAttribute("msg", msg);
		
	}
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		//Recoger parametros formulario
		long id = Long.parseLong(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");
		
		//Crear una variable mensaje que informe si el alta ha funcionado o ha fallado
		String mensaje = "El planeta "+nombre+" ha sido guardado correctamente";
		
		//Crear Planeta
		Planeta p = new Planeta();
		p.setId(id);
		p.setNombre(nombre);
		p.setImg(imagen);
		
		//Guardar o modificar Planeta en ArrayList
		try {
			servicioPlaneta.save(p);
		} catch (Exception e) {
			e.printStackTrace();
			mensaje="Error al guardar el planeta";
		}
		
		request.setAttribute("detail", p);
		request.setAttribute("msg", mensaje);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
	}
	
}
