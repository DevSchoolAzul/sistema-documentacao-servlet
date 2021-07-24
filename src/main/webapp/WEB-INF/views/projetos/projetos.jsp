<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.sistemaDocumentacao.modelo.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="entrada?acao=EditarProjeto" var="editarProjeto" />
<c:url value="entrada?acao=ExcluirProjeto" var="excluirProjeto" />
<c:url value="entrada?acao=NovoProjeto" var="novoProjeto" />
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
<link rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>
<body>
	<div id="container">

		<c:import url="/components/header.jsp" />

		<c:import url="/components/menuItens.jsp" />

		<div class="container">
			<div class="table">

				<div class="title-bar">
					<div class="title-content">
						<ul class="bd-group">
							<li><a href="index">Projetos</a></li>
						</ul>
						<a href="${novoProjeto }">
							<button class="btn btn-create">
								<span class="lnr lnr-file-add"></span>Cadastro
							</button>
						</a>
					</div>
					<div class="title-content">
						<div class="flex">

							<form method="get" action="entrada" class="search-box">
								<input type="hidden" name="acao" value="Projetos" /> <label
									for="nomeProjeto">Nome do projeto:</label> <input type="text"
									name="nomeProjeto" value="${nomeProjeto }" /> <label
									for="situacao">Situação:</label> <select
									class="input-drop query-drop" name="situacao">
									<c:choose>
										<c:when test="${parametroSituacao eq '1' }">
											<option value="0">Qualquer</option>
											<option value="1" selected>Ativo</option>
											<option value="2">Inativo</option>
										</c:when>
										<c:when test="${parametroSituacao eq '2' }">
											<option value="0">Qualquer</option>
											<option value="1">Ativo</option>
											<option value="2" selected>Inativo</option>
										</c:when>
										<c:otherwise>
											<option value="0" selected>Qualquer</option>
											<option value="1">Ativo</option>
											<option value="2">Inativo</option>
										</c:otherwise>
									</c:choose>
								</select>
								<button type="submit">
									<span class="lnr lnr-magnifier"></span>
								</button>
							</form>

						</div>

					</div>
				</div>

				<div class="boxes">


					<c:forEach items="${projetos }" var="projeto">
						<div class="box">
							<a href="entrada?acao=Versoes&id_projeto=${projeto.id_projeto }"
								class="project"><p>${projeto.nome }- ${projeto.situacao ? 'Ativo' : 'inativo' }</p></a>
							<div class="btn-manage">
								<a href="${editarProjeto }&id_projeto=${projeto.id_projeto}"><span
									class="lnr lnr-pencil btn-manage"></span></a> <a
									href="${excluirProjeto }&id_projeto=${projeto.id_projeto}"><span
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