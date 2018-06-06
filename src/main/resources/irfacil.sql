-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema irfacil
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema irfacil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `irfacil` DEFAULT CHARACTER SET utf8 ;
USE `irfacil` ;

-- -----------------------------------------------------
-- Table `irfacil`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irfacil`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(70) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL COMMENT 'Nome de usuario',
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irfacil`.`papel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irfacil`.`papel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cd_papel` VARCHAR(10) NOT NULL,
  `no_empresa` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irfacil`.`tipo_operacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irfacil`.`tipo_operacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `irfacil`.`operacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `irfacil`.`operacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dt_compra` DATE NOT NULL,
  `dt_venda` DATE NULL,
  `quantidade` INT NOT NULL,
  `vl_compra` DOUBLE NOT NULL,
  `vl_venda` DOUBLE NOT NULL,
  `vl_ir` DOUBLE NOT NULL,
  `vl_emolumentos` DOUBLE NOT NULL,
  `papel_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `tipo_operacao_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_operacao_papel_idx` (`papel_id` ASC),
  INDEX `fk_operacao_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_operacao_tipo_operacao1_idx` (`tipo_operacao_id` ASC),
  CONSTRAINT `fk_operacao_papel`
    FOREIGN KEY (`papel_id`)
    REFERENCES `irfacil`.`papel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operacao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `irfacil`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operacao_tipo_operacao1`
    FOREIGN KEY (`tipo_operacao_id`)
    REFERENCES `irfacil`.`tipo_operacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
