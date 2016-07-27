package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.pojo.Planeta;
import com.ipartek.formacion.service.ServicePersona;
import com.ipartek.formacion.service.ServicePersonaImplDB;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	private ServicePersona serviceP = ServicePersonaImplDB.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL );
		
	}

	

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {		
		request.setAttribute("detail", new Planeta() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL);		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", serviceP.getAll() );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_LIST);
		
		
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
		ArrayList<Persona> personasBusqueda = (ArrayList<Persona>) serviceP.search(busqueda);
		request.setAttribute("list", personasBusqueda );
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_LIST);
		
		String msg = "Busqueda [" + busqueda+ "] 0 coincidencias";
		if ( !personasBusqueda.isEmpty() ){
			msg = "Busqueda [" + busqueda+ "] "+personasBusqueda.size()+" coincidencias";
		}
		request.setAttribute("msg", msg);
		
		
	}
	
	
	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		
		//recoger parametros formulario
		long id       = Long.parseLong(request.getParameter("id"));
		String imagen = request.getParameter("imagen");
		String nombre = request.getParameter("nombre");
		
		//crear Planeta
		Persona p = new Persona("",0,"");
		p.setId((int) id);
		p.setEmail(imagen);
		p.setNombre(nombre);
		
		String msg = null;
		try {
			serviceP.save(p);			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error al salvar persona " + p.toString() ;
		}
		request.setAttribute("msg", msg );
		request.setAttribute("detail", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL );
	}
	
}
