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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculadoraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response) {
		float resultado = 0;

		try {

			// RECOGER PARAMETROS El formato en el que llegan es String y hay
			// que pasarlos a FLOAT
			float pOp1 = Float.parseFloat(request.getParameter("op1"));
			float pOp2 = Float.parseFloat(request.getParameter("op2"));
			int pOperacion = Integer.parseInt(request.getParameter("operacion"));

			// Obtener resultado en funcion de la operacion

			switch (pOperacion) {

			case SUMA:
				resultado = pOp1 + pOp2;
				break;
			case RESTA:
				resultado = pOp1 - pOp2;
				break;
			case MULTIPLICA:
				resultado = pOp1 * pOp2;
				break;
			case DIVIDE:
				resultado = pOp1 / pOp2;
				break;
			}

			// guardar mensaje como atributo
			request.setAttribute("resul", resultado);
			// Volver a Calculadora
			dispatcher = request.getRequestDispatcher("calculadora.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
