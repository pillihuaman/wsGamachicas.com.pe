CREATE TABLE `parameter` (
  `idparameter` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  value varchar(100) not null,
  `STATUS` tinyint(1) DEFAULT NULL,
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `idGroupparameter` int(11) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idparameter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `gamachicas`.`groupparameter`
(`idGroupparameter`,
`DESCRIPTION`,
`createdate`,
`updatedate`,
`Short`)
VALUES
(1,
'Menu configuration',
 CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);
INSERT INTO `gamachicas`.`parameter`
(`idparameter`,
`NAME`,
`value`,
`STATUS`,
`createdate`,
`updatedate`,
`idGroupparameter`,
`Description`)
VALUES
(1,
'API_URL',
'http://localhost:8080',
1,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1,
'Refencia a la web API   para gamachicas.com');

INSERT INTO `gamachicas`.`parameter`
(`idparameter`,
`NAME`,
`value`,
`STATUS`,
`createdate`,
`updatedate`,
`idGroupparameter`,
`Description`)
VALUES
(2,
'APP_URL',
'http://localhost:8083',
1,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1,
'URL a la APP gamachicas.com');

INSERT INTO `gamachicas`.`parentmenu`
(`idparentMenu`,
`name`,
`path`,
`createdate`,
`updatedate`,
`status`)
VALUES
(1,
'Ropa de mujer',
'Womanuri',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);

INSERT INTO `gamachicas`.`parentmenu`
(`idparentMenu`,
`name`,
`path`,
`createdate`,
`updatedate`,
`status`)
VALUES
(2,
'Ropa de Varon',
'Menuri',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);
INSERT INTO `gamachicas`.`parentmenu`
(`idparentMenu`,
`name`,
`path`,
`createdate`,
`updatedate`,
`status`)
VALUES
(3,
'Ropa de bb',
'Babyuri',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);
INSERT INTO `gamachicas`.`parentmenu`
(`idparentMenu`,
`name`,
`path`,
`createdate`,
`updatedate`,
`status`)
VALUES
(4,
'Ropa de niño',
'Childuri',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);

INSERT INTO `gamachicas`.`parentmenu`
(`idparentMenu`,
`name`,
`path`,
`createdate`,
`updatedate`,
`status`)
VALUES
(5,
'Home',
'/',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP,
1);






