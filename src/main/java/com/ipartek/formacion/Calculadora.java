package com.ipartek.formacion;

public class Calculadora {
	
	private float op1;
	private float op2;
	private char operador;
	private float resultado;
	
	
	public Calculadora(float op1, float op2, char operador) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.operador = operador;
		this.resultado = 0f;
	}


	public float getOp1() {
		return op1;
	}


	public void setOp1(float op1) {
		this.op1 = op1;
	}


	public float getOp2() {
		return op2;
	}


	public void setOp2(float op2) {
		this.op2 = op2;
	}


	public char getOperador() {
		return operador;
	}


	public void setOperador(char operador) {
		this.operador = operador;
	}


	public float getResultado() {
		return resultado;
	}


	@Override
	public String toString() {
		return "Calculadora [op1=" + op1 + ", op2=" + op2 + ", operador=" + operador + ", resultado=" + resultado + "]";
	}

	
	public float calcular(float op1, float op2, char operador){
		float resultado = 0f;
		
		switch(operador){
			case '+': resultado = sumar(op1, op2);
				break;
			case '-': resultado = restar(op1, op2);
				break;
			case '*': resultado = multiplicar(op1, op2);
				break;
			case '/': resultado = dividir(op1, op2);
				break;
			default: 
				break;
		}
		
		return resultado;
	}
	
	public float sumar(float op1, float op2){
		float resultado = 0f;
		
		resultado = op1 + op2;
		
		return resultado;
	}
	
	public float restar(float op1, float op2){
		float resultado = 0f;
		
		resultado = op1 - op2;
		
		return resultado;
	}
	
	public float dividir(float op1, float op2){
		float resultado = 0f;
		
		if (op1>0f){
			resultado = op1 / op2;
		}
		return resultado;
	}
	
	public float multiplicar(float op1, float op2){
		float resultado = 0f;
		
		resultado = op1 * op2;
		
		return resultado;
	}
}
