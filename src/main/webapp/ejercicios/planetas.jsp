<%@page import="java.net.URL"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.RenderedImage"%>
<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

	
<div >

	<h1 align="center">Planetas del Sistema Solar</h1>
	
    <table id="planetas" class="table table-striped custab">
    <thead>
        <tr>
            <th>Imagen del Planeta</th>
            <th>Nombre del Planeta</th>
            <th>Distancia a la Tierra en km</th>
        </tr>
    </thead>
            <%
            	int anyo = Integer.parseInt("2013");
            
            
            
            ArrayList<Planeta> aPlanetas = (ArrayList<Planeta>)request.getAttribute("planetas");
    		for (Planeta pl : aPlanetas){%>
				<tr id="planetas">
					<td><img src='<%=pl.getImg()%>' height=100 width=100></img></td>
					<td><%=pl.getNombre() %></td>
					<td><%=pl.getDistancia() %></td>
				</tr>	
		<%}%>
    </table>
 </div>







<%@ include file="../includes/footer.jsp"%>