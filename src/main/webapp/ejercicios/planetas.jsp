<%@page import="com.ipartek.formacion.pojo.Planeta"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../includes/head.jsp"%>

<h1>Lista de Planetas</h1>

<div class="wrapper">
	<table border="1">
		<thead>
			<th>Imagen</th>
			<th>Nombre</th>
			<th style="width: 25%">Distancia respecto al Planeta Tierra</th>
		</thead>
		<tbody>
			<%
				ArrayList<Planeta> lista = (ArrayList<Planeta>) request.getAttribute("ListaPlanetas");
				for (Planeta p1 : lista) {
			%>
			<tr>
				<td><img src="<%=p1.getImg()%>" class="planetas"></img></td>
				<td><%=p1.getNombre()%></td>
				<td><%=p1.getDistancia()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<form id="buscador" action="/search" style="display:inline;" method="get">
		<input id="caja_de_busqueda" name="q" placeholder="Planeta a buscar" />
		<input id="boton_de_buscar" value="Buscar" type="submit" />
	</form>
</div>

     <script type="application/ld+json">
    {
       "@context": "http://schema.org",
       "@type": "WebSite",
       "url": "http://http://localhost:8080/HelloWebMaven/planetas/",
       "potentialAction": {
         "@type": "SearchAction",
         "target": "http://localhost:8080/HelloWebMaven/planetas/search?q={search_term_string}",
         "query-input": "required name=search_term_string"
       }
    }
    </script>


<%@ include file="../includes/footer.jsp"%>