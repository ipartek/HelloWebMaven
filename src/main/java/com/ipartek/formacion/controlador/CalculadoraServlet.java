package com.ipartek.formacion.controlador;

import java.io.IOException;
import java.util.ArrayList;

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
	public static ArrayList<String> aOperaciones = new ArrayList<String> ();
	
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

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		float pNum1 = Float.parseFloat(request.getParameter("numero1")); 
		float pNum2 = Float.parseFloat(request.getParameter("numero2"));
		String sOperador = request.getParameter("operadores");
		aOperaciones.add(OPERACION_SUMAR);
		aOperaciones.add(OPERACION_RESTAR);
		aOperaciones.add(OPERACION_MULTIPLICAR);
		aOperaciones.add(OPERACION_DIVIDIR);
		int iOperacion = aOperaciones.indexOf(sOperador);
		float resultado = 0;
		if(!Float.isNaN(pNum1) && !Float.isNaN(pNum2)){
			switch (iOperacion){
			case (0): resultado = pNum1 + pNum2;
			case (1): resultado = pNum1 - pNum2;
			case (2): resultado = pNum1 * pNum2;
			case (3): resultado = pNum1 / pNum2;
			}
			
		request.setAttribute("res", resultado);
		dispatcher = request.getRequestDispatcher("calcu.jsp");
		}
		
		
		}catch (Exception e){
			
			
		}
		
		dispatcher.forward(request, response);
		
		
		
	}

}
