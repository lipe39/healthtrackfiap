<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fiap.healthtrack.AlturaBO"%>
<%@page import="br.com.fiap.healthtrack.UsuarioBO"%>
<jsp:useBean id="AlturaBO" class="br.com.fiap.healthtrack.AlturaBO"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="css/altura.css">
<title>Pesos</title>
</head>
<body>
	<div class="cabecalho">
		<p>
			<a href="home.jsp"><i class="fas fa-home"></i>home</a>
		</p>


		<p>
			<a href="#"><i class="fas fa-sign-out-alt"></i>logout</a>
		</p>

	</div>
	<div class="lista">
		<h3>Alturas</h3>
		<h5>id - Altura</h5>
		<%
		UsuarioBO usuarioBO = (UsuarioBO) session.getAttribute("usuario");
		List<AlturaBO> alturas = AlturaBO.ListarAltura(usuarioBO);
		for (AlturaBO rest : alturas) {
		%>
		<h5>
			<%=rest.getIdAltura()%>
			- <a href='index.jsp'><%=rest.getVlr_altura()%></a>
		</h5>
		<%
		}
		%>
	</div>
	<div class="formularioAltura">
		<form name="form" action="CadastrarAlturaController" method="post">
			<label for="nome">valor Altura:</label> <input type="text"
				id="valorAltura" name="valorAltura" value="0.0" size="30"> <br>
			<input type="submit" value="Cadastrar">
		</form>
		<form name="form" action="DeletarAlturaController" method="post">
			<label for="nome">id Peso:</label> <input type="text" id="idAltura"
				name="idAltura" value="0" size="30"> <br> <input
				type="submit" value="Deletar">
		</form>
	</div>
</body>
</html>