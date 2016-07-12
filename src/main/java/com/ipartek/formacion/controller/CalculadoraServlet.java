package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.Calculadora;

/**
 * Servlet implementation class CalculadoraServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	public static final char SUMA = '+';
	public static final char RESTA = '-';
	public static final char MULTIPLICA = '*';
	public static final char DIVIDE = '/';
 
	private float pOp1;
	private float pOp2; 
	private char pOperador;
	
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
		
			
		
			String calculo = "No se ha podido realizar la operación";
						
			try{
				
				//recoger parámetros
				String pop1 = (String)request.getParameter("op1").trim(); 
				String pop2 = (String)request.getParameter("op2").trim();
				
				//reemplazar comas por puntos
				pop1 = pop1.replace(",", ".");
				pop2 = pop2.replace(",", ".");
				
				pOp1 = Float.parseFloat(pop1);
				pOp2 = Float.parseFloat(pop2);
				pOperador = request.getParameter("operacion").charAt(0);
				
				//hacer operación
				Calculadora c = new Calculadora(pOp1, pOp2, pOperador);
				Float r = (Float)c.calcular(c.getOp1(), c.getOp2(), c.getOperador());
				calculo = "El resultado es: " + Float.toString(r).replace(".", ",");
				
			}catch(NumberFormatException e){
				calculo = "El formato de los operadores no es correcto";
				e.printStackTrace();
			
			}catch(Exception e){
				calculo = "Fallo al operar";
				e.printStackTrace();
			}
				
							
			//enviar el atributo resultado del cálculo
			request.setAttribute("calculo", calculo);
			
			//ir a calculadora/calculadora.jsp		
			request.getRequestDispatcher("calculadora/calculadora.jsp").forward(request, response);
				
					
			
		
	}

}
