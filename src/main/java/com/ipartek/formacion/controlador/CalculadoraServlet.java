package com.ipartek.formacion.controlador;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String pagina = "";
    	try{
    		double op1 = Double.parseDouble(request.getParameter("operador1"));
        	double op2 = Double.parseDouble(request.getParameter("operador2"));
        	int operacion = Integer.parseInt(request.getParameter("operacion"));
        	double resultado = 0;
        	switch(operacion){
    	    	case 1:
    	    		resultado = op1 + op2;
    	    		break;
    	    	case 2:
    	    		resultado = op1 - op2;
    	    		break;
    	    	case 3:
    	    		resultado = op1 * op2;
    	    		break;
    	    	case 4:
    	    		resultado = op1 / op2;
    	    		break;
        	}
        	request.setAttribute("resultado", resultado);
        	pagina = "calculadora.jsp";
    	}catch(NumberFormatException nfe){
    		request.setAttribute("error", "Los operadores deben ser valores numericos");
        	pagina = "calculadora.jsp";
    	}finally {
			request.getRequestDispatcher(pagina).forward(request, response);
		}   	
    }
}
