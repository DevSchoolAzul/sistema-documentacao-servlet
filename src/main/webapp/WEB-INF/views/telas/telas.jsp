<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="entrada?acao=NovaTela" var="novaTela" />
<c:url value="entrada?acao=EditarTela" var="atualizarTela" />
<c:url value="entrada?acao=ExcluirTela" var="excluirTela" />
									
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

<title>Telas</title>

<link rel="stylesheet" href="styles/main.css" />
<link rel="stylesheet" href="./styles/pages/screen.css" />
<link rel="stylesheet"
	href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>

<body>
	<div id="container">

		<c:import url="/components/header.jsp" />


		<div class="container">
			<div class="table">
				<div class="title-bar">
					<div class="title-content">
						<ul class="bd-group">
							<li><a href="">Corrigir essa funcionalidade</a></li>
							<li><a href="#">Versão</a></li>
						</ul>
						<a href="${novaTela }">
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
								<th>Nome da tela</th>
								<th>Imagem da tela</th>
								<th>Tela pai</th>
								<th>Ordem na hierarquia</th>
								<th>Data de cadastro</th>
								<th>URL log</th>
								<th>Situacao</th>
								<th>Ação</th>
							</tr>
						</thead>
						<tbody class="list-body">

							<c:forEach items="${telas}" var="tela">
								<tr>
									<td><a href="">${tela.nomeTela}</a></td>
									<td><a href="">${tela.imagem}</a></td>
									<td><a href="">${tela.telaPai}</a></td>
									<td><a href="">${tela.ordem}</a></td>
									<td><a href="">${tela.dataCadastro }</a></td>
									<td><a href="">${tela.urlLog }</a></td>
									<td><a href="">${tela.situacao }</a></td>
									<td><a
										href="${atualizarTela }&id_tela=${tela.idTela}"><span
											class="lnr lnr-pencil btn-manage"></span></a> <a
										href="${excluirTela }&id_versao=${versao.idTela}"><span
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
