
-- -----------------------------------------------------
-- Schema oficina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `oficina` DEFAULT CHARACTER SET latin1 ;
USE `oficina` ;

-- -----------------------------------------------------
-- Table `oficina`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`cliente` (
  `IDCLIENTE` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  `CPF` varchar(11) NULL DEFAULT NULL,
  `TELEFONE` VARCHAR(13) NULL DEFAULT NULL,
  PRIMARY KEY (`IDCLIENTE`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`carro` (
  `IDCARRO` INT(11) NOT NULL AUTO_INCREMENT,
  `MARCA` VARCHAR(45) NULL DEFAULT NULL,
  `MODELO` VARCHAR(45) NULL DEFAULT NULL,
  `PLACA` varchar(8) NULL DEFAULT NULL,
  `COR` VARCHAR(255) NULL DEFAULT NULL,
  `ANO` int(4) NULL DEFAULT NULL,
  `IDCLIENTE` INT(11) NOT NULL,
  PRIMARY KEY (`IDCARRO`),
  CONSTRAINT `fk_carro_cliente`
    FOREIGN KEY (`IDCLIENTE`)
    REFERENCES `oficina`.`cliente` (`IDCLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`peca` (
  `IDPECA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMEPECA` VARCHAR(255) NULL DEFAULT NULL,
  `CODIGO` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`IDPECA`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`servico` (
  `IDSERVICO` INT(11) NOT NULL,
  `DESERVICO` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDSERVICO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`situacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`situacao` (
  `IDSITUACAO` INT(11) NOT NULL,
  `DESITUACAO` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDSITUACAO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`mecanico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`mecanico` (
  `IDMECANICO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`IDMECANICO`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`orcamento` (
  `IDORCAMENTO` INT(11) NOT NULL AUTO_INCREMENT,  
  `NUORCAMENTO` INT(3) NULL DEFAULT NULL,
  `DESCRICAO` VARCHAR(255) NULL DEFAULT NULL,
  `VALORPECAS` DOUBLE(4,2) NULL DEFAULT NULL,
  `VALORMAOOBRA` VARCHAR(255) NULL DEFAULT NULL,
  `DATAINICIO` DATE NULL DEFAULT NULL,
  `DATAFINAL` DATE NULL DEFAULT NULL,
  `IDMECANICO` INT(11) NULL DEFAULT NULL,
  `IDCARRO` INT(11) NOT NULL,
  `IDSITUACAO` INT(11) NOT NULL,
  `IDSERVICO` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`IDORCAMENTO`),
  CONSTRAINT `fk_orcamento_carro1`
    FOREIGN KEY (`IDCARRO`)
    REFERENCES `oficina`.`carro` (`IDCARRO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_servico1`
    FOREIGN KEY (`IDSERVICO`)
    REFERENCES `oficina`.`servico` (`IDSERVICO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orcamento_situacao1`
    FOREIGN KEY (`IDSITUACAO`)
    REFERENCES `oficina`.`situacao` (`IDSITUACAO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orcamento_ibfk_3`
    FOREIGN KEY (`IDMECANICO`)
    REFERENCES `oficina`.`mecanico` (`IDMECANICO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`item_peca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`item_peca` (
  `IDITEMPECA` INT(11) NOT NULL AUTO_INCREMENT,
  `VALORVENDA` DOUBLE(4,2) NULL DEFAULT NULL,
  `VALORCOMPRA` DOUBLE(4,2) NULL DEFAULT NULL,
  `DATAENTRADA` DATE NULL DEFAULT NULL,
  `DATASAIDA` DATE NULL DEFAULT NULL,
  `QUANTIDADE` INT(11) NULL DEFAULT NULL,
  `IDPECA` INT(11) NOT NULL,
  `IDORCAMENTO` INT(11)  NULL,
  PRIMARY KEY (`IDITEMPECA`),
  CONSTRAINT `fk_item_peca_peca1`
    FOREIGN KEY (`IDPECA`)
    REFERENCES `oficina`.`peca` (`IDPECA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_peca_orcamento1`
    FOREIGN KEY (`IDORCAMENTO`)
    REFERENCES `oficina`.`orcamento` (`IDORCAMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `oficina`.`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `oficina`.`login` (
  `IDUSUARIO` INT(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` VARCHAR(255) NULL DEFAULT NULL,
  `SENHA` VARCHAR(255) NULL DEFAULT NULL,
  `TIPO` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`IDUSUARIO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO MECANICO (IDMECANICO,NOME) VALUES (0, 'GODOFREDO');
INSERT INTO MECANICO (IDMECANICO,NOME) VALUES (1, 'JEORGE');
INSERT INTO MECANICO (IDMECANICO,NOME) VALUES (2, 'LUCAS');

INSERT INTO SITUACAO (IDSITUACAO, DESITUACAO) VALUES (0, 'Em Aguardo');
INSERT INTO SITUACAO (IDSITUACAO, DESITUACAO) VALUES (1, 'Em Andamento');
INSERT INTO SITUACAO (IDSITUACAO, DESITUACAO) VALUES (2, 'Finalizado');

INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (0, 'Alinhamento');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (1, 'Troca de Oleo');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (2, 'Troca de Pastilha de Freio');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (3, 'Troca de Parabrisa');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (4, 'Troca de Embreagem');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (5, 'Troca de Disco de Freio');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (6, 'Troca de Para-lama');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (7, 'Troca do Motor de Arranque');
INSERT INTO SERVICO (IDSERVICO, DESERVICO) VALUES (8, 'Troca de Pecas');
