-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mediaCenter
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mediaCenter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mediaCenter` DEFAULT CHARACTER SET utf8 ;
USE `mediaCenter` ;

-- -----------------------------------------------------
-- Table `mediaCenter`.`Utilizador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Utilizador` (
  `idUtilizador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`idUtilizador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediaCenter`.`Conteudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Conteudo` (
  `idConteudo` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `localizacao` VARCHAR(45) NOT NULL,
  `artista` VARCHAR(45) NULL,
  `genero` VARCHAR(45) NULL,
  `tipo` TINYINT NOT NULL,
  PRIMARY KEY (`idConteudo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediaCenter`.`Playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Playlist` (
  `idPlaylist` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `Utilizador_idUtilizador` INT NOT NULL,
  PRIMARY KEY (`idPlaylist`, `Utilizador_idUtilizador`),
  INDEX `fk_Playlist_Utilizador1_idx` (`Utilizador_idUtilizador` ASC),
  CONSTRAINT `fk_Playlist_Utilizador1`
    FOREIGN KEY (`Utilizador_idUtilizador`)
    REFERENCES `mediaCenter`.`Utilizador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediaCenter`.`Utilizador_has_Conteudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Utilizador_has_Conteudo` (
  `Utilizador_idUtilizador` INT NOT NULL,
  `Conteudo_idConteudo` INT NOT NULL,
  PRIMARY KEY (`Utilizador_idUtilizador`, `Conteudo_idConteudo`),
  INDEX `fk_Utilizador_has_Conteudo_Conteudo1_idx` (`Conteudo_idConteudo` ASC),
  INDEX `fk_Utilizador_has_Conteudo_Utilizador_idx` (`Utilizador_idUtilizador` ASC),
  CONSTRAINT `fk_Utilizador_has_Conteudo_Utilizador`
    FOREIGN KEY (`Utilizador_idUtilizador`)
    REFERENCES `mediaCenter`.`Utilizador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Utilizador_has_Conteudo_Conteudo1`
    FOREIGN KEY (`Conteudo_idConteudo`)
    REFERENCES `mediaCenter`.`Conteudo` (`idConteudo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediaCenter`.`Playlist_has_Conteudo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Playlist_has_Conteudo` (
  `Playlist_idPlaylist` INT NOT NULL,
  `Conteudo_idConteudo` INT NOT NULL,
  PRIMARY KEY (`Playlist_idPlaylist`, `Conteudo_idConteudo`),
  INDEX `fk_Playlist_has_Conteudo_Conteudo1_idx` (`Conteudo_idConteudo` ASC),
  INDEX `fk_Playlist_has_Conteudo_Playlist1_idx` (`Playlist_idPlaylist` ASC),
  CONSTRAINT `fk_Playlist_has_Conteudo_Playlist1`
    FOREIGN KEY (`Playlist_idPlaylist`)
    REFERENCES `mediaCenter`.`Playlist` (`idPlaylist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Playlist_has_Conteudo_Conteudo1`
    FOREIGN KEY (`Conteudo_idConteudo`)
    REFERENCES `mediaCenter`.`Conteudo` (`idConteudo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mediaCenter`.`Amigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediaCenter`.`Amigo` (
  `idUtilizador` INT NOT NULL,
  `idAmigo` INT NOT NULL,
  PRIMARY KEY (`idUtilizador`),
  CONSTRAINT `fk_Amigos_Utilizador1`
    FOREIGN KEY (`idUtilizador`)
    REFERENCES `mediaCenter`.`Utilizador` (`idUtilizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
