mysql -u root -p

CREATE DATABASE escola CHARACTER SET latin1;

use escola;

CREATE TABLE alunos ( 
	id int AUTO_INCREMENT,
	ra char(10),
	nome varchar(100),
	nascimento date,
	primary key(id)
);

CREATE TABLE usuarios (
	id int AUTO_INCREMENT,
	nome char(25),
	senha varchar(50),
	primary key(id)
);