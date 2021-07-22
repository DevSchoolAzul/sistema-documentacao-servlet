<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="entrada?acao=Telas" var="linkTelas" />
<c:url value="entrada?acao=EditarVersao" var="atualizarVersao" />
<c:url value="entrada?acao=ExcluirVersao&id_projeto=${projeto.id_projeto }" var="excluirVersao" />
<c:url value="entrada?acao=Projetos" var="paginaProjetos" />
<c:url value="entrada?acao=NovaVersao&id_projeto=${projeto.id_projeto }" var="novaVersao" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="theme-color" content="#C4C4C4" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap"
	rel="stylesheet" />

<title>Versão</title>

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
							<li><a href="index">Versões</a></li>
						</ul>
						<a href="${novaVersao }">
							<button class="btn btn-create">
								<span class="lnr lnr-file-add"></span>Cadastro
							</button>
						</a>
					</div>
					<div class="title-content">
						<div class="flex">
						
							<div class="search-box">
								<form action="entrada" method="GET">
									<input type="hidden" name="acao" value="Versoes" />
									<label for="id_projeto">Projeto:</label>
									<select class="input-drop query-drop" name="id_projeto">
										<c:if test="${id_projeto eq null or id_projeto eq '0' }">
											<option value="0">---</option>
										</c:if>
										<c:forEach items="${projetos }" var="projeto">
												<option value="${projeto.id_projeto }" ${projeto.id_projeto eq id_projeto ? 'selected' : ''}>${projeto.nome }</option>
										</c:forEach>
									</select>
									
									<label for="situacao">Situação:</label>
									<select class="input-drop query-drop" name="situacao">
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
								<th>Número</th>
								<th>Data de lançamento</th>
								<th>Número do GMUD</th>
								<th>Total Func.</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody class="list-body">

<c:forEach items="${versoes}" var="versao">
	<c:url value="${linkTelas }&id_versao=${versao.id_versao }" var="paginaTelas" />
	<tr>
		<td><a href="${paginaTelas}">${versao.numero_versao}</a></td>
		<td><a href="${paginaTelas}">${versao.data_lancamento}</a></td>
		<td><a href="${paginaTelas}">${versao.gmud}</a></td>
		<td><a href="${paginaTelas}">total de func</a></td>
		<td><a
			href="${atualizarVersao }&id_versao=${versao.id_versao}"><span
				class="lnr lnr-pencil btn-manage"></span></a> <a
			href="${excluirVersao }&id_versao=${versao.id_versao}"><span
				class="lnr lnr-trash btn-manage"></span></a></td>
	<tr>
</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>

</html>