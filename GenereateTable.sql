-- MySQL Script generated by MySQL Workbench
-- Sun May 17 18:20:31 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gamachicas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gamachicas` ;

-- -----------------------------------------------------
-- Schema gamachicas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gamachicas` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `gamachicas` ;

-- -----------------------------------------------------
-- Table `Company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Company` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Company` (
  `idCompany` INT NOT NULL,
  `Name` VARCHAR(405) NULL,
  `IDUnique` VARCHAR(450) NULL,
  `MobilPhone` VARCHAR(405) NULL,
  `Mail` VARCHAR(495) NULL,
  `Phone` VARCHAR(405) NULL,
  `Description` VARCHAR(905) NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idCompany`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Customers` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Customers` (
  `idCustomer` INT NOT NULL,
  `Name` VARCHAR(50) NULL,
  `FirstName` VARCHAR(50) NULL,
  `SecondName` VARCHAR(45) NULL,
  `password` CHAR(40) NULL,
  `IdPosition` INT NULL,
  `address` VARCHAR(500) NULL,
  `Ubigeo` VARCHAR(59) NULL,
  `UrlSocialMedia` VARCHAR(45) NULL,
  `MobilPhone` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idCustomer`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `DetailImagen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DetailImagen` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `DetailImagen` (
  `idDetailImagen` INT NOT NULL,
  `IdImagen` INT NULL,
  `Vista` INT NULL,
  `url` VARCHAR(405) BINARY NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idDetailImagen`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `DetailOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DetailOrder` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `DetailOrder` (
  `idDetailOrder` INT NOT NULL,
  `IdOrder` INT NULL,
  `IdProduct` INT NULL,
  `Amount` INT NULL,
  `IdUnit` INT NULL,
  `PriceByUnit` DECIMAL(17,8) NULL,
  `CreateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idDetailOrder`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Imagen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Imagen` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Imagen` (
  `idImagen` INT NOT NULL AUTO_INCREMENT,
  `IdProduct` INT NULL,
  `IdSystem` INT NULL,
  `IdUser` INT NULL,
  `Name` VARCHAR(400) NULL,
  `PositionWeb` INT NULL,
  `CountViews` INT NULL,
  `imagendata` LONGBLOB NULL,
  `url` VARCHAR(405) NULL,
  `Description` VARCHAR(405) NULL,
  `Status` TINYINT NULL,
  `ImagenCode` VARCHAR(509) NULL,
  `createdate` TIMESTAMP NULL,
  `updatedate` TIMESTAMP NULL,
  PRIMARY KEY (`idImagen`))
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `ImagenCode_UNIQUE` ON `Imagen` (`ImagenCode` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Invoice` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Invoice` (
  `idInvoice` INT NOT NULL,
  `IdOrder` INT NULL,
  `IdCustomer` INT NULL,
  `IdUser` INT NULL,
  `Description` VARCHAR(400) NULL,
  `Amount` DECIMAL(17,8) NULL,
  `Total` DECIMAL(17,8) NULL,
  `Tax` DECIMAL(17,8) NULL,
  `SaleDate` TIMESTAMP NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idInvoice`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Order` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Order` (
  `idOrder` INT NOT NULL,
  `IdDetailOrder` INT NOT NULL,
  `IDInvoice` INT NULL,
  `IdStock` INT NOT NULL,
  `IdUser` INT NOT NULL,
  `IdSystem` INT NULL,
  `Status` TINYINT NOT NULL,
  `Description` VARCHAR(200) NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idOrder`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Place`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Place` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Place` (
  `idPlace` INT NOT NULL,
  `IDPosition` INT NULL,
  `Name` VARCHAR(400) NULL,
  `Description` VARCHAR(400) NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  `Idubigeo` INT NULL,
  PRIMARY KEY (`idPlace`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Position`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Position` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Position` (
  `idPosition` INT NOT NULL,
  `X` DECIMAL(17,8) NULL,
  `Y` DECIMAL(17,8) NULL,
  `Z` DECIMAL(17,8) NULL,
  PRIMARY KEY (`idPosition`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Price`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Price` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Price` (
  `idPrice` INT NOT NULL AUTO_INCREMENT,
  `IdProduct` INT NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  `SmallerPrice` DECIMAL(18,7) NULL,
  `HigherPrice` DECIMAL(18,7) NULL,
  PRIMARY KEY (`idPrice`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Product` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NULL,
  `IdType` INT NULL,
  `IdPrice` INT NULL,
  `IdSystem` INT NULL,
  `IdUser` INT NULL,
  `IdImagen` INT NULL,
  `ExpirationDate` TIMESTAMP NULL,
  `Status` TINYINT NULL,
  `Description` VARCHAR(400) NULL,
  `createDate` TIMESTAMP NULL,
  `updatedate` TIMESTAMP NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Stock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Stock` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Stock` (
  `idStock` INT NOT NULL AUTO_INCREMENT,
  `Amount` DECIMAL(17,8) NULL,
  `IdProduct` INT NULL,
  `IdSystem` INT NULL,
  `IdUser` INT NULL,
  `IdUnit` INT NULL,
  `IDPlace` INT NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idStock`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `System`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `System` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `System` (
  `idSystem` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `URL` VARCHAR(405) NULL,
  `Status` TINYINT NULL,
  `IdCompany` VARCHAR(45) NULL,
  `Idmenu` INT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idSystem`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `Users` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `IdSystem` INT NULL,
  `username` VARCHAR(400) NULL,
  `password` VARCHAR(500) NULL,
  `salPassword` VARCHAR(500) NULL,
  `ApiPassword` CHAR(60) NULL,
  `Alias` VARCHAR(40) NULL,
  `IdRol` INT NULL,
  `Mail` VARCHAR(45) NULL,
  `MobilPhone` VARCHAR(50) NULL,
  `Status` TINYINT NULL,
  `CreateDate` TIMESTAMP NULL,
  `UpdateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `rol`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rol` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `rol` (
  `idrol` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Description` VARCHAR(405) NULL,
  `status` TINYINT NULL,
  `createDate` TIMESTAMP NULL,
  `updateDate` TIMESTAMP NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
