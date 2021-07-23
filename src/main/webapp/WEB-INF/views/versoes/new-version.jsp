<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada?acao=Versoes&id_projeto=${projeto.id_projeto }" var="paginaVersoes"/>
<c:url value="entrada?acao=InserirVersao" var="cadastrarVersao"/>

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
           
          </table>
        </div>
      </div>
    </div>
    
    
    <div class="overlay">
        <form class="modal-box" action="${cadastrarVersao }" method="POST">
        	<a href="${paginaVersoes }"><button class="btn-close" type="button"><span class="lnr lnr-cross"></span></button></a>
        	<h1>Cadastrar nova versÃ£o</h1>
            <div class="form-col">
                <div class="form-row">
            		<div class="form-col">
                		<div class="form-group">
           			        <label for="project">Projeto:</label>
                    		<select class="input-drop" name="id_projeto" id="project">
                        		<c:forEach items="${projetos}" var="projeto">
                        		<option value="${projeto.id_projeto }">${projeto.nome }</option>
                      			</c:forEach>
                    		</select>
                		</div>
                		<div class="form-group">
                    		<label for="date">Data de lançamento:</label>
                    		<input type="date" id="date" name="data_lancamento"/>
                		</div>
                		<div class="form-group">
		                    <label for="gmud">Número da GMUD:</label>
		                    <input type="text" id="gmud" name="gmud"/>
		                </div>
		            </div>
	           		<div class="form-col">
	                	<div class="form-group">
		                    <label for="version">Número da versÃ£o:</label>
		                    <input type="text" id="version" name="numero_versao"/>
	                	</div>
	                	<div class="form-group">
	                        <label for="clone">Clonar de outra versÃ£o: </label>
	                        <select class="input-drop" name="id_clone" id="clone">
	                        <c:forEach items="${versoes}" var="versao"></c:forEach>
	                            <option value="${versao.id_versao }">${versao.numero_versao }</option>
	                        </select>
	                	</div>
	                    <div class="form-group">
	                        <label for="status">Estado:</label>
	                        <select class="input-drop" name="situacao" id="status">
	                            <option value="1">Ativo</option>
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
	                <a href="${paginaVersoes }"><button class="btn btn-cancel" type="button">Cancelar</button></a>
	                <a><button class="btn btn-confirm">Cadastrar</button></a>
	            </div>
            </div>
   		</form>    
    
    
    
        </div>
    </div> 
  </body>
</html>