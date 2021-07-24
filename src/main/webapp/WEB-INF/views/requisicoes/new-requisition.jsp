<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="entrada?acao=Requisicoes" var="paginaRequisicao" />
<c:url value="entrada?acao=InserirRequisicao" var="cadastrar" />

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

<title>Cadastrar nova Requisição</title>

<link rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>
<body id="page-login">

	<c:import url="/components/header.jsp" />

	<div class="container">
		<div class="table">
			<div class="title-bar">
				<div class="title-content">
					<ul class="bd-group">
						<li><a href="index">Requisição</a></li>
					</ul>
					<a href="new-version">
						<button class="btn btn-create">
							<span class="lnr lnr-file-add"></span>Cadastro
						</button>
					</a>
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
				</table>
			</div>
		</div>
	</div>


	<div class="overlay">
		<div class="modal-box">
			<a href="${paginaVersoes }"><button class="btn-close">
					<span class="lnr lnr-cross"></span>
				</button></a>
			<h1>Cadastrar Requisição</h1>

			<form class="form-col" action="${cadastrar}" method="POST">
				<input type="hidden" name="id_requisicao" />
				<div class="form-row">
					<div class="form-col">
						<div class="form-group">
							<label for="status">Id Evento:</label>
							<select class="input-drop" name="id_evento" id="evento">
								<c:forEach items="${eventos }" var="evento">
									<option value="${evento.id_evento }">${evento.id_evento }</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="version">URL homolog</label> <input type="text"
								name="url_homolog" id="url_homolog" />
						</div>

						<div class="form-group">
							<label for="gmud">URL prod</label> <input type="text"
								name="uri_prod" id="uri_prod" />
						</div>
						<div class="form-group">
							<label for="date">Requisição pai:</label>
							 <select name="requisicao_pai" id="requisicao_pai">
							 	<option value="0" selected>---</option>
							 	<c:forEach items="${requisicoesPai }" var="requisicaoPai">
									<option value="${requisicaoPai.id_requisicao }">${requisicaoPai.camada }</option>
								</c:forEach>
							 </select>
						</div>
					</div>
					<div class="form-col">
						<div class="form-group">
							<label for="date">Camada:</label> <input type="text"
								name="camada" id="camada" />
						</div>

						<div class="form-group">
							<label for="date">Ordem:</label> <input type="text" name="ordem"
								id="ordem" />
						</div>

						<div class="form-group">
							<label for="status">Situacão:</label> <select class="input-drop"
								name="situacao" id="status">
								<option value="1" selected>Ativo</option>
								<option value="2">Inativo</option>
							</select>
						</div>
					</div>

				</div>
				<div class="form-group textarea">
					<label for="description">Descrição:</label>
					<textarea id="description" name="descricao"></textarea>
				</div>
				<div class="btn-group">
					<a href="${paginaRequisicoes }"><button class="btn btn-cancel"
							type="button">Cancelar</button></a> <a><button
							class="btn btn-confirm">Salvar</button></a>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>