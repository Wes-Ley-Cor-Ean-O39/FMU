                 
                 <---- BANCO DE DADOS MYSQL ---->

create database Treinamento;
use Treinamento;

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
VALUES ("Ford Motor Company","Automóvel","EcoSport 2019","AFD-4563","Eduardo Silva");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Audi","Automóvel","Audi A1 2018","FGE-9634","Richard Costa");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("BMW","Automóvel","BMW M3 2017","SMJ-9784","Adam Smity");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chery","Automóvel","Chery QQ 2018","HYE-9832","Erick Jones");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista) 
VALUES ("Chevrolet","Automóvel","Cobalt 2018","SDS-3454","Kevin Hall");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Chevrolet","Automóvel","S10 2018","EHR-7846","Everton Carvalho");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Hyundai","Automóvel","HB20","LKI-3872","Wesley Azevedo");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Fod","Automóvel","Ka","KHD-7453","Mateus Cruz");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Renault","Automóvel","Sandero","FER-4643","Letícia Angel");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("Toyota","Automóvel","Etios hatch","JHS-9283","Marina Catarino");
INSERT INTO cadastro(empresa, veiculo, modelo, placa, motorista)
VALUES("VolksWagem","Automóvel", "Voyage", "KOS-5674","Raquel Oliveira");


+----+--------------------+-----------+---------------+----------+------------------+
| id | empresa            | veiculo   | modelo        | placa    | motorista        |
+----+--------------------+-----------+---------------+----------+------------------+
|  1 | Ford Motor Company | Automóvel | EcoSport 2019 | AFD-4563 | Eduardo Silva    |
|  2 | Audi               | Automóvel | Audi A1 2018  | FGE-9634 | Richard Costa    |
|  3 | BMW                | Automóvel | BMW M3 2017   | SMJ-9784 | Adam Smity       |
|  4 | Chery              | Automóvel | Chery QQ 2018 | HYE-9832 | Erick Jones      |
| 10 | Chevrolet          | Automóvel | Cobalt 2018   | SDS-3454 | Kevin Hall       |
| 11 | Hyundai            | Automóvel | HB20          | LKI-3872 | Wesley Azevedo   |
| 12 | Fod                | Automóvel | Ka            | KHD-7453 | Mateus Cruz      |
| 13 | Renault            | Automóvel | Sandero       | FER-4643 | Letícia Angel    |
| 14 | Toyota             | Automóvel | Etios hatch   | JHS-9283 | Marina Catarino  |
| 15 | Chevrolet          | Automóvel | S10 2018      | EHR-7846 | Everton Carvalho |
+----+--------------------+-----------+---------------+----------+------------------+