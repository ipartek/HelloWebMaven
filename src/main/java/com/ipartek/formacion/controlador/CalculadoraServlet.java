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
	public static final int SUMA = 0;
	public static final int RESTA = 1;
	public static final int MULTIPLICA = 2;
	public static final int DIVIDE = 3;
	private Float op1,op2;
	private int iOperador = 0;
	

	
	
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String calculo = "no se ha podido realizar la operacion";
		
		
		try{
			//Recoger parametros
			String pop1 = (String)request.getParameter("numero1").trim();
			String pop2 = (String)request.getParameter("numero2").trim();
		
			//reemplazar comas por puntos
			pop1.replace(",", ".");
			pop2.replace(",", ".");
			op1 = Float.parseFloat(pop1);
			op2 = Float.parseFloat(pop2);
			iOperador = Integer.parseInt((String)request.getParameter("operadores"));
		
		
		if (Float.isNaN(op1)||Float.isNaN(op2)){
			
			calculo = "El formato de los operadores no es correcto";
			
		}else{
			switch(iOperador){
			case (SUMA):
				calculo = "Resultado: "+op1+" + "+op2+" = " + (op1+op2); 
				break;
			case (RESTA):
				calculo = "Resultado: "+op1+" - "+op2+" = " + (op1-op2);
				break;
			case (MULTIPLICA):
				calculo = "Resultado: "+op1+" * "+op2+" = " + (op1*op2);
				break;
			case (DIVIDE):
				calculo = "Resultado: "+op1+" / "+op2+" = " + (op1/op2);
				break;
			}
		}
		
		}catch(NumberFormatException e){
			calculo = "El formato de los operadores no es correcto";
			e.printStackTrace();
		}catch (Exception e) {
			calculo = "Fallo sin controlar en la calculadora";
			e.printStackTrace();
		}
		
		request.setAttribute("res", calculo );
		request.getRequestDispatcher("calculadora/calcu.jsp").forward(request, response);
	}

	

}
