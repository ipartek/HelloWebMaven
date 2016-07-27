package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.pojo.Planeta;
import com.ipartek.formacion.service.ServicePersona;
import com.ipartek.formacion.service.ServicePersonaImplDB;
import com.ipartek.formacion.service.ServicePlanet;
import com.ipartek.formacion.service.ServicePlanetImplDB;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dispatch;
	
	private ServicePersona servicioPersona = ServicePersonaImplDB.getInstance();
	
	//con esto podría tener un LOG con las info que yo le pida
	private final static Logger LOG = Logger.getLogger(PersonaServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		case Constantes.OP_LIST:
			LOG.debug("Ha seleccionado listar");			
			listar(request,response);
			break;
		case Constantes.OP_NEW:
			LOG.debug("Ha seleccionado crear nuevo");	
			nuevo(request,response);
			break;
		case Constantes.OP_DETAIL:
			LOG.debug("Ha seleccionado ver detalle");	
			detalle(request,response);
			break;
		case Constantes.OP_DELETE:
			LOG.debug("Ha seleccionado eliminar");	
			borrar(request,response);
			break;
		default:
			LOG.debug("Se está listando por defecto");	
			listar(request,response);
			break;
		}
		
		dispatch.forward(request, response);
	}

	private void borrar(HttpServletRequest request, HttpServletResponse response) {
		
		String mensaje = "Persona No Eliminada";
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (servicioPersona.delete(id)){
			mensaje = "Persona " + id + " eliminada correctamente";
		}	
		
		request.setAttribute("mensaje", mensaje);
		listar(request,response);
		
	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		int pId = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("persona", servicioPersona.getById(pId));
		
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);
		
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("persona", new Persona());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("list", servicioPersona.getAll());
		
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_LIST);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op = Integer.parseInt(request.getParameter("op"));
		
		switch (op) {
		
		case Constantes.OP_SAVE:
			LOG.debug("Ha seleccionado guardar");	
			guardar(request,response);
			break;		
		
		default:
			listar(request,response);
			break;
		}
		
		dispatch.forward(request, response);
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {
		String mensaje = "Persona guardada";
		
		//recoger parámetros formulario
		long id = Long.parseLong(request.getParameter("id"));
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		
		//crear Persona
		Persona p = new Persona();
		p.setId(id);
		p.setNombre(nombre);
		p.setEmail(email);
		
		
		try {
			request.setAttribute("persona", (Persona)servicioPersona.save(p));
		} catch (Exception e) {
			mensaje = "No se ha podido guardar";
			e.printStackTrace();
			LOG.error("No se ha podido guardar persona" + e.getStackTrace());
		}		
		
		request.setAttribute("persona", p);
		request.setAttribute("mensaje", mensaje);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);
		
	}

}
