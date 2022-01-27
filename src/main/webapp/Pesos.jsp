<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fiap.healthtrack.PesoBO"%>
<%@page import="br.com.fiap.healthtrack.UsuarioBO"%>
<jsp:useBean id="pesoBO" class="br.com.fiap.healthtrack.PesoBO"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="css/peso.css">
<title>Pesos</title>
</head>
<body>
	<div class="cabecalho">
		<p>
			<a href="home.jsp"><i class="fas fa-home"></i>home </a>
		</p>


		<p>
			<a href="#"><i class="fas fa-sign-out-alt"></i>logout </a>
		</p>

	</div>
	<div class="lista">
		<h3>Pesos</h3>
		<h5>id - peso</h5>
		<%
		UsuarioBO usuarioBO = (UsuarioBO) session.getAttribute("usuario");
		List<PesoBO> pesos = pesoBO.ListarPesos(usuarioBO);
		for (PesoBO rest : pesos) {
		%>
		<h5>
			<%=rest.getIdPeso()%>
			- <a href='index.jsp'><%=rest.getValor_peso()%></a>
		</h5>
		<%
		}
		%>
	</div>
	<div class="formularioPeso">
		<div class="cadastrar">
			<form name="form" action="CadastrarPesoController" method="post">
				<label for="nome">valor Peso:</label> <input type="text"
					id="valorPeso" name="valorPeso" value="0.0" size="30"> <br>
				<input class="btn-cadastrar" type="submit" value="Cadastrar">
			</form>
		</div>
		<div class="deletar">
			<form name="form" action="DeletarPesoController" method="post">
				<label for="nome">id Peso:</label> <input class="btn-deletar"
					type="text" id="idPeso" name="idPeso" value="0" size="30">
				<br> <input type="submit" value="Deletar">
			</form>
		</div>
	</div>
</body>
</html>