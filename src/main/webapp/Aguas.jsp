<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fiap.healthtrack.AguaBO"%>
<%@page import="br.com.fiap.healthtrack.UsuarioBO"%>
<jsp:useBean id="AguaBO" class="br.com.fiap.healthtrack.AguaBO"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="css/ingestaoAgua.css">
<title>Aguas</title>
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
		<h3>Pesos</h3>
		<h5>id - peso</h5>
		<%
		UsuarioBO usuarioBO = (UsuarioBO) session.getAttribute("usuario");
		List<AguaBO> aguas = AguaBO.ListarAgua(usuarioBO);
		for (AguaBO rest : aguas) {
		%>
		<h5>
			<%=rest.getIdAgua()%>
			- <a href='index.jsp'><%=rest.getConsumoRegistro()%></a>
		</h5>
		<%
		}
		%>
	</div>
	<div class="formularioAgua">
		<form name="form" action="CadastrarAguaController" method="post">
			<label for="nome">valor Agua:</label> <input type="text"
				id="valorAgua" name="valorAgua" value="0.0" size="30"> <br>
			<input type="submit" value="Cadastrar">
		</form>
		<form name="form" action="DeletarAguaController" method="post">
			<label for="nome">id Agua:</label> <input type="text" id="idAgua"
				name="idAgua" value="0" size="30"> <br> <input
				type="submit" value="Deletar">
		</form>
	</div>
</body>
</html>