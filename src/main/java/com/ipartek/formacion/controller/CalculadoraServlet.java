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

	public static final int SUMA = 0;
	public static final int RESTA = 1;
	public static final int MULTIPLICA = 2;
	public static final int DIVIDE = 3;

	private Float valor1, valor2;
	private int operacion = -1;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String calculo = "No se ha podido realizar la operacion";

		try {

			// recoger parametros
			String pop1 =  request.getParameter("valor1").trim();
			String pop2 =  request.getParameter("valor2").trim();

			// reemplazar "," por "."
			pop1 = pop1.replace(",", ".");
			pop2 = pop2.replace(",", ".");

			valor1 = Float.parseFloat(pop1);
			valor2 = Float.parseFloat(pop2);
			operacion = Integer.parseInt((String) request.getParameter("operacion"));

			switch (operacion) {
			case SUMA:
				calculo = "Resultado: " + (valor1 + valor2);
				break;
			case DIVIDE:
				calculo = "Resultado: " + (valor1 / valor2);
				break;
			case RESTA:
				calculo = "Resultado: " + (valor1 - valor2);
				break;
			case MULTIPLICA:
				calculo = "Resultado: " + (valor1 * valor2);
				break;

			default:
				calculo = "Operacion no soportada";
				break;
			}

		} catch (NumberFormatException e) {
			calculo = "El formato de los operadores no es correcto";
			e.printStackTrace();

		} catch (Exception e) {
			calculo = "Fallo al operar con la Calculadora";
			e.printStackTrace();
		}

		request.setAttribute("calculo", calculo.replace(".", ","));
		request.getRequestDispatcher("calculadora.jsp").forward(request, response);

	}

}
