<%@ include file="../includes/head.jsp" %>


<form method="post" action="<%=Constantes.WEB_HOME %>calculadora" class="form-signin">
     <fieldset class="form-group">
     <legend><h2><i class="fa fa-calculator" aria-hidden="true"></i> Calculadora</h2></legend>
     
       <% 
	Float resultado = (Float)request.getAttribute("resultado");
  	if(resultado != null){
  	%>
  	
  	
     <input type="number" step="0.01" name="op1" class="form-control" placeholder="Operando 1" value=<%=(Float)request.getAttribute("operando1")%> required autofocus>
        
     
    <br>
    <select class="form-control" name="operacion" id="exampleSelect1">
      <option value="suma">más</option>
      <option value="resta">menos</option>
      <option value="multiplicacion">multiplicado por</option>
      <option value="division">dividido entre</option>
    </select>
  	    
  	     <br>
        <input type="number" step="0.01" name="op2" class="form-control" placeholder="Operando 2" value=<%=(Float)request.getAttribute("operando2")%> required>  
  

  		
  	<%	
  	}else{
  		resultado = 0.0f;  %>
  	     <input type="number" step="0.01" name="op1" class="form-control" placeholder="Operando 1"  required autofocus>
         
  	     
  	    <br>
  	    <select class="form-control" name="operacion" id="exampleSelect1">
  	      <option value="suma">más</option>
  	      <option value="resta">menos</option>
  	      <option value="multiplicacion">multiplicado por</option>
  	      <option value="division">dividido entre</option>
  	    </select>
  	    
  	     <br>
        <input type="number" step="0.01" name="op2" class="form-control" placeholder="Operando 2" required>
  	 <%
  	}
	%>
	
	            

  </fieldset>
                
         <label for="resultado">Resultado:</label><br>
         <input type="text" step="0.01" class="form-control" value="<%=resultado%>" disabled="disabled"></input><br>
                
                
        <button class="btn btn-lg btn-primary btn-block" type="submit">CALCULAR</button>
      </form>

<%@ include file="../includes/footer.jsp" %>