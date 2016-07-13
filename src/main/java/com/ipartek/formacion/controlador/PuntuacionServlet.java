package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PuntuacionServlet
 */
public class PuntuacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		//crear ArrayList con 10 puntuaciones
		ArrayList<Puntuacion> aPuntuaciones = new ArrayList<Puntuacion>();
		for ( int i=0; i<10; i++ ){
			aPuntuaciones.add(new Puntuacion(i, "NombreUsuario"+i, "Juego"+i, i));
		}
		
		//guardar lista como atributo
		request.setAttribute("puntuaciones", aPuntuaciones);
		RequestDispatcher dispacher = this.getServletContext().getRequestDispatcher("/ejercicios/puntuaciones.jsp");
		//se puede hacer request.getRequestDispatcher("/ejercicios/puntuaciones.jsp").forward(request,response);
		//realizar el forward
		try {
			dispacher.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
