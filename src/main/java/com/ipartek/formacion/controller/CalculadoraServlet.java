package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.junit.runner.Request;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int SUMA = 0;
	public static final int RESTA = 1;
	public static final int MULTIPLICAR = 2;
	public static final int DIVIDIR = 3;
	
	
	private Float op1, op2;
	private int op=-1;


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
		
		

		String calculo = "No se ha podido realizar la operacion";
		
		
		try {
			
			
			
			//recoger parametros
			String ope1 = (String)request.getParameter("operador1").trim();
			String ope2 = (String)request.getParameter("operador2").trim();
			
			//reemplazar "," por "."
			ope1 =  ope1.replace(",", ".");
				
			ope2 =ope2.replace(",", ".");
			
			op1 = Float.parseFloat(ope1);
			op2 = Float.parseFloat(ope2);
			op = Integer.parseInt((String)request.getParameter("op"));
			
	
		
			
			
			switch (op) {
			case SUMA:
			
			calculo = "resultado" + (op1 + op2);
				
				break;

				
			case RESTA:
			 calculo = 	"resultado" +  (op1 - op2);
				break;
				
			case MULTIPLICAR :
				
			calculo = "resultado"  +  (op1 * op2);
				
				break;
				
			case DIVIDIR:
			 
			 calculo = "resultado" + (op1 / op2);
			   
			   break;
			
			default:
				break;
			}
			
		} catch (Exception e) {
			calculo = "el formato de los operadores no es correcto";
			e.printStackTrace();
			
		}	
		
		
		request.setAttribute("calculo", calculo.replace(".", ",") );
		request.getRequestDispatcher("calculadora.jsp").forward(request, response);
		  	
			
	
	}

}
