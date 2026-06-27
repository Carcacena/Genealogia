INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(1,'Francisco José Alves (1886/1936) / Antonia Francisca Gouvea (1899/1998)', null, 'Nota de Francisco e Antonia');

-- Filhos de Francisco e Antonia- sub raiz 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(2,'João Alves Gouvêa', 1, ''),
(3,'Francisco Alves Gouvea / Julita', 1, ''),
(4,'Júlia Alves Lemos / Antonio Alves Lemos', 1, ''),
(5,'Jonas Alves Gouvea / Alceir', 1, ''),
(6,'Maria Nazareth Gouvêa de Paula / Aldemiro F. de Paula', 1, ''),
(7,'Alberto Alves Gouvea / Joselia', 1, ''),
(8,'Izidoro Alves Gouvea / Elza', 1, ''),
(9,'Terezinha Alves Gouvea / Elmo Justus', 1, ''),
(10,'Manoel Carroceiro (enteado)', 1, ''),
(11,'Sebastião Guarda (enteado)', 1, ''),
(12,'Maria Malta (enteado)', 1, ''),
(13,'Não identificados', 1, '');

-- Filhos de Júlia Alves Lemos / Antonio Alves Lemos 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(14,'Maria Amelia Alves Lemos / Walter', 4, ''),
(15,'Arlene Alves Lemos / Lauriano', 4, ''),
(16,'José Alves Lemos / **********', 4, ''),
(17,'Sergio Alves Lemos', 4, ''),
(18,'Jonas Antonio Alves Lemos ', 4, ''),
(19,'Sebastião Alves Lemos', 4, '');

-- Filhos de Maria Nazareth / Aldemiro 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(20,'Antonio Gouvea de Paula / Heloisa', 6, ''),
(21,'Maria das Graças Gouvea de Paula / Lauro', 6, ''),
(22,'Pedro Paulo Gouvêa de Paula / Vania', 6, ''),
(23,'Jose Gouvea de Paula / Darci', 6,''),
(24,'Maria Inês Gouvea de Paula / Edivanildo', 6,''),
(25,'Claver Gouvea de Paula / *********', 6, ''),
(26,'Franceni Gouvea de Paula', 6, ''),
(27,'Jorge Gouvea de Paula / Clarice', 6, ''),
(28,'Magno Gouvêa de Paula / Regineli', 6, '');

-- Filhos de Manoel Carroceiro
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(29,'Mirtes', 10, ''),
(30,'Manoel', 10, '');

-- Filhos de Sebastião Guarda
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(31,'Francesvalde', 11, '');

-- Filhos de Francisco Alves Gouvea / Julita 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(32,'Ideliz', 3, ''),
(33,'Vantuil Alves Peçanhastião', 3, ''),
(34,'Marli', 3, ''),
(35,'Neusa', 3, ''),
(36,'Celia', 3, ''),
(37,'Francisco', 3, '');

-- Filhos de Izidoro Alves Gouvea / Elza  
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(38,'Rita de Cassia Alves Lemos', 8, ''),
(39,'Aparecida', 8, ''),
(40,'Antonia Márcia', 8, ''),
(41,'Francisco José', 8, '');

-- Filhos de Terezinha / Elmo
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(42,'Ismael', 9, ''),
(43,'Telmo Alves Justus / Lucia', 9, ''),
(44,'Jalouse', 9, ''),
(45,'Angelica', 9, ''),
(46,'Zilma', 9, ''),
(47,'Alan', 9, '');

-- Filhos de Alberto Alves Gouvea / Joselia 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(48,'Carlos Alberto Alves Closato', 7, ''),
(49,'Rosania', 7, ''),
(50,'Joana Darc', 7, ''),
(51,'Vilmar', 7, ''),
(52,'Denilson', 7, ''),
(53,'Flavio', 7, '');


-- Filhos de Jonas Alves Gouvea e Alceir
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(54,'jonas', 5, ''),
(55,'Antonio', 5, ''),
(56,'Sandra', 5, '');


-- Bisnetos (G4)
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(57,'Renata da Costa de Paula', 23, ''),
(58,'Thais da Costa de Paula', 23, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(59,'Keyla Alves de Moraes', 21, ''),
(60,'Alex Alves de Moraes', 21, ''),
(61,'Kelly Alves de Moraes', 21, '');


INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(62,'Vivianne Gouvea', 22, ''),
(63,'Pedro Gouvea', 22, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(64,'Aline', 20, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(65,'Felipe de Paula', 24, ''),
(66,'Maira', 24, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(67,'Ramon', 27, ''),
(68,'Bruno', 27, '');

-- Tataranetos (G5)
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(69,'Kael', 61, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(70,'Marieli', 28, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(71,'Manoelzinho', 30, '');



-- Filhos de "Não identificado" 
INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(72,'Job', 13, ''),

(73,'Irene', 13, ''),
(74,'Walter', 13, ''),

(75,'Enoc', 13, ''),

(76,'Elias', 13, ''),
(77,'Josias', 13, ''),
(78,'Sônia', 13, ''),
(79,'Laureci', 13, ''),
(80,'Maria Laura', 13, '');

INSERT INTO pessoa (id, nome, nome_id, nota) VALUES
(81,'', 13, '');


