package com.ipartek.formacion.controlador;

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
	private static final String FORMATO_NUM_ERROR = "Formato de números incorrecto.";
	private static final String OPERACION_SUMAR = "sumar";
	private static final String OPERACION_RESTAR = "restar";
	private static final String OPERACION_MULTIPLICAR = "multiplicar";
	private static final String OPERACION_DIVIDIR = "dividir";
	
	private RequestDispatcher dispatcher;

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
		try{
		float pNum1 = Float.parseFloat(request.getParameter("numero1")); 
		float pNum2 = Float.parseFloat(request.getParameter("numero2"));
		String sOperador = request.getParameter("operadores");
		float resultado = 0;
		if(!Float.isNaN(pNum1) && !Float.isNaN(pNum2)){
			if(OPERACION_SUMAR.equals(sOperador)){
				resultado = pNum1 + pNum2;
			}else if(OPERACION_RESTAR.equals(sOperador)){
				resultado = pNum1 - pNum2;
			}else if(OPERACION_MULTIPLICAR.equals(sOperador)){
				resultado = pNum1 * pNum2;
			}else if(OPERACION_MULTIPLICAR.equals(sOperador)){
				resultado = pNum1 / pNum2;
			}
		request.setAttribute("res", resultado);
		}
		
		dispatcher.forward(request, response);
		}catch (Exception e){
			request.setAttribute("msg", FORMATO_NUM_ERROR);
			dispatcher = request.getRequestDispatcher("calcu.jsp");
		}
		
		
		
		
		
	}

}
