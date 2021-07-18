<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada?acao=Projetos" var="paginaProjetos" />
<c:url value="entrada?acao=InserirProjeto" var="inserirProjeto" />
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

    <title>Adicionar projeto</title>

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
            </ul>
          </div>
          <div class="title-content">
            <div class="flex">
              <div class="search-box">
                <input type="text" />
                <button type="submit"><span class="lnr lnr-magnifier"></span></button>
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
       
       
       <c:import url="/components/camposFake.jsp" />
       
       
      </div>
    </div>
    <div class="overlay">
        <div class="modal-box">
          <a href="${paginaProjetos}"><button class="btn-close"><span class="lnr lnr-cross"></span></button></a>
            <h1>Cadastrar novo projeto</h1>
            <form class="form-col" method="POST" action="${inserirProjeto }">
                <div class="form-group">
                    <label for="name">Nome: </label>
                    <input type="text" id="name" name="nome"/>
                </div>
                <div class="form-group">
                    <label for="status">Estado: </label>
                    <select class="input-drop" name="situacao" id="status">
                        <option value="1" selected>Ativo</option>
                        <option value="0">Inativo</option>
                    </select>
                </div>
                <div class="btn-group">
                    <a href="${paginaProjetos }"><button class="btn btn-cancel" type="button">Cancelar</button></a>
                    <a href="${paginaProjetos }"><button class="btn btn-confirm">Cadastrar</button></a>
                </div>
              </form>
        </div>
    </div> 
  </body>
</html>