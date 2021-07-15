<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="EditarProjeto" var="editarProjeto" />
<c:url value="ExcluirProjeto" var="excluirProjeto" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="theme-color" content="#C4C4C4" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap"
	rel="stylesheet" />

<title>Dashboard</title>
<link type="text/css" rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>
<body>
	<div id="container">

		<header class="header-box">
			<div class="logo-box">
<!-- 				<a href="index"><img src="public/mobicare-akross-logo.svg" /></a> -->
			</div>
			<div class="profile-box">
				Fulano de Tal <a href="login"><span class="lnr lnr-exit"></span></a>
			</div>
		</header>

		<div class="container">
			<div class="table">

				<div class="title-bar">
					<div class="title-content">
						<ul class="bd-group">
							<li><a href="index">Projetos</a></li>
						</ul>
					</div>
					<div class="title-content">
						<div class="flex">
							<div class="search-box">
								<input type="text" />
								<button type="submit">
									<span class="lnr lnr-magnifier"></span>
								</button>
							</div>
							<select class="input-drop query-drop" name="status">
								<option value="">---</option>
								<option value="1">Ativo</option>
								<option value="2">Inativo</option>
							</select>
						</div>
						<a href="NovoProjeto">
							<button class="btn btn-create">
								<span class="lnr lnr-file-add"></span>Cadastro
							</button>
						</a>
					</div>
				</div>

				<div class="boxes">


					<c:forEach items="${projetos }" var="projeto">
						<div class="box">
							<a href="Versoes?id_projeto=${projeto.id_projeto }" class="project"><p>${projeto.nome }-
									${projeto.situacao }</p></a>
							<div class="btn-manage">
								<a href="${editarProjeto }?id_projeto=${projeto.id_projeto}"><span
									class="lnr lnr-pencil btn-manage"></span></a> <a
									href="${excluirProjeto }?id_projeto=${projeto.id_projeto}"><span
									class="lnr lnr-trash btn-manage"></span></a>
							</div>

						</div>
					</c:forEach>
				</div>
			</div>
		</div>


	</div>
</body>
</html>