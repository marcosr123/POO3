create table usuariosFunc(
id_user serial not null primary key,
loginF varchar(20) not null,
senhaF varchar(20) not null,
funcaoF varchar (10) not null
);
CREATE TABLE cadas_func (
id serial NOT NULL,
nome varchar(50) NOT NULL,
cpf varchar(20) not null,
nascimento varchar(13) not null,
sexo varchar(9) not null,
email varchar(30) not null,
telefone varchar(20) not null,
celular varchar(20) not null,
funcao varchar(10) not null,
banco varchar(10) not null,
agencia int not null,
conta int not null,

PRIMARY KEY (id));
 create table cadas_cliente(
 id serial not null,
 nome varchar(50) not null,
 cpf varchar(20) not null,
 nascimento varchar(13) not null,
 sexo varchar(9) not null,
 funcao varchar(10) not null,
 email varchar(30) not null,
 telefone varchar(20) not null,
 celular varchar(20) not null,
 
 primary key(id));
 create table cadas_livro(
 id_livro int not null primary key auto_increment,
 exemplar varchar(100) not null,
 autor varchar(100) not null,
 edicao tinyint(3) not null,
 ano smallint(6) not null,
 disponibilidade char(1)
 );
create table multa(
 id_multa int not null primary key auto_increment,
 id_cliente int(10) not null,
 descricao varchar(60) not null,
 valor decimal(6,2) not null
 );
 create table emprestimo(
  id_emprestimo int not null primary key auto_increment,
  id_cliente int(10) not null,
  id_livro int(10) not null,
  data_emprestimo date not null,
  data_devolucao date not null
  );
  