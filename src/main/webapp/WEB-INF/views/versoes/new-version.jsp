<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url />
<c:url />

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
      rel="stylesheet"
    />

    <title>Cadastrar nova versão</title>

    <link rel="stylesheet" href="styles/main.css" />
    <link
      rel="stylesheet"
      href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css"
    />
  </head>
  <body id="page-login">
    
    <c:import url="/components/header.jsp" />
    
    <div class="container">
      <div class="table">
        <div class="title-bar">
          <div class="title-content">
            <ul class="bd-group">
              <li><a href="index">Projetos</a></li>
              <li><a href="version">VersÃ£o</a></li>
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
            <c:forEach items="${versoes}" var="versao">
            	<a href="${linkTelas}&id_versao=${versao.id_versao}">
	            	<tr>
	            		<td>${versao.id_versao}</td>
	            		<td>${versao.data_lancamento}</td>
	            		<td>${versao.gmud}</td>
	            		<td>total de func</td>
	            		<td>
		                  <a href="${atualizarVersao }&id_versao=${versao.id_versao}"><span class="lnr lnr-pencil btn-manage"></span></a>
		                  <a href="${excluirVersao }&id_versao=${versao.id_versao}"><span class="lnr lnr-trash btn-manage"></span></a>
		                </td>
	            	<tr>
            	</a>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
    <div class="overlay">
        <div class="modal-box">
          <a href="version"><button class="btn-close"><span class="lnr lnr-cross"></span></button></a>
            <h1>Cadastrar nova versÃ£o</h1>
            <div class="form-col">
                <div class="form-row">
            <form class="form-col">
                <div class="form-group">
                    <label for="project">Projeto:</label>
                    <select class="input-drop" name="project" id="project">
                        <option value="">---</option>
                        <option value="1">Ativo</option>
                        <option value="2">Inativo</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="date">Data de lanÃ§amento:</label>
                    <input type="date" id="date"/>
                </div>
                <div class="form-group">
                    <label for="gmud">NÃºmero da GMUD:</label>
                    <input type="text" id="gmud"/>
                </div>
            </form>
            <form class="form-col">
                <div class="form-group">
                    <label for="version">NÃºmero da versÃ£o:</label>
                    <input type="text" id="version"/>
                </div>
                <div class="form-group">
                        <label for="clone">Clonar de outra versÃ£o: </label>
                        <select class="input-drop" name="clone" id="clone">
                            <option value="">---</option>
                            <option value="1">Ativo</option>
                            <option value="2">Inativo</option>
                        </select>
                </div>
                    <div class="form-group">
                        <label for="status">Estado:</label>
                        <select class="input-drop" name="status" id="status">
                            <option value="">---</option>
                            <option value="1">Ativo</option>
                            <option value="2">Inativo</option>
                        </select>
                    </div>
            </form>
            </div>
            <div class="form-group textarea">
                <label for="description">DescriÃ§Ã£o:</label>
                <textarea id="description"></textarea>
            </div>
            <div class="btn-group">
                <a href="version"><button class="btn btn-cancel">Cancelar</button></a>
                <a href="version"><button class="btn btn-confirm">Cadastrar</button><a>
            </div>
        </div>
    </div>
        </div>
    </div> 
  </body>
</html>