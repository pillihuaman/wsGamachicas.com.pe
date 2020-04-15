CREATE TABLE IF NOT EXISTS DetailProduct (
    IdDetailProduct int(11) AUTO_INCREMENT PRIMARY KEY,
    IdProducto int(11)  NOT NULL,
    TIPO varchar(500),
    Description varchar(500),
    updatedate timestamp,
    createdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

