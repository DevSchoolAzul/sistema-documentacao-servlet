<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value="/entrada" var="linkLogin"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="theme-color" content="#C4C4C4" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap"
      rel="stylesheet"
    />

    <title>Login</title>

    <link rel="stylesheet" href="styles/main.css" />
    <link
      rel="stylesheet"
      href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css"
    />
  </head>
  <body>
    <div id="container">
      <header class="header-box">
        <div class="logo-box">
          <a href="index"><img src="public/mobicare-akross-logo.svg" /></a>
        </div>
      </header>
    </div>
    <form class="auth" action="${linkLogin}" method="POST">
      <div class="auth-box">
        <h1>Login</h1>
        <div class="form-group">
          <label for="email">Email: </label>
          <input
            type="email"
            name="email"
            id="email"
            placeholder="example@gmail.com"
          />
        </div>
        <div class="form-group">
          <label for="senha">Senha: </label>
          <input
            type="password"
            name="senha"
            id="senha"
            placeholder="********"
          />
        </div>
        <a href="recover" class="forgot">Esqueceu a senha?</a>
        <input type="hidden" name="acao" value="Login"/>	
        <div class="btn-group">
          <input type="submit" class="btn btn-confirm btn-double">
        </div>
      </div>
    </form>
  </body>
</html>
