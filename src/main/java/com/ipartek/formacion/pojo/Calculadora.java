package com.ipartek.formacion.pojo;

public class Calculadora {
	private double operador1;
	private double operador2;
	
	public Calculadora(double operador1, double operador2) {
		super();
		this.operador1 = operador1;
		this.operador2 = operador2;
	}

	public double getOperador1() {
		return operador1;
	}

	public void setOperador1(double operador1) {
		this.operador1 = operador1;
	}

	public double getOperador2() {
		return operador2;
	}

	public void setOperador2(double operador2) {
		this.operador2 = operador2;
	}
	
	//FUNCIONES PARA SUMAR, RESTAR, MULTIPLICAR Y DIVIDIR
	public static double sumar(double num1, double num2){
		double dev = 0.0;
		dev = num1+num2;
		return dev;
	}
	public static double restar(double num1, double num2){
		double dev = 0.0;
		dev = num1-num2;
		return dev;
	}
	public static double multiplicar(double num1, double num2){
		double dev = 0.0;
		dev = num1*num2;
		return dev;
	}
	public static double dividir(double num1, double num2){
		double dev = 0.0;
		if (num2==0){
			dev = 0;
		}else{
			dev = num1/num2;
		}
		return dev;
	}
}
