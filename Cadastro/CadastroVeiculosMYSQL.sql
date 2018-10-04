                 
                 <---- BANCO DE DADOS MYSQL ---->

create database Treinamento
use Treinamento

create table cadastro (
id int not null auto_increment,
empresa varchar (100),
veiculo varchar (100), 
modelo varchar (100),
placa varchar(100), 
motorista varchar (100),
constraint pk_CadastroVeiculos primary key (id)
);
 
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES ("Ford Motor Company","Autom�vel","EcoSport 2019","AFD-4563","Jubileu Costa (TESTE)");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Audi","Autom�vel","Audi A1 2018","FGE-9634","Jubiscleide Sena (TESTE)");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("BMW","Autom�vel","BMW M3 2017","SMJ-9784","Irineu Costa (TESTE)");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chery","Autom�vel","Chery QQ 2018","HYE-9832","Jubileia Santos (TESTE)");
