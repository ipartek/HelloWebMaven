package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;

	public static final int SUMA = 0;
	public static final int RESTA = 1;
	public static final int MULTIPLICA = 2;
	public static final int DIVIDE = 3;

	private float pOp1, pOp2;
	private int pOperacion = -1;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resultado = "No se ha podido realizar la operacion";

		// RECOGER PARAMETROS El formato en el que llegan es String y hay
		// que pasarlos a FLOAT
		try {
			pOp1 = Float.parseFloat((String) request.getParameter("op1"));
			pOp2 = Float.parseFloat((String) request.getParameter("op2"));
			pOperacion = Integer.parseInt((String) request.getParameter("operacion"));

		} catch (Exception e) {
			resultado = " El foramto de los operadores no es corrrect0";
			e.printStackTrace();
		}

		// Obtener resultado en funcion de la operacion

		switch (pOperacion) {

		case SUMA:
			resultado = "Resultado: " + (pOp1 + pOp2);
			break;
		case RESTA:
			resultado = "Resultado: " + (pOp1 - pOp2);
			break;
		case MULTIPLICA:
			resultado = "Resultado: " + (pOp1 * pOp2);
			break;
		case DIVIDE:
			if (pOp2 == 0) {
				System.out.println("No se puede dividir por 0");
			} else {
				resultado = "Resultado: " + (pOp1 / pOp2);
			}
			break;
		default:
			resultado = "Operacion no soportada";
			break;
		}

		// guardar mensaje como atributo

		request.setAttribute("resul", resultado);

		dispatcher = request.getRequestDispatcher("calculadora.jsp");
		dispatcher.forward(request, response);

		// estas dos ultimas lineas se podian haber puesto como:
		// request.getRequestDispatcher("ejercicios/calculadora.jsp").forward(request,
		// response);

	}
}
