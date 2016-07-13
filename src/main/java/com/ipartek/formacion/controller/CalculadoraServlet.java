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
	public static final int DIVIDE = 3;

	private Float oper1, oper2;
	private int operacion=-1;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String calculo = "No se ha podido realizar la operacion"; 

		try{
			//recoger parametros				
			String pop1 = (String)request.getParameter("op1").trim();
			String pop2 = (String)request.getParameter("op2").trim();

			//reemplazar ',' por '.'
			pop1 = pop1.replace(',', '.');
			pop2 = pop2.replace(',', '.');
			
			oper1 = Float.parseFloat(pop1);
			oper2 = Float.parseFloat(pop2);
			operacion = Integer.parseInt((String)request.getParameter("operacion"));			

			
			//comprobar el tipo de operacion a realizar
			switch (operacion) {
			case SUMA:
				calculo = String.valueOf((oper1 + oper2));
				break;
			case DIVIDE:
				calculo = String.valueOf((oper1 / oper2));
				break;
			case RESTA:
				calculo = String.valueOf((oper1 - oper2));
				break;
			case MULTIPLICA:
				calculo = String.valueOf((oper1 * oper2));
				break;	

			default:
				calculo = "Operacion no soportada";
				break;
			}
			
		}catch (NumberFormatException e){
			calculo = "Formato de operadores no valido";
			e.printStackTrace();			
		}catch (Exception e){
			calculo = "Fallo sin controlar en la calculadora";
			e.printStackTrace();
			
		}
		
		request.setAttribute("resultado", calculo.replace(".", ",") );
		request.setAttribute("operando1", oper1);
		request.setAttribute("operando2", oper2);
		request.setAttribute("operacion", operacion);
		request.getRequestDispatcher("ejercicios/calculadora.jsp").forward(request, response);
		
	}
}
