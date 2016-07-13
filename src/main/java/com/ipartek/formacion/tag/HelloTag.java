package com.ipartek.formacion.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String nombre;

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hola Mundo!");//pageContext.getOut() es como el out.print 
			if (nombre != null) {
				pageContext.getOut().print("Hola " + nombre + "!");
			}
		} catch (Exception e) {
			throw new JspException("Error: IOException" + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
}

}
