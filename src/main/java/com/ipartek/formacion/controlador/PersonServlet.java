package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.pojo.Person;
import com.ipartek.formacion.service.ServicePerson;
import com.ipartek.formacion.service.ServicePersonImplDB;

/**
 * Servlet implementation class PersonaServlet
 */
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;
	private ServicePerson serviceP = ServicePersonImplDB.getInstance();
       
	/**
	 * Se ejecuta solo la primera vez que alguien llama al servlet
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}

	/**
	 * Este metodo se ejecuta al Destruirse el Servlet, por ejemplo cuando
	 * paramos el Servidor
	 */
	@Override
	public void destroy() {

		super.destroy();
		
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

		long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("detail", serviceP.getById(id));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL);

	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("detail", new Person());
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL);

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("list", serviceP.getAll());

		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_LIST);

	}

	

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String msg = "Persona con id: " + id + " no ha sido eliminado";
		if (serviceP.delete(id)) {
			msg = "Persona con id: " + id + " ha sido eliminado";
			request.setAttribute("msgBueno", msg);
		} else {
			request.setAttribute("msgMalo", msg);
		}

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

		ArrayList<Person> planetasBusqueda = (ArrayList<Person>) serviceP.search(busqueda);
		request.setAttribute("list", planetasBusqueda);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_LIST);

		String msg = "Busqueda [" + busqueda + "] 0 coincidencias";
		if (!planetasBusqueda.isEmpty()) {

			msg = "Busqueda [" + busqueda + "] " + planetasBusqueda.size() + " coincidencias";
		}
		request.setAttribute("msgBueno", msg);

	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) {

		// recoger parametros formulario
		long id = Long.parseLong(request.getParameter("id"));
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");

		// crear Planeta
		Person p = new Person();
		p.setId(id);
		p.setEmail(email);
		p.setNombre(nombre);

		// guardar o modificar planeta en ArrayList
		String msg = "No se ha podido guardar la Persona";

		try {
			request.setAttribute("detail", serviceP.save(p));
			msg = "La Persona se ha guardado";
			request.setAttribute("msgBueno", msg);
		} catch (Exception e) {

			request.setAttribute("msgMalo", msg);
		}

		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERSONAS_DETAIL);

	}

}
