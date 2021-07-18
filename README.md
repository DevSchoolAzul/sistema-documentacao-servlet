# sistema-documentacao-servlet

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
