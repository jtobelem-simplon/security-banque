CREATE TABLE `compte` (
  `NUMEROCOMPTE` int(5) NOT NULL,
  `CODETYPECOMPTE` char(1) NOT NULL,
  `CODETITULAIRE` int(4) NOT NULL,
  `SOLDECOMPTE` float(10,2) NOT NULL,
  PRIMARY KEY (`NUMEROCOMPTE`),
  KEY `I_FK_COMPTE_TYPECOMPTE` (`CODETYPECOMPTE`),
  KEY `I_FK_COMPTE_TITULAIRE` (`CODETITULAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `compte` (`NUMEROCOMPTE`, `CODETYPECOMPTE`, `CODETITULAIRE`, `SOLDECOMPTE`) VALUES
(10000, 'C', 1000, 3500.00),
(10001, 'C', 1001, 7000.00),
(10002, 'C', 1002, 2800.00),
(10003, 'C', 1003, 15200.00),
(10005, 'C', 1004, 60000.00),
(10006, 'C', 1005, 140000.00);

CREATE TABLE `operations` (
  `NUMEROOPERATION` int(11) NOT NULL AUTO_INCREMENT,
  `NUMEROCOMPTE` int(5) NOT NULL,
  `DATEOPERATION` date NOT NULL,
  `LIBELLEOPERATION` varchar(32) NOT NULL,
  `MONTANT` float(10,2) NOT NULL,
  `TYPEOPERATION` char(1) NOT NULL,
  PRIMARY KEY (`NUMEROOPERATION`),
  KEY `I_FK_OPERATIONS_COMPTE` (`NUMEROCOMPTE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `operations` (`NUMEROOPERATION`, `NUMEROCOMPTE`, `DATEOPERATION`, `LIBELLEOPERATION`, `MONTANT`, `TYPEOPERATION`) VALUES
(1, 10000, '2018-10-01', 'Dépôt', 3500.00, '+'),
(2, 10001, '2018-10-18', 'Dépôt', 7000.00, '+'),
(3, 10002, '2018-11-02', 'Dépôt', 2800.00, '+'),
(4, 10003, '2018-10-09', 'Dépôt ', 15200.00, '+'),
(5, 10005, '2018-12-19', 'Dépôt', 150.00, '+'),
(6, 10006, '2018-12-19', 'Dépôt', 507.00, '+');


CREATE TABLE `titulaire` (
  `CODETITULAIRE` int(4) NOT NULL,
  `PRENOMTITULAIRE` varchar(32) NOT NULL,
  `NOMTITULAIRE` varchar(32) NOT NULL,
  `ADRESSETITULAIRE` varchar(32) DEFAULT NULL,
  `CODEPOSTALTITULAIRE` char(5) DEFAULT NULL,
  PRIMARY KEY (`CODETITULAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `titulaire` (`CODETITULAIRE`, `PRENOMTITULAIRE`, `NOMTITULAIRE`, `ADRESSETITULAIRE`, `CODEPOSTALTITULAIRE`) VALUES
(1000, 'Philippe', 'Bouget', '52 rue de la Java', '75013'),
(1001, 'Mireille', 'Kupper', '22 rue Loin de Paris', '91000'),
(1002, 'Juliette', 'Barats', '13 rue de la Bureautique', '75011'),
(1003, 'Malika', 'Chabira', '23 rue de l\'insertion', '7018'),
(1004, 'Josselin', 'Tobelem', '18 rue de SpringBoot', '93000'),
(1005, 'Jonathan', 'Siffert', '22 rue des Projets', '93000');


CREATE TABLE `typecompte` (
  `CODETYPECOMPTE` char(1) NOT NULL,
  `INTITULECOMPTE` varchar(25) NOT NULL,
  PRIMARY KEY (`CODETYPECOMPTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `typecompte` (`CODETYPECOMPTE`, `INTITULECOMPTE`) VALUES
('C', 'Compte courant'),
('E', 'Compte épargne');


ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`CODETYPECOMPTE`) REFERENCES `typecompte` (`CODETYPECOMPTE`),
  ADD CONSTRAINT `compte_ibfk_2` FOREIGN KEY (`CODETITULAIRE`) REFERENCES `titulaire` (`CODETITULAIRE`);

ALTER TABLE `operations`
  ADD CONSTRAINT `operations_ibfk_1` FOREIGN KEY (`NUMEROCOMPTE`) REFERENCES `compte` (`NUMEROCOMPTE`);
COMMIT;