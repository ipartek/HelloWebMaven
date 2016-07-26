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
	
	//TODO Cargar de BBDD
	private ArrayList<Planeta> planetas = null;
	private ServicePlanet servicioPlaneta = ServicePlanetImplDB.getInstance();
	
	/**
	 * ESTE INIT SE EJECUTA SOLO LA PRIMERA VEZ QUE ALGUIEN LLAMA AL SERVLET
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
	}
	
	/**
	 * ESTE METODO SE EJECUTA AL DESTRUIRSE EL SERVLET ES PARA LIBERAR MEMORIA, POR EJEMPLO CUANDO PARAMOS EL SERVIDOR
	 */
	@Override
		public void destroy() {
			super.destroy();
			planetas = null;
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
			eliminar(request,response);
			break;
		default:
			listar(request,response);
			break;
		}
		
		dispatch.forward(request, response);
	}
	
	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String msg  = "Planeta no borrado";
		if(servicioPlaneta.delete(id)== true){
			msg = "Planeta deleteado";
		}
		request.setAttribute("msg", msg);
		listar(request, response);
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
			try {
				guardar(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		dispatch.forward(request, response);
		
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// RECOGER PARAMETROS DEL FORMULARIO
		int id = Integer.parseInt(request.getParameter("id"));
		String imagen = request.getParameter("imagen");
		String nombre = request.getParameter("nombre");
		
		Planeta p = new Planeta();
		p.setId(id);
		p.setImg(imagen);
		p.setNombre(nombre);
		
		// GUARDAR O MODIFICAR PLANETA EN ARRAYLIST
		
		request.setAttribute("detail", servicioPlaneta.save(p));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		String busqueda = request.getParameter("search");
		ArrayList<Planeta> planetBusqueda = (ArrayList<Planeta>) servicioPlaneta.search(busqueda);
		request.setAttribute("list", planetBusqueda );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		String msg = "Busqueda sin exito";
		if(!planetBusqueda.isEmpty()){
			msg= "Planeta encontrado"+busqueda;
		}
		request.setAttribute("msg", msg);
		
	}

}
