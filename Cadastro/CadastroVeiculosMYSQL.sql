                 
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
VALUES ("Ford Motor Company","Autom�vel","EcoSport 2019","AFD-4563","Eduardo Silva");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Audi","Autom�vel","Audi A1 2018","FGE-9634","Richard Costa");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("BMW","Autom�vel","BMW M3 2017","SMJ-9784","Adam Smity");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chery","Autom�vel","Chery QQ 2018","HYE-9832","Erick Jones");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chevrolet","Autom�vel","Cobalt 2018","SDS-3454","Kevin Hall");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Chevrolet","Autom�vel","S10 2018","EHR-7846","Everton Carvalho");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Hyundai","Autom�vel","HB20","LKI-3872","Wesley Azevedo");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Fod","Autom�vel","Ka","KHD-7453","Mateus Cruz");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Renault","Autom�vel","Sandero","FER-4643","Let�cia Angel");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Toyota","Autom�vel","Etios hatch","JHS-9283","Marina Catarino");