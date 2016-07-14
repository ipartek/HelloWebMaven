<%@page import="java.net.URL"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.RenderedImage"%>
<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

<%
		ArrayList<Planeta> aPlanetas = (ArrayList<Planeta>)request.getAttribute("planetas");
		for (Planeta pl : aPlanetas){%>
				<tr>
					<td><img src="/img/mercurio.png"></img></td>
					<td><%=pl.getNombre() %></td>
					<td><%=pl.getDistancia() %></td>
				</tr>	
		<%}%>
	








<%@ include file="../includes/footer.jsp"%>