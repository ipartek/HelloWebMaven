package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final int SUMA       = 0;
	public static final int RESTA      = 1;
	public static final int MULTIPLICA = 2;
	public static final int DIVIDE     = 3;
	
	private Float op1, op2;
	private int op=-1;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String calculo = "No se ha podido realizar la operacion";
		
		//recoger parametros
		try{
			op1 = Float.parseFloat((String)request.getParameter("op1"));
			op2 = Float.parseFloat((String)request.getParameter("op2"));
			op = Integer.parseInt((String)request.getParameter("op"));
		}catch(Exception e){
			calculo = "El formato de los operadores no es correcto";
			e.printStackTrace();
		}	
		
		switch (op) {
		case SUMA:
			calculo = "Resultado: " + (op1 + op2);
			break;
		case DIVIDE:
			calculo = "Resultado: " + (op1 / op2);
			break;
		case RESTA:
			calculo = "Resultado: " + (op1 - op2);
			break;
		case MULTIPLICA:
			calculo = "Resultado: " + (op1 * op2);
			break;	

		default:
			calculo = "Operacion no soportada";
			break;
		}
		
		
		
		request.setAttribute("calculo", calculo );
		request.getRequestDispatcher("ejercicios/calculadora.jsp").forward(request, response);
		
		
		
	}

}
