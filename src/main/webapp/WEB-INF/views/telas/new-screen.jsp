<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada?acao=Telas" var="paginaTelas"/>
<c:url value="entrada?acao=InserirTela" var="cadastrarTela" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="theme-color" content="#C4C4C4" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet" />

    <title>Cadastrar nova tela</title>

    <link rel="stylesheet" href="styles/main.css" />
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>

<body>
    
    <c:import url="/components/header.jsp" />
    
    <c:import url="/components/menuItens.jsp" />
    
    <div class="overlay">
        <form class="modal-box" method="POST" action="${cadastrarTela }">
            <a href="${paginaTelas }"><button class="btn-close"><span class="lnr lnr-cross"></span></button></a>
            <h1>Cadastrar nova tela</h1>
            <div class="form-col">
                <div class="form-row">
                    <div class="form-col">
                        <div class="form-group">
                            <label for="name">Nome da tela:</label>
                            <input type="text" id="name" name="nomeTela" />
                        </div>
                        <div class="form-group">
                            <label for="parent">Tela pai:</label>
                            <input type="text" id="parent" name="telaPai" />
                        </div>
                        <div class="form-group">
                            <label for="date">Data de lançamento:</label>
                            <input type="date" id="date" name="dataLancamento" />
                        </div>
                    </div>
                    <div class="form-col">
                        <div class="form-group">
                            <label for="version">Número da versão:</label>
                            <select class="input-drop" name="idVersao" id="version">
                                <c:forEach items="${versoes }" var="versao">
                                	<option value="${versao.id_versao }">${versao.numero_versao }</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="status">Estado:</label>
                            <select class="input-drop" name="situacao" id="status">
                                <option value="1">Ativo</option>
                                <option value="2">Inativo</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="hierarchy">Ordem na hierarquia:</label>
                            <input type="text" id="hierarchy" name="ordem" />
                        </div>
                        <div class="form-group">
                            <label for="log">URL Log:</label>
                            <input type="text" id="log" name="urlLog"/>
                        </div>
                    </div>
                </div>
                <div class="form-group upload">
                    <label class="upload" for="upload"><span class="lnr lnr-upload"></span></label>
                    <input type="file" id="upload" name="imagem" class="upload" />
                </div>
                <div class="btn-group">
                    <a href="${paginaTelas }"><button class="btn btn-cancel" type="button">Cancelar</button></a>
                    <a href="#"><button class="btn btn-confirm">Cadastrar</button></a>
                </div>
            </div>
        </form>
    </div>
</body>

</html>