<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="css/index.css">
<title>FIAP - Ifood Challenger</title>
</head>
<body>
	<div class="cabecalho">
		<p>
			<a href="home.jsp"><i class="fas fa-home"></i>home</a>
		</p>
	</div>
	<div class="box">

		<div class="direita">
			<div class="bannerlogin">
				<img src="imagens/logo.jpg" alt="">
			</div>
		</div>
		<div class="login">
			<form name="form" action="HomeController" method="post">
				<div class="camposLogin">
					<label for="nome">Nome:</label> <input type="text" id="login"
						name="login" value="TESTANDO" size="30"> <br> <label
						for="senha">Senha:</label> <input type="password" id="senha"
						name="senha" value="1234" size="30"> <br>
				</div>
				<div class="botaoEntrar">
					<input type="submit" value="Entrar">
				</div>
			</form>
		</div>

	</div>
</body>
</html>