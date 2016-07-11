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
		float pOp1, pOp2;
		int pOperacion = -1;

		String calculo ="No se jha podido realizar la operacion";
		try {

			// RECOGER PARAMETROS El formato en el que llegan es String y hay
			// que pasarlos a FLOAT
			pOp1 = Float.parseFloat((String)request.getParameter("op1"));
			pOp2 = Float.parseFloat((String)request.getParameter("op2"));
			pOperacion = Integer.parseInt((String)request.getParameter("operacion"));

			// Obtener resultado en funcion de la operacion

			switch (pOperacion) {

			case SUMA:
				resultado = (pOp1 + pOp2);
				break;
			case RESTA:
				resultado = (pOp1 - pOp2);
				break;
			case MULTIPLICA:
				resultado = (pOp1 * pOp2);
				break;
			case DIVIDE:
				if( pOp2 == 0){
					System.out.println("No se puede dividir por 0");
				}else {
					resultado = (pOp1 / pOp2);
				}
				break;
			}

			// guardar mensaje como atributo
			request.setAttribute("resul", resultado);
			

		} catch (Exception e) {
			calculo =" El foramto de los operadores no es corrrect0";
			e.printStackTrace();
		}finally{
			// Volver a Calculadora
			dispatcher = request.getRequestDispatcher("calculadora.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
