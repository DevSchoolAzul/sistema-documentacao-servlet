<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada?acao=Requisicoes" var="paginaRequisicoes" />
<c:url value="entrada?acao=AlterarRequisicao" var="atualizar" />

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

    <title>Alterar versÃ£o do projeto</title>

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
                <th>NÃºmero</th>
                <th>Data de lanÃ§amento</th>
                <th>NÃºmero do GMUD</th>
                <th>Total Func.</th>
                <th>AÃ§Ãµes</th>
              </tr>
            </thead>
            <tbody class="list-body">
              <tr>
                <td><a href="screen">#1</a></td>
                <td><a href="screen">23/03/2019</a></td>
                <td><a href="screen">12345</a></td>
                <td><a href="screen">10</a></td>
                <td>
                  <a href="update-version"><span class="lnr lnr-pencil btn-manage"></span></a>
                  <a href="confirm-delete-version"><span class="lnr lnr-trash btn-manage"></span></a>
                </td>
              </tr>
              <tr>
                <td><a href="screen">#2</a></td>
                <td><a href="screen">28/03/2019</a></td>
                <td><a href="screen">12346</a></td>
                <td><a href="screen">13</a></td>
                <td>
                  <a href="update-version"><span class="lnr lnr-pencil btn-manage"></span></a>
                  <a href="confirm-delete-version"><span class="lnr lnr-trash btn-manage"></span></a>
                </td>
              </tr>
              <tr>
                <td><a href="screen">#3</a></td>
                <td><a href="screen">05/04/2019</a></td>
                <td><a href="screen">12347</a></td>
                <td><a href="screen">18</a></td>
                <td>
                  <a href="update-version"><span class="lnr lnr-pencil btn-manage"></span></a>
                  <a href="confirm-delete-version"><span class="lnr lnr-trash btn-manage"></span></a>
                </td>
              </tr>
              <tr>
                <td><a href="screen">#4</a></td>
                <td><a href="screen">11/12/2019</a></td>
                <td><a href="screen">12348</a></td>
                <td><a href="screen">24</a></td>
                <td>
                  <a href="update-version"><span class="lnr lnr-pencil btn-manage"></span></a>
                  <a href="confirm-delete-version"><span class="lnr lnr-trash btn-manage"></span></a>
                </td>
              </tr>
              <tr>
                <td><a href="screen">#5</a></td>
                <td><a href="screen">01/02/2020</a></td>
                <td><a href="screen">12349</a></td>
                <td><a href="screen">30</a></td>
                <td>
                  <a href="update-version"><span class="lnr lnr-pencil btn-manage"></span></a>
                  <a href="confirm-delete-version"><span class="lnr lnr-trash btn-manage"></span></a>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    
    
    
    <div class="overlay">
        <div class="modal-box">
          <a href="${paginaRequisicoes }"><button class="btn-close"><span class="lnr lnr-cross"></span></button></a>
            <h1>Alterar Requisição</h1>
            
            <form class="form-col" action="${atualizar}" method="POST">
            	<input type="hidden" value="${requisicao.id_requisicao }" name="id_requisicao"/>
                <div class="form-row">
                    <div class="form-col">
                    
                        <div class="form-group">
                            <label for="version">URL homolog</label>
                            <input type="text" name="url_homolog" id="url_homolog" value="${requisicao.url_homolog}"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="gmud">URL prod</label>
                            <input type="text" name="uri_prod" id="uri_prod" value="${requisicao.uri_prod }"/>
                        </div>
                        <div class="form-group">
                            <label for="date">Requisição pai:</label>
                            <input type="text" name="requisicao_pai" id="requisicao_pai" value="${requisicao.requisicao_pai }"/>
                        </div>
                    </div>
                    <div class="form-col">
                    	<div class="form-group">
                            <label for="date">Camada:</label>
                            <input type="text" name="camada" id="camada" value="${requisicao.camada }"/>
                        </div>
                        
                        <div class="form-group">
                            <label for="date">Ordem:</label>
                            <input type="text" name="ordem" id="ordem" value="${requisicao.ordem }"/>
                        </div>
                    
                        <div class="form-group">
                            <label for="status">Situacão:</label>
                            <select class="input-drop" name="situacao" id="status">
                            	<c:if test="${requisicao.situacao == true }">
 	                            	<option value="1" selected>Ativo</option>
    	                        	<option value="2">Inativo</option>
    	                        </c:if>
    	                        <c:if test="${requisicao.situacao == false }">
 	                            	<option value="1">Ativo</option>
    	                        	<option value="2" selected>Inativo</option>
    	                        </c:if>
                            </select>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group textarea">
                    <label for="description">Descrição:</label>
                    <textarea id="description" name="descricao">${requisicao.descricao}</textarea>
                </div>
                <div class="btn-group">
                    <a href="${paginaRequisicoes }"><button class="btn btn-cancel" type="button">Cancelar</button></a>
                    <a><button class="btn btn-confirm">Salvar</button></a>
                </div>
            </form>
        </div>
    </div>
    
    
    
  </body>
</html>