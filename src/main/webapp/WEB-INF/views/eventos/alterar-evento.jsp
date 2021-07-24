<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="entrada?acao=Eventos" var="paginaEventos" />
<c:url value="entrada?acao=AlterarEvento" var="atualizar" />

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
			<a href="${paginaEventos }"><button class="btn-close"
					type="button">
					<span class="lnr lnr-cross"></span>
				</button></a>
			<h1>Atualizar Eventos</h1>

			<form class="form-col" method="POST" action="${atualizar}">
				<input type="hidden" name="id_evento" value="${evento.id_evento}" />
				<div class="form-col">				
					<div class="form-group">
						<label for="id_tipo_evento">Tipo de Evento:</label>
						<select name="id_tipo_evento">
							<c:forEach items="${tiposEventos}" var="tipoEvento">
								<option value="${tipoEvento.id_tipo_evento }" 
									${tipoEvento.id_tipo_evento eq evento.id_tipo_evento ? 'selected': ''}>
										${tipoEvento.nome }
								</option>
									
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="id_tela">Tela:</label>
						<select name="id_tela">
							<c:forEach items="${telas}" var="tela">
								<option value="${tela.idTela }" 
									${tela.idTela eq evento.id_tela ? 'selected': ''}>
										${tela.nomeTela }
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-col">
					<div class="form-group">
						<label for="situacao">Situacao:</label>
						<select class="input-drop" name="situacao" id="status">
	                        <option value="1" ${evento.situacao eq true ? 'selected' : '' }>Ativo</option>
	                        <option value="0" ${evento.situacao eq false ? 'selected' : '' }>Inativo</option>
	                    </select>
					</div>
					<div class="form-group">
						<label for="ordem">ordem:</label>
						<input type="text" id="ordem" name="ordem" value="${evento.ordem }" />
					</div>				
				</div>
				<div class="form-col">
					<div class="form-group">
						<label for="situacao">Paramentros:</label>
						<input type="text" id="parametros" name="parametros" value="${evento.parametros }" />
					</div>
				</div>
				<div class="btn-group">
					<a href="${paginaEventos }"><button class="btn btn-cancel" type="button">Cancelar</button></a>
					<a><button class="btn btn-confirm">Salvar</button></a>
				</div>
			</form>

		</div>
	</div>
</body>
</html>