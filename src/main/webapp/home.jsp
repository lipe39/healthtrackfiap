<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="login" class="java.lang.String" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="pluggins/bootstrap/bootstrap-5.0.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="pluggins/fontawesome/fontawesome-free-5.15.3-web/css/all.css">
<link rel="stylesheet" href="css/Home.css">
<title>FIAP - Ifood Challenger</title>
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
	<div class="box">
		<div class="esquerda">
			<sidebar>
			<div class="menu">
				<ul>
					<li><a href='PesoListarController'>Peso</a></li>

					<li><a href="AlturaListarController"><i
							class="fas fa-arrows-alt-v"></i> altura</a></li>
					<li><a href='AguaListarController'><i class="fas fa-tint"></i>Ingestão
							de agua</a></li>
					<li><a href="#"><i class="fas fa-running"></i>KM
							Percorridos</a></li>
				</ul>
			</div>
			</sidebar>
		</div>
		<div class="direita"></div>
	</div>
	<script
		src="pluggins/bootstrap-5.0.2-dist/bootstrap-5.0.2-dist/js/bootstrap.min.js"></script>
	<script
		src="pluggins/fontawesome/fontawesome-free-5.15.3-web/js/all.min.js"></script>

</body>
</html>