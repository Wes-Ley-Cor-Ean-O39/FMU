                 
                 <---- BANCO DE DADOS MYSQL ---->

create database FMU
use FMU

create table CadastroVeiculos (
id int not null auto_increment,
empresa varchar (100),
veiculo varchar (100), -- tipo = automóvel and motocicleta
modelo varchar (100),
placa varchar(100), --AAA-0000
motorista varchar (100),
constraint pk_CadastroVeiculos primary key (id)
);
 
INSERT INTO CadastroVeiculos(empresa, veiculo, modelo, placa, motorista)
VALUES ("Ford Motor Company","Automóvel","EcoSport 2019","AFD-4563","Jubileu Costa (TESTE)");
INSERT INTO CadastroVeiculos(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Audi","Automóvel","Audi A1 2018","FGE-9634","Jubiscleide Sena (TESTE)");
INSERT INTO CadastroVeiculos(empresa, veiculo, modelo, placa, motorista) 
VALUES ("BMW","Automóvel","BMW M3 2017","SMJ-9784","Irineu Costa (TESTE)");
INSERT INTO CadastroVeiculos(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chery","Automóvel","Chery QQ 2018","HYE-9832","Jubileia Santos (TESTE)");
