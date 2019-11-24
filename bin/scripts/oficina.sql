-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema oficina
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema oficina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oficina` DEFAULT CHARACTER SET latin1 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `oficina`.`mecanico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`mecanico` (
  `IDMECANICO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDMECANICO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`cliente` (
  `IDCLIENTE` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  `CPF` CHAR(11) NULL DEFAULT NULL,
  `TELEFONE` VARCHAR(13) NULL DEFAULT NULL,
  PRIMARY KEY (`IDCLIENTE`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`carro` (
  `IDCARRO` INT NOT NULL,
  `MARCA` VARCHAR(45) NULL,
  `MODELO` VARCHAR(45) NULL,
  `PLACA` CHAR(7) NULL,
  `IDCLIENTE` INT(11) NOT NULL,
  PRIMARY KEY (`IDCARRO`),
  INDEX `fk_carro_cliente_idx` (`IDCLIENTE` ASC) VISIBLE,
  CONSTRAINT `fk_carro_cliente`
    FOREIGN KEY (`IDCLIENTE`)
    REFERENCES `oficina`.`cliente` (`IDCLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `oficina`.`peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`peca` (
  `IDPECA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMEPECA` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDPECA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`item_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`item_peca` (
  `IDITEMPECA` INT(11) NOT NULL,
  `NOME` VARCHAR(45) NULL,
  `VALOR` VARCHAR(45) NULL,
  `DATAENTRADA` DATE NULL,
  `DATASAIDA` DATE NULL,
  `QUANTIDADE` INT NULL,
  `IDPECA` INT(11) NOT NULL,
  INDEX `fk_item_peca_peca1_idx` (`IDPECA` ASC) VISIBLE,
  PRIMARY KEY (`IDITEMPECA`),
  CONSTRAINT `fk_item_peca_peca1`
    FOREIGN KEY (`IDPECA`)
    REFERENCES `oficina`.`peca` (`IDPECA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`orcamento` (
  `IDORCAMENTO` INT(11) NOT NULL AUTO_INCREMENT,
  `SERVICO` VARCHAR(255) NULL DEFAULT NULL,
  `DESCRICAO` VARCHAR(255) NULL DEFAULT NULL,
  `VALOR` DOUBLE(4,2) NULL DEFAULT NULL,
  `DATAINICIO` DATE NULL DEFAULT NULL,
  `DATAFINAL` DATE NULL DEFAULT NULL,
  `SITUACAO` VARCHAR(255) NULL DEFAULT NULL,
  `IDMECANICO` INT(11) NOT NULL,
  `IDCARRO` INT(11) NOT NULL,
  `IDITEMPECA` INT(11) NOT NULL,
  PRIMARY KEY (`IDORCAMENTO`),
  INDEX `IDMECANICO` (`IDMECANICO` ASC) VISIBLE,
  INDEX `fk_orcamento_carro1_idx` (`IDCARRO` ASC) VISIBLE,
  INDEX `fk_orcamento_item_peca1_idx` (`IDITEMPECA` ASC) VISIBLE,
  CONSTRAINT `orcamento_ibfk_3`
    FOREIGN KEY (`IDMECANICO`)
    REFERENCES `oficina`.`mecanico` (`IDMECANICO`),
  CONSTRAINT `fk_orcamento_carro1`
    FOREIGN KEY (`IDCARRO`)
    REFERENCES `mydb`.`carro` (`IDCARRO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_item_peca1`
    FOREIGN KEY (`IDITEMPECA`)
    REFERENCES `oficina`.`item_peca` (`IDITEMPECA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`situacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`situacao` (
  `IDSITUACAO` INT NOT NULL,
  `SOLICITADO` VARCHAR(255) NULL,
  `EMANDAMENTO` VARCHAR(255) NULL,
  `FINALIZADO` VARCHAR(255) NULL,
  `IDORCAMENTO` INT(11) NOT NULL,
  PRIMARY KEY (`IDSITUACAO`),
  INDEX `fk_situacao_orcamento1_idx` (`IDORCAMENTO` ASC) VISIBLE,
  CONSTRAINT `fk_situacao_orcamento1`
    FOREIGN KEY (`IDORCAMENTO`)
    REFERENCES `oficina`.`orcamento` (`IDORCAMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`servico` (
  `IDSERVICO` INT NOT NULL,
  `PINTURA` VARCHAR(255) NULL,
  `BALANCEAMENTO` VARCHAR(255) NULL,
  `TROCAPNEU` VARCHAR(255) NULL,
  `TROCAOLEO` VARCHAR(255) NULL,
  `IDORCAMENTO` INT(11) NOT NULL,
  PRIMARY KEY (`IDSERVICO`),
  INDEX `fk_servico_orcamento1_idx` (`IDORCAMENTO` ASC) VISIBLE,
  CONSTRAINT `fk_servico_orcamento1`
    FOREIGN KEY (`IDORCAMENTO`)
    REFERENCES `oficina`.`orcamento` (`IDORCAMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `oficina` ;

-- -----------------------------------------------------
-- Table `oficina`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`login` (
  `IDUSUARIO` INT(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` VARCHAR(255) NULL DEFAULT NULL,
  `SENHA` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDUSUARIO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
