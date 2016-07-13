<%@page import="com.ipartek.formacion.controller.CalculadoraServlet"%>
<%@ include file="../includes/head.jsp" %>

<div id="calculadora">

<form method="post" action="calculadora" class="form-signin">
     <fieldset class="form-group">
     <legend><h2><i class="fa fa-calculator" aria-hidden="true"></i> Calculadora</h2></legend>     

  	
  	
     <input type="text" name="op1" class="form-control" placeholder="Operando 1" value="${requestScope.operando1}" required autofocus>
        
     
    <br>
    <select class="form-control" name="operacion" id="exampleSelect1">
      <option value="<%=CalculadoraServlet.SUMA%>">más</option>
      <option value="<%=CalculadoraServlet.RESTA%>">menos</option>
      <option value="<%=CalculadoraServlet.MULTIPLICA%>">multiplicado por</option>
      <option value="<%=CalculadoraServlet.DIVIDE%>">dividido entre</option>
    </select>
  	    
  	     <br>
        <input type="text" name="op2" class="form-control" placeholder="Operando 2" value="${requestScope.operando2}" required>  

	
	            

  </fieldset>
                
         <label for="resultado">Resultado:</label><br>
         <input type="text" step="0.01" class="form-control" value="${requestScope.resultado}" disabled="disabled"></input><br>
                
                
        <button class="btn btn-lg btn-primary btn-block" type="submit">CALCULAR</button>
      </form>
      </div>

<%@ include file="../includes/footer.jsp" %>