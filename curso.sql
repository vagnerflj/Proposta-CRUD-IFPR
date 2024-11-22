-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema curso
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema curso
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `curso` DEFAULT CHARACTER SET utf8 ;
USE `curso` ;

-- -----------------------------------------------------
-- Table `curso`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);


-- -----------------------------------------------------
-- Table `curso`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `curso`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `descricao` TEXT(255) NULL,
  `professor_id1` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_curso_professor1_idx` (`professor_id1` ASC) VISIBLE,
  CONSTRAINT `fk_curso_professor1`
    FOREIGN KEY (`professor_id1`)
    REFERENCES `curso`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `curso`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `inscricao_curso_id` INT NOT NULL,
  `inscricao_aluno_id` INT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `curso`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(255) NULL,
  `curso_id` INT NOT NULL,
  `aluno_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_feedback_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_feedback_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_feedback_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `curso`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_feedback_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `curso`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `curso`.`aluno_has_curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `curso`.`aluno_has_curso` (
  `aluno_id` INT NOT NULL,
  `curso_id` INT NOT NULL,
  PRIMARY KEY (`aluno_id`, `curso_id`),
  INDEX `fk_aluno_has_curso_curso1_idx` (`curso_id` ASC) VISIBLE,
  INDEX `fk_aluno_has_curso_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_has_curso_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `curso`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_has_curso_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `curso`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
