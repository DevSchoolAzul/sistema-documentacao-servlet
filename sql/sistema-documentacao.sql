/* 
 * ALTERAÇÕES EM RELAÇÃO À MODELAGEM DE DADOS:
 *  - TODOS OS VARCHAR ESTÃO COM TAMANHO 255;
 *  - VERSAO.NUMERO_VERSAO ALTERADO DE FLOAT PARA VARCHAR;
 *  - TELA.IMAGEM ALTERADO DE OTHER PARA VARCHAR;
 *  - TIPO_EVENTO.ORDEM ESTÁ, ERRONEAMENTE, COMO BOOLEAN. AQUI ALTEREI PARA INTEGER
*/


create database if not exists sistema_documentacao;
use sistema_documentacao;

create table if not exists usuario (
id_usuario integer not null auto_increment,
nome varchar(255) not null,
email varchar(255) not null,
senha varchar(255) not null,
primary key (id_usuario)
);

create table if not exists projeto (
id_projeto integer not null auto_increment,
nome varchar(255) not null,
situacao boolean not null,
primary key(id_projeto)
);

create table if not exists versao (
id_versao integer not null auto_increment,
id_projeto integer not null,
gmud varchar(255) not null,
descricao varchar(255) not null,
data_lancamento date not null,
situacao boolean not null,
ordem integer not null,
numero_versao varchar(255),
primary key (id_versao)
);

create table if not exists tela (
id_tela integer not null auto_increment,
id_versao integer not null,
data_cadastro date not null,
nome_tela varchar(255) not null,
imagem varchar(255) not null,
situacao boolean not null,
tela_pai integer null,
ordem integer not null,
url_log varchar(255) not null,
versao_origem integer not null,
primary key(id_tela)
);

create table if not exists evento (
id_evento integer not null auto_increment,
id_tipo_evento integer not null,
id_tela integer not null,
situacao boolean not null,
ordem integer not null,
parametros varchar(255) not null,
primary key (id_evento)
);

create table if not exists tipo_evento (
id_tipo_evento integer not null auto_increment,
nome varchar(255) not null,
situacao boolean not null,
ordem integer not null,
primary key(id_tipo_evento)
);

create table if not exists requisicao (
id_requisicao integer not null auto_increment,
id_evento integer not null,
url_homolog varchar(255) not null,
uri_prod varchar(255) not null,
descricao varchar(255) not null,
requisicao_pai integer null,
camada varchar(255) not null,
situacao boolean not null,
ordem integer not null,
primary key(id_requisicao)
);

create table if not exists propriedade (
id_propriedade integer not null,
id_requisicao integer not null,
tipo_propriedade varchar(255) not null,
chave varchar(255) not null,
valor varchar(255) not null,
ordem integer not null,
primary key (id_propriedade)
);

alter table versao add constraint fk_versao_projeto_id_projeto foreign key (id_projeto) references projeto(id_projeto);
alter table tela add constraint fk_tela_versao_id_versao foreign key (id_versao) references versao(id_versao);
alter table tela add constraint fk_tela_versao_versao_origem foreign key (versao_origem) references versao(id_versao);
alter table tela add constraint fk_tela_tela_tela_pai foreign key (tela_pai) references tela(id_tela);
alter table evento add constraint fk_evento_tela_id_tela foreign key (id_tela) references tela(id_tela);
alter table evento add constraint fk_evento_tipo_evento_id_tipo_evento foreign key (id_tipo_evento) references tipo_evento(id_tipo_evento);
alter table requisicao add constraint fk_requisicao_evento_id_evento foreign key (id_evento) references evento(id_evento);
alter table propriedade add constraint fk_propriedade_requisicao_id_requisicao foreign key (id_requisicao) references requisicao(id_requisicao);
