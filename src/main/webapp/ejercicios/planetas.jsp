<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp" %>

<h1>Planetas</h1>


<% 
	ArrayList<Planeta> lPlanetas = (ArrayList<Planeta>) request.getAttribute("planetas");
	if (lPlanetas != null){
		for(Planeta l: lPlanetas){
			l.getImagen();
			l.getNombre();
			
		}
	}
%>



<%@ include file="../includes/footer.jsp" %>