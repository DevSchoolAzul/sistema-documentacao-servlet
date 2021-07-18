<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <title>Telas</title>

    <link rel="stylesheet" href="styles/main.css" />
    <link rel="stylesheet" href="./styles/pages/screen.css" />
    <link
      rel="stylesheet"
      href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css"
    />
  </head>

  <body>
    <div id="container">
      
      <c:import url="/components/header.jsp" />
      
      <div class="container">
        <div class="table">
          <div class="title-bar">
            <div class="title-content">
              <ul class="bd-group">
                <li><a href="index">Projetos</a></li>
                <li><a href="version">Versões</a></li>
                <li><a href="screen">Telas</a></li>
              </ul>
              <a href="new-screen">
                <button class="btn btn-create">
                  <span class="lnr lnr-file-add"></span>Cadastro
                </button>
              </a>
            </div>
          </div>
          <div class="screen">
            <div class="tree">
              <ul>
                <li>
                  <a href="#"><img src="http://lorempixel.com/output/food-h-c-140-270-9.jpg"></a>
                  <ul>
                    <li>
                      <a href="#"><img src="http://lorempixel.com/output/animals-h-c-140-270-5.jpg"></a>
                      <ul>
                        <li>
                          <a href="#"><img src="http://lorempixel.com/output/food-h-c-140-270-6.jpg"></a>
                          <ul>
                            <li>
                              <a href="#"><img src="http://lorempixel.com/output/animals-h-c-140-270-4.jpg"></a>
                              <ul>
                                <li>
                                  <a href="#"><img src="http://lorempixel.com/output/animals-h-c-140-270-2.jpg"></a>
                                </li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                        <li>
                          <a href="#"><img src="http://lorempixel.com/output/food-h-c-140-270-3.jpg"></a>
                        </li>
                      </ul>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
            <div class="details">
              <div class="subject">
                <p>Projeto: Minha Oi</p>
                <p>Versão: 1.0.0</p>
              </div>
              <div class="info">
                <div>
                  <img src="http://lorempixel.com/output/animals-h-c-140-270-5.jpg">
                </div>
                <div class="screen-wrapper">
                  <div class="screen-info">
                    <div class="screen-info-items">
                      <p>ID da funcionalidade</p>
                      <p>3</p>
                    </div>
                    <div class="screen-info-items">
                      <p>Nome da funcionalidade</p>
                      <p>Pós-Login</p>
                    </div>
                    <div class="screen-info-items">
                      <p>Versão da funcionalidade</p>
                      <p>1.0.0</p>
                    </div>
                    <div class="screen-info-items">
                      <p>Ordem na hierarquia</p>
                      <p>10</p>
                    </div>
                    <div class="screen-info-items">
                      <p>Link do Log</p>
                      <p><a href="https://pt.wikipedia.org/wiki/Log_de_dados">LOG da funcionalidade</a></p>
                    </div>
                  
                  </div>
                  <table>
                    <caption>Eventos</caption>
                  <tr>
                    <td colspan="3">
                      <ul>
                        <li>Evento: OnClick</li>
                        <li>Parametros: Email e senha</li>
                      </ul>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      API Gateway
                    </td>
                    <td colspan="2">
                      Barramento Oi
                    </td>
                  </tr>
                  <tr>
                    <td rowspan="3">
                      /rest/minhaoi/4/config
                    </td>
                    <td>
                      Requisição
                    </td>
                    <td>
                      Propriedades
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <ul>
                        <li>URI Homelog http://.com</li>
                        <li>URI Prod http://.com</li>
                        <li>Descrição: Serviço</li>
                      </ul>
                    </td>
                    <td>
                      <ul>
                        <li>Cache: Sim</li>
                        <li>TTL: 1000 segundos</li>
                        <li>Possui Redis: Não</li>
                        <li>Possui Circuit Break: Sim</li>
                      </ul>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <ul>
                        <li>URI Homelog http://.com</li>
                        <li>URI Prod http://.com</li>
                        <li>Descrição: Serviço</li>
                      </ul>
                    </td>
                    <td>
                      <ul>
                        <li>Cache: Sim</li>
                        <li>TTL: 1000 segundos</li>
                        <li>Possui Redis: Não</li>
                        <li>Possui Circuit Break: Sim</li>
                      </ul>
                    </td>
                  </tr>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
