<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="entrada?acao=Telas" var="paginaTelas" />
<c:url value="entrada?acao=AlterarTela" var="alterarTela" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="theme-color" content="#C4C4C4" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet" />

    <title>Alterar tela</title>

    <link rel="stylesheet" href="styles/main.css" />
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css" />
</head>

<body id="page-login">
    
    <c:import url="/components/header.jsp" />
    
    <div class="overlay">
        <form class="modal-box" method="POST" action="${alterarTela }">
        	<input type="hidden" name="id_tela" value="${tela.idTela }" />
            <a href="${paginaTelas }"><button class="btn-close"><span class="lnr lnr-cross"></span></button></a>
            <h1>Alterar tela</h1>
            <h2>Tela</h2>
            <div class="form-col">
                <div class="form-row">
                    <div class="form-col">
                        <div class="form-group">
                            <label for="name">Nome da tela:</label>
                            <input type="text" id="name" name="nome" value="${tela.nomeTela }" />
                        </div>
                        <div class="form-group">
                            <label for="parent">Tela pai:</label>
                            <input type="text" id="parent" name="telaPai" value="${tela.telaPai }"/>
                        </div>
                        <div class="form-group">
                            <label for="date">Data de cadastro:</label>
                            <input type="date" id="date" name="dataCadastro" value="${tela.dataCadastro }"/>
                        </div>
                    </div>
                    <div class="form-col">
                        <div class="form-group">
                            <label for="status">Estado:</label>
                            <select class="input-drop" name="situacao" id="status">
                                <option value="1" ${tela.situacao eq true ? 'selected' : '' }>Ativo</option>
                                <option value="2" ${tela.situacao eq false ? 'selected' : '' }>Inativo</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="hierarchy">Ordem na hierarquia:</label>
                            <input type="text" id="hierarchy" name="ordem" value="${tela.ordem }" />
                        </div>
                        <div class="form-group">
                            <label for="log">URL Log:</label>
                            <input type="text" id="log" name="urlLog" value="${tela.urlLog }" />
                        </div>
                    </div>
                </div>
                <div class="form-group upload">
                    <input type="file" name="imagem" id="file" class="upload" />
                    <label class=" upload" for="file"><span class="lnr lnr-upload"></span></label>
                </div>
                <div class="btn-group">
                    <a href="${paginaTelas }"><button class="btn btn-cancel" type="buttom">Cancelar</button></a>
                    <a href="#"><button class="btn btn-confirm">Salvar</button><a>
                </div>
            </div>
        </form>
    </div>
    </div>
</body>

</html>