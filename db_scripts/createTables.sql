-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Failure_Class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Failure_Class` (
  `Failure Class` INT NOT NULL,
  `Description` VARCHAR(45) NULL,
  PRIMARY KEY (`Failure Class`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Event_Cause`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Event_Cause` (
  `Course Code` INT NOT NULL AUTO_INCREMENT,
  `Event id` INT NOT NULL,
  `Description` VARCHAR(45) NULL,
  PRIMARY KEY (`Course Code`, `Event id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Base_Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Base_Data` (
  Date_Time DATETIME NOT NULL,
	Event_id INT NOT NULL,
  Failure_Class INT DEFAULT NULL,
  UE_Type INT NULL,
  Market INT NULL,
  Operator INT NULL,
  Cell_id INT NULL,
  Duration INT NULL,
  Course_Code INT NULL,
  NE_Version VARCHAR(45) NULL,
  IMSI decimal(20,0) NULL,
  HIER3_ID decimal(20,0) NULL,
  HIER32_ID decimal(20,0) NULL,
  HER321_ID decimal(20,0) NULL,
  id INT NOT NULL auto_increment,
 
 #remove next line and uncomment following section to revert
 primary key(`id`))
 
#  PRIMARY KEY (`id`),
#  CONSTRAINT `Failure Class`
#    FOREIGN KEY (`Failure Class`)
#    REFERENCES `mydb`.`Failure_Class` (`Failure Class`)
#    ON DELETE NO ACTION
#    ON UPDATE NO ACTION,
#  CONSTRAINT `Course Code`
#    FOREIGN KEY (`Course Code`)
#    REFERENCES `mydb`.`Event_Cause` (`Course Code`)
#    ON DELETE NO ACTION
#    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UE` (
  `TAC` INT NOT NULL,
  `MARKETING NAME` VARCHAR(45) NULL,
  `MANUFACTURER` VARCHAR(45) NULL,
  `ACCESS CAPABILITY` VARCHAR(45) NULL,
  `MODEL` VARCHAR(45) NULL,
  `VENDOR NAME` VARCHAR(45) NULL,
  `UE TYPE` VARCHAR(45) NULL,
  `OS` VARCHAR(45) NULL,
  `INPUT_MODE` VARCHAR(45) NULL,
  PRIMARY KEY (`TAC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MCE-MNC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MCE-MNC` (
  `MCC` INT(11) NOT NULL,
  `MNC` INT(11) NOT NULL,
  `COUNT` VARCHAR(45) NOT NULL,
  `OPERATOR` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`MCC`, `MNC`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
