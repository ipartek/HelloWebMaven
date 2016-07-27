package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.controller.listener.InitListener;
import com.ipartek.formacion.pojo.Persona;
import com.ipartek.formacion.service.ServicePersona;
import com.ipartek.formacion.service.ServicePersonaImplDB;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(PersonaServlet.class);

	private RequestDispatcher dispatch;

	// cargar de BaseDatos
	private ArrayList<Persona> personas = null;

	private ServicePersona servicioPersona = ServicePersonaImplDB.getInstance();

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
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
		request.setAttribute("msg", servicioPersona.delete(id));
		listar(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) {
		String busqueda = request.getParameter("s");
		ArrayList<Persona> personasBusqueda = (ArrayList<Persona>) servicioPersona.search(busqueda);
		request.setAttribute("list", personasBusqueda);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_LIST);

	}

	private void detalle(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("detail", servicioPersona.getById(id));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);

	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("detail", new Persona());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", servicioPersona.getAll());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_LIST);

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

	private void guardar(HttpServletRequest request, HttpServletResponse response) {

		// recoger parametros formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");

		// crear Planeta
		Persona person = new Persona();
		person.setId(id);
		;
		person.setNombre(nombre);
		person.setEmail(email);

		try {
			request.setAttribute("detail", servicioPersona.save(person));
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("no se ha podido crear persona");
		}
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONA_DETAIL);
	}

}
