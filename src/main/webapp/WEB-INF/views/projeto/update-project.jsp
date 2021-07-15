<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="Projetos" var="paginaProjetos" />
<c:url value="AlterarProjeto" var="atualizarProjeto" />

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

<title>Atualizar projeto</title>

<link rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>
<body id="page-login">
	<div id="container">
		<header class="header-box">
			<div class="logo-box">
				<a href="index"><img src="public/mobicare-akross-logo.svg" /></a>
			</div>
			<div class="profile-box">
				Fulano de Tal <a href="login"><span class="lnr lnr-exit"></span></a>
			</div>
		</header>
	</div>
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
					<a href="new-project">
						<button class="btn btn-create">
							<span class="lnr lnr-file-add"></span>Cadastro
						</button>
					</a>
				</div>
			</div>
			<div class="boxes">
				<div class="box">
					<a href="version" class="project"><p>Projeto 1</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 2</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 3</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 4</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 5</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 6</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto com nome
							grande</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
				<div class="box">
					<a href="version" class="project"><p>Projeto 8</p></a>
					<div class="btn-manage">
						<a href="update-version"><span
							class="lnr lnr-pencil btn-manage"></span></a> <a
							href="confirm-delete-version"><span
							class="lnr lnr-trash btn-manage"></span></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="overlay">
		<div class="modal-box">
			<a href="${paginaProjetos }"><button class="btn-close"
					type="button">
					<span class="lnr lnr-cross"></span>
				</button></a>
			<h1>Atualizar projeto</h1>
			<h2>Projeto projeto</h2>

			<form class="form-col" method="POST" action="${atualizarProjeto}">
				<input type="hidden" name="id_projeto" value="${projeto.id_projeto}" />
				<div class="form-group">
					<label for="name">Nome:</label> <input type="text" id="name"
						name="nome" value="${projeto.nome }" />
				</div>
				<div class="form-group">
					<label for="status">Estado: </label> <select class="input-drop"
						name="situacao" id="status">
						<c:if test="${projeto.situacao == true}">
							<option value="1" selected="selected">Ativo</option>
							<option value="2">Inativo</option>
						</c:if>
						<c:if test="${projeto.situacao == false}">
							<option value="1">Ativo</option>
							<option value="2" selected="selected">Inativo</option>
						</c:if>

					</select>
				</div>
				<div class="btn-group">
					<a href="${paginaProjetos }"><button class="btn btn-cancel"
							type="button">Cancelar</button></a> <a><button
							class="btn btn-confirm">Salvar</button>
						<a>
				</div>
			</form>

		</div>
	</div>
</body>
</html>