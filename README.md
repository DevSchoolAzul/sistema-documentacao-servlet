# sistema-documentacao-servlet

## Estrutura do projeto

### Pacotes de java:

<details>
  <summary>Acao</summary>
  Neste pacote é onde estará o codigo que servlet deverá executar.
    
  Normalmente terá, para cada recurso(projeto, versao, tela...), as seguintes ações: 
  - Listar
  - Exibir formulário de cadastrar novo recurso
  - Cadastrar o novo recurso
  - Exibir o formulario de alterar o recurso
  - Alterar o recurso
  - Excluir
</details>

<details>
<summary>Modelo</summary>
  
  Neste pacote estarão as classe de modelo usadas para interagir com o banco de dados.

  Elas representam as tabelas do banco de dados.
  
  Seus atributos representam as colunas da tabela.
</details>

<details>
<summary>DAO</summary>

  É a classe que contem a lógica para interagir com o banco de dados.

  Nela que está escrito os codigos SQL para fazer os CRUDs.
</details>

<details>
<summary>Connection</summary>

  Neste pacote está a classe ConnectionFactory que é responsavel por gerar conexões com o banco de dados e fornece-las para as classes do sistema que as pedem.
</details>

<details>
<summary>Servlet</summary>

  Neste projeto, todo o acesso do usuário aos recursos do sistema está sendo feito por uma única entrada que está sendo mapeada para `/entrada`. 

  **Servlet** é um objeto especial armazenado dentro do projeto, e sua particularidade consiste na possibilidade de o chamarmos via protocolo HTTP.

  O servlet consegue identificar o recurso que o usuario deseja acessar através de parâmetros que são passados juntos na URL. Isso é possivel pois o servlet está usando Reflection.

  O **Reflection**, em poucas palavras, serve para determinar métodos e atributos que serão utilizados de determinada classe (que você nem conhece) em tempo de execução. [saiba mais](https://www.devmedia.com.br/conhecendo-java-reflection/29148)
</details>

### Pacotes de web:

<details>
<summary>Components</summary>

  Estão codigos HTML que se repetem em varias paginas

  São importados pelas paginas que o necessitam através da tag do JSTL `<c:import url="nome do component" />`
</details>

<details>
<summary>Public</summary>

  Onde estão as imagens para o site
</details>
  
<details>
<summary>Styles</summary>

  Onde está o CSS
</details>

<details>
  <summary>Web-inf</summary>

  Onde está a pasta views com os JSPs e o arquivo web.xml
  <details>
    <summary>views</summary>

  Tem as paginas JSP para cada recurso do sistema:
  - projetos
  - telas
  - versões
  - Tipo de evento
  - Evento
  - Requisição
  - Propriedades de Requisição
  </details>
  
</details>

## Como utilizar o docker do MySQL no projeto

### Subindo o container: 

o primeiro passo que deve fazer é estar no working directory do projeto, todo o processo descrito aqui estará no working directory. Então execute o comando 
```
docker-compose up -d
```

o container deve subir neste momento.

para conferir se o container realmente subiu, execute:
``` 
docker ps
```

Uma saída semelhante a esta deverá aparecer. o container que usaremos está nomeado como **mysqlsd**

```
CONTAINER ID   IMAGE     COMMAND                  CREATED          STATUS         PORTS                                                  NAMES
6edc2854bb29   mysql     "docker-entrypoint.s…"   27 seconds ago   Up 8 seconds   33060/tcp, 0.0.0.0:3307->3306/tcp, :::3307->3306/tcp   mysqlsd
```

Com isso agora temos um MySQL rodando em um container, no entanto, ainda não temos as tabelas que precisaremos para o nosso projeto, os proximos passos serão de como resolver isso.

### Criando o database:

No nosso diretorio do projeto temos a pasta sql/ e dentro dela um arquivo chamado sistema-documentacao.sql . O que queremos fazer é passar ele pra dentro do container e fazer o MySQL executa-lo.

Para passar o arquivo para o container, execute:

```
docker cp sql/sistema-documentacao mysqlsd:/
```

Então você entrará no container através do comando:
```
docker exec -it mysqlsd bash
```

agora, voce pode fazer o MySQL executar o .sql com o comando:
```
mysql -u root -p < sistema-documentacao.sql
```
Entao digite a senha : `password`


Esse processo pode demorar alguns segundos mas após concluido ele ira mostrar novamente o cursor do shell e não irá mostrar nenhuma mensagem de confimação. Neste momento você pode sair do container digitando `exit` ou pressionando `crtl + d`. caso queira conferir se a Database foi realmente criada, execute, ainda dentro do container, o comando:
```
mysql -u root -p
```
Digite a senha: `password`

Você estará na linha de comando do MySQL e entao digite:
```
show databases;
```
Com isso, deverá ser exibido:
```
+----------------------+
| Database             |
+----------------------+
| information_schema   |
| mysql                |
| performance_schema   |
| sistema_documentacao | <- aqui está a nossa Database
| sys                  |
+----------------------+
```

Com a database criada, você já pode sair do container.

Esse passo de criar a Database só é priciso ser feito 1 vez.

Com a database criada e o container rodando basta agora rodar o projeto no tomcat.
