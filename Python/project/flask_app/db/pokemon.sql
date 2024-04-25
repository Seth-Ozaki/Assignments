-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pokemon
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pokemon` ;

-- -----------------------------------------------------
-- Schema pokemon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokemon` DEFAULT CHARACTER SET utf8 ;
USE `pokemon` ;

-- -----------------------------------------------------
-- Table `pokemon`.`pokemons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`pokemons` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `height` INT NULL,
  `image` VARCHAR(300) NULL,
  `hp` INT NULL,
  `attack` INT NULL,
  `defense` INT NULL,
  `sp_attack` INT NULL,
  `sp_defense` INT NULL,
  `speed` INT NULL,
  `weight` INT NULL,
  `type1` VARCHAR(45) NULL,
  `type2` VARCHAR(45) NULL,
  `game_appearance` VARCHAR(45) NULL,
  `first_ability` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `password` VARCHAR(200) NULL,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pokemon`.`likes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`likes` (
  `user_id` INT NOT NULL,
  `pokemon_id` INT NOT NULL,
  INDEX `fk_likes_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_likes_pokemons1_idx` (`pokemon_id` ASC) VISIBLE,
  CONSTRAINT `fk_likes_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `pokemon`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_likes_pokemons1`
    FOREIGN KEY (`pokemon_id`)
    REFERENCES `pokemon`.`pokemons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
