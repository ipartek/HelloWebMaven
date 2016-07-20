package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Constantes;
import com.ipartek.formacion.Utilidades;
import com.ipartek.formacion.pojo.Planeta;
import com.ipartek.formacion.pojo.Puntuacion;

/**
 * Servlet implementation class PlanetasServlet
 */
public class PlanetasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String IMG_MERCURIO = "img/mercurio.png";
	public static final String DIST_MERCURIO = "91.690.000";
	public static final String NOM_MERCURIO = "mercurio";
	public static final String IMG_VENUS = "img/venus.png";
	public static final String DIST_VENUS = "42.000.000";
	public static final String NOM_VENUS = "venus";
	public static final String IMG_TIERRA = "img/tierra.png";
	public static final String DIST_TIERRA = "0";
	public static final String NOM_TIERRA = "tierra";
	public static final String IMG_MARTE = "img/marte.png";
	public static final String DIST_MARTE = "69.000.000";
	public static final String NOM_MARTE = "marte";
	public static final String IMG_JUPITER = "img/jupiter.png";
	public static final String DIST_JUPITER = "591.000.000";
	public static final String NOM_JUPITER = "jupiter";
	public static final String IMG_SATURNO = "img/saturno.png";
	public static final String DIST_SATURNO = "1.200.000.000";
	public static final String NOM_SATURNO = "saturno";
	public static final String IMG_URANO = "img/urano.png";
	public static final String DIST_URANO = "2.543.164.000";
	public static final String NOM_URANO = "urano";
	public static final String IMG_NEPTUNO = "img/neptuno.png";
	public static final String DIST_NEPTUNO = "4.500.000.000";
	public static final String NOM_NEPTUNO = "neptuno";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s = "hola";
		ArrayList<Planeta> aPuntuaciones = new ArrayList<Planeta>();
		aPuntuaciones.add(new Planeta(IMG_MERCURIO, Utilidades.capitalizar(NOM_MERCURIO), DIST_MERCURIO));
		aPuntuaciones.add(new Planeta(IMG_VENUS, Utilidades.capitalizar(NOM_VENUS), DIST_VENUS));
		aPuntuaciones.add(new Planeta(IMG_TIERRA, Utilidades.capitalizar(NOM_TIERRA), DIST_TIERRA));
		aPuntuaciones.add(new Planeta(IMG_MARTE, Utilidades.capitalizar(NOM_MARTE), DIST_MARTE));
		aPuntuaciones.add(new Planeta(IMG_JUPITER, Utilidades.capitalizar(NOM_JUPITER), DIST_JUPITER));
		aPuntuaciones.add(new Planeta(IMG_SATURNO, Utilidades.capitalizar(NOM_SATURNO), DIST_SATURNO));
		aPuntuaciones.add(new Planeta(IMG_URANO, Utilidades.capitalizar(NOM_URANO), DIST_URANO));
		aPuntuaciones.add(new Planeta(IMG_NEPTUNO, Utilidades.capitalizar(NOM_NEPTUNO), DIST_NEPTUNO));
		
		
		request.setAttribute("planetas", aPuntuaciones);
		
		request.getRequestDispatcher("ejercicios/planetas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
