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
 * Servlet implementation class PlanetasServlet
 */
public class PlanetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	
	
	//TODO cargar de BaseDatos
	private ArrayList<Planeta> planetas = null;
	private ServicePlanetImpArrayList servicioPlaneta;
	
	
   /**
    * Se ejecuta solo la primera vez que alguien llama al servlet
    */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
				
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

	
	
	private void detalle(HttpServletRequest request, HttpServletResponse response) {
			
			int id = Integer.parseInt(request.getParameter("id"));			
			request.setAttribute("detail", servicioPlaneta.getInstance().getById(id));
			dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
			
		}


	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("detail", new Planeta() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL);		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", servicioPlaneta.getInstance().getAll() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_LIST);
		
	}
	
	
	
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("msg", servicioPlaneta.getInstance().delete(id) );		
		listar(request,response);				
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
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		//recoger parametros del formulario
		
		long id		  = Long.parseLong(request.getParameter("id") );
		String imagen = request.getParameter("imagen");
		String nombre = request.getParameter("nombre");
		
		//Crear Planeta
		Planeta p = new Planeta();     //creamos un planeta vacio
		p.setId(id);					//le añadimos los datos que recogimos en el paso anterior
		p.setImagen(imagen);
		p.setNombre(nombre);
		
		//guardar o modificar planeta en ArraList
		if ( p.isNew()){   //si el planeta es nuevo
			
			if ( planetas.isEmpty()){    //si está vacio el array
				p.setId(1);				 // le asigno el id=1
			}else{						 //si no está vacio
				p.setId( (planetas.get(planetas.size()-1).getId()+1) );
			}
			planetas.add(p);
			
		}else{
			
		
			for (int i=0; i < planetas.size(); i++){
				
				if (id == planetas.get(i).getId() ) {
					planetas.set(i, p);
					break;
				}
			}
		}
		
		
		
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PLANET_DETAIL );
		
		
	}



}
