<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="entrada?acao=TiposEventos" var="paginaEventos" />
<c:url value="entrada?acao=AlterarTipoEvento" var="alterar" />

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

<title>Atualizar Eventos</title>

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
						<li><a href="index">Eventos</a></li>
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
					<a href="new-project">
						<button class="btn btn-create">
							<span class="lnr lnr-file-add"></span>Cadastro
						</button>
					</a>
				</div>
			</div>
			
			
		</div>
	</div>
	<div class="overlay">
		<div class="modal-box">
			<a href="${paginaTiposEventos }"><button class="btn-close"
					type="button">
					<span class="lnr lnr-cross"></span>
				</button></a>
			<h1>Cadastrar Tipos Eventos</h1>

			<form method="POST" action="${alterar}">
				<input type="hidden" name="id_tipo_evento" value="${tipo.id_tipo_evento }"/>
				<div class="form-col">
					<div class="form-group">
						<label for="nome">Nome do tipo de Evento:</label> <input
							type="text" id="nome" name="nome" value="${tipo.nome }"/>
					</div>
					<div class="form-group">
						<label for="situacao">Situacao:</label> <select class="input-drop"
							name="situacao" id="situacao">
							<option value="1" ${tipo.situacao eq true ? 'selected' : '' }>Ativo</option>
							<option value="0" ${tipo.situacao eq false ? 'selected' : '' }>Inativo</option>
						</select>
					</div>
				</div>
				<div class="btn-group">
					<a href="${paginaTiposEventos }"><button class="btn btn-cancel"
							type="button">Cancelar</button></a> <a><button
							class="btn btn-confirm">Salvar</button></a>
				</div>
			</form>

		</div>
	</div>
</body>
</html>