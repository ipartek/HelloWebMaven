package com.ipartek.formacion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiprimerServlet
 */
public class MiprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcces(request, response);
	}

	private void doProcces(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//definir como respondemos
		response.setContentType("text/html;charset=UTF-8");
		
		//escribir la respuesta
		PrintWriter out = null;
		try{
			out = response.getWriter();
			
			out.print("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Capitulo16</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hola Mundo</h1>");
			out.println("</body>");
			out.println("</html>");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			out.close();
		}
	}

}
