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
			//recoger parametros
			float oper1 = Float.valueOf(request.getParameter("op1"));
			float oper2 = Float.valueOf(request.getParameter("op2"));
			String operacion = request.getParameter("operacion");
			float resul = 0;
			
			//comprobar el tipo de operacion a realizar
			if("suma".equals(operacion)){
				resul = oper1 + oper2;								
				
			}else if("resta".equals(operacion)){
				resul = oper1 - oper2;		
				
			}else if("multiplicacion".equals(operacion)){
				resul = oper1 * oper2;		
				
			}else if("division".equals(operacion)){
				resul = oper1 / oper2;		
				
			}
			
			request.setAttribute("resultado", resul);				
			dispatcher = request.getRequestDispatcher("calculadora/calculadora.jsp");
			
			dispatcher.forward(request, response);
			
		}catch (Exception e){
			e.printStackTrace();			
		}
	}

}
