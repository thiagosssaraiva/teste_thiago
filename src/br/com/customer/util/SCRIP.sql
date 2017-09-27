create database thiago_testeBack

USE thiago_testeBack


CREATE TABLE tb_customer_account(
id_customer INTEGER AUTO_INCREMENT PRIMARY KEY ,
cpf_cnpj VARCHAR(18),
nm_customer VARCHAR(50),
is_active bit,
vl_total decimal(18,3))
