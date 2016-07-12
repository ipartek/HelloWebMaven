package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Calculadora;

/**
 * Servlet implementation class LoginServlet
 */
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		Double resultado = 0.0;
		//String resultado ="No se ha podido realizar la operación";
		try{
			
			//recoger parametros
			//double pOperador1 = Double.parseDouble(request.getParameter("operador1"));
			double pOperador1 = Double.valueOf(request.getParameter("operador1"));
			//double pOperador2 = Double.parseDouble(request.getParameter("operador2"));
			double pOperador2 = Double.valueOf(request.getParameter("operador2"));
			String pOpcion = request.getParameter("opcion");
			//Calcular
			if (pOpcion.equals("sumar")){
				resultado=Calculadora.sumar(pOperador1, pOperador2);
				//resultado=""+Calculadora.sumar(pOperador1, pOperador2);
			}else if (pOpcion.equals("restar")){
				resultado=Calculadora.restar(pOperador1, pOperador2);
				//resultado=""+Calculadora.restar(pOperador1, pOperador2);
			}else if (pOpcion.equals("multiplicar")){
				resultado=Calculadora.multiplicar(pOperador1, pOperador2);
				//resultado=""+Calculadora.multiplicar(pOperador1, pOperador2);
			}else if (pOpcion.equals("dividir")){
				resultado=Calculadora.dividir(pOperador1, pOperador2);
				//resultado=""+Calculadora.dividir(pOperador1, pOperador2);
			}else{
				//resultado = "Operación no soportada";
			}
			//Guardar resultado como atributo
			request.setAttribute("resul", resultado);
			
			//Volver a la página calculadora
			dispatcher = request.getRequestDispatcher("calculadora/calculadora.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e){
			//resultado = "El formato de los operadores no es correcto";
			e.printStackTrace();
		}
	}

}
