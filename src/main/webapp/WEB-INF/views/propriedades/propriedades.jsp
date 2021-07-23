<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada?acao=EditarPropriedade" var="editar" />
<c:url value="entrada?acao=ExcluirPropriedade" var="excluir" />
<c:url value="entrada?acao=Propriedades" var="paginaPropriedade" />
<c:url value="entrada?acao=NovaPropriedade" var="novaPropriedade" />

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

<title>Propriedades de Requisição</title>
<link rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>
<body>

	<c:import url="/components/header.jsp" />

	<c:import url="/components/menuItens.jsp" />
	
	<div class="container">

		<div class="container">
			<div class="table">
				<div class="title-bar">

					<div class="title-content">
						<ul class="bd-group">
							<li><a href="${paginaPropriedade }">Propriedades</a></li>
						</ul>
						<a href="${novaPropriedade }">
							<button class="btn btn-create">
								<span class="lnr lnr-file-add"></span>Cadastro
							</button>
						</a>
					</div>

					<div class="title-content">
						<div class="flex">

							<div class="search-box">
								<form action="entrada" method="GET">
									<input type="hidden" name="acao" value="Propriedades" /> <label
										for="id_projeto">Projeto:</label> <select
										class="input-drop query-drop" name="id_projeto">
										<c:if test="${id_projeto eq null or id_projeto eq '0' }">
											<option value="0">---</option>
										</c:if>
										<c:forEach items="${projetos }" var="projeto">
											<option value="${projeto.id_projeto }"
												${projeto.id_projeto eq id_projeto ? 'selected' : ''}>${projeto.nome }</option>
										</c:forEach>
									</select> <label for="situacao">Situação:</label> <select
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

				</div>

				<div>
					<table class="list">
						<thead class="list-header">
							<tr>
								<th>Chave</th>
								<th>Valor</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody class="list-body">

							<c:forEach items="${propriedades}" var="propriedade">
								<tr>
									<td><a href="#">${propriedade.chave}</a></td>
									<td><a href="#">${propriedade.valor}</a></td>
									<td><a
										href="${editar }&id_propriedade=${propriedade.idPropriedade}">
											<span class="lnr lnr-pencil btn-manage"></span>
									</a> <a
										href="${excluir }&id_propriedade=${propriedade.idPropriedade}">
											<span class="lnr lnr-trash btn-manage"></span>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>