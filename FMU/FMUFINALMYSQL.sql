
                                     

                                     <<--BANCO DE DADOS : MYSQL>> 


CREATE TABLE `escola` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("EMEF Lênio Vieira de Moraes","Via Tabajara","Barueri","Jardim Tupã","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade Estadual de Campinas","Av. Paulista","Campinas","São Bento","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("FMU COMPLEXO EDUCACIONAL","Av. Brigadeiro","Liberdade","Boa Vista","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade de São Paulo","Rua Luiz Antonio","Osasco","Jardim Lima","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("UNIP","Alameda Mamore","Barueri","Alphaville","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade Federal do ABC (UFABC)","Av. Sumaré","ABC","Jardim Ângela","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade de Brasília","Via Consolação","Brasília","Jardins","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade Presbiteriana Mackenzie","Alameda Tucunaré","Barueri","Alphaville","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade Nove de Julho","Av. Jardins","São Paulo","Barra Funda","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("Universidade Estadual de São Paulo","Av. Nove de Julho","São Paulo","Bela Vista","São Paulo");
INSERT INTO Escola (nome, endereco, cidade, bairro, estado) VALUES("UNIFESP","Via Sena","Pirituba","Jardins","São Paulo");
