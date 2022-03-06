# avaliacao2-pb
Avaliação do projeto de bolsa da Compass.Uol 2º sprint

Com a avaliação foram criados dois scripts de bancos de dados MySql,
para avaliação vou deixa-los aqui seguindo a orientação do instrutor.

Banco de dados exercicio 1

----------------------------------------------
CREATE DATABASE loja_Sprint2;                 
                                              
USE loja_sprint2;                            
                                              
CREATE TABLE PRODUTO (id INT AUTO_INCREMENT,  
nome VARCHAR(150), 
descricao VARCHAR(150), 
quantidade INT, 
preco FLOAT, 
PRIMARY KEY (id)) Engine = InnoDB;
                    
select * from produtos;
----------------------------------------------

Banco de dados exercicio 2

CREATE DATABASE lista_filmes;

USE lista_filmes;

CREATE TABLE filmes(
ID INT,
NOME VARCHAR(150), 
DESCRICAO VARCHAR(150),
ANO INT,
PRIMARY KEY(ID));
                    
select * from filmes;
----------------------------------------------
