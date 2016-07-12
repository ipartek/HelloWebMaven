package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Calculadora;

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
		
		
		try{
		
			//recoger parametros
			String pop1 = (String)request.getParameter("op1").trim();
			String pop2 = (String)request.getParameter("op2").trim();
			
			//reemplazar "," por "."
			pop1 = pop1.replace(",", ".");
			pop2 = pop2.replace(",", ".");
			
			op1 = Float.parseFloat(pop1);
			op2 = Float.parseFloat(pop2);
			op = Integer.parseInt((String)request.getParameter("operador"));
			
			switch (op) {
			case SUMA:
				calculo = "" + (op1 + op2);
				break;
			case DIVIDE:
				if (op2==0){
					calculo = "Infinito";
				}else{
					calculo = "" + (op1 / op2);
				}
				break;
			case RESTA:
				calculo = "" + (op1 - op2);
				break;
			case MULTIPLICA:
				calculo = "" + (op1 * op2);
				break;	
	
			default:
				calculo = "Operacion no soportada";
				break;
			}
		
		}catch(NumberFormatException i){
			calculo = "El formato de los operadores no es correcto";
			i.printStackTrace();
		}catch(Exception e){
			calculo = "Fallo al operar con la calculadora";
			e.printStackTrace();
		}	
		
		request.setAttribute("calculo", calculo.replace(".", ",") );
		request.getRequestDispatcher("calculadora/calculadora.jsp").forward(request, response);
				
	}

}

