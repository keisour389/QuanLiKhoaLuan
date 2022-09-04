-- MySQL Script generated by MySQL Workbench
-- Sun Sep  4 22:47:12 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema master_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `master_db` ;

-- -----------------------------------------------------
-- Schema master_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `master_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci ;
USE `master_db` ;

-- -----------------------------------------------------
-- Table `master_db`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`user` ;

CREATE TABLE IF NOT EXISTS `master_db`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `first_name` VARCHAR(50) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `password_hash` VARCHAR(200) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `role` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `last_login_date` DATETIME NULL DEFAULT NULL,
  `deleted` TINYINT NOT NULL,
  `created_by` INT NULL DEFAULT NULL,
  `last_modified_by` INT NULL DEFAULT NULL,
  `created_date` DATETIME NULL DEFAULT NULL,
  `last_modified_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`criteria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`criteria` ;

CREATE TABLE IF NOT EXISTS `master_db`.`criteria` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `deleted` TINYINT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `last_modified_by` BIGINT NULL DEFAULT NULL,
  `created_date` DATETIME NOT NULL,
  `last_modified_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_criteria_user1_idx` (`created_by` ASC) VISIBLE,
  INDEX `fk_criteria_user2_idx` (`last_modified_by` ASC) VISIBLE,
  CONSTRAINT `fk_criteria_user1`
    FOREIGN KEY (`created_by`)
    REFERENCES `master_db`.`user` (`id`),
  CONSTRAINT `fk_criteria_user2`
    FOREIGN KEY (`last_modified_by`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`thesis_defense`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`thesis_defense` ;

CREATE TABLE IF NOT EXISTS `master_db`.`thesis_defense` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(20) NOT NULL,
  `deleted` TINYINT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `last_modified_by` BIGINT NULL DEFAULT NULL,
  `created_date` DATETIME NOT NULL,
  `last_modified_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_thesis_defense_user1_idx` (`created_by` ASC) VISIBLE,
  INDEX `fk_thesis_defense_user2_idx` (`last_modified_by` ASC) VISIBLE,
  CONSTRAINT `fk_thesis_defense_user1`
    FOREIGN KEY (`created_by`)
    REFERENCES `master_db`.`user` (`id`),
  CONSTRAINT `fk_thesis_defense_user2`
    FOREIGN KEY (`last_modified_by`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`study`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`study` ;

CREATE TABLE IF NOT EXISTS `master_db`.`study` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `school_year` VARCHAR(20) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  `deleted` TINYINT NOT NULL,
  `created_by` BIGINT NOT NULL,
  `last_modified_by` BIGINT NULL DEFAULT NULL,
  `created_date` DATETIME NOT NULL,
  `last_modified_date` DATETIME NULL DEFAULT NULL,
  `thesis_defense_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_study_user1_idx` (`created_by` ASC) VISIBLE,
  INDEX `fk_study_user2_idx` (`last_modified_by` ASC) VISIBLE,
  INDEX `fk_study_thesis_defense1_idx` (`thesis_defense_id` ASC) VISIBLE,
  CONSTRAINT `fk_study_thesis_defense1`
    FOREIGN KEY (`thesis_defense_id`)
    REFERENCES `master_db`.`thesis_defense` (`id`),
  CONSTRAINT `fk_study_user1`
    FOREIGN KEY (`created_by`)
    REFERENCES `master_db`.`user` (`id`),
  CONSTRAINT `fk_study_user2`
    FOREIGN KEY (`last_modified_by`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`criteria_study_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`criteria_study_user` ;

CREATE TABLE IF NOT EXISTS `master_db`.`criteria_study_user` (
  `criteria_id` BIGINT NOT NULL,
  `study_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `score` DOUBLE NOT NULL,
  PRIMARY KEY (`criteria_id`, `study_id`, `user_id`),
  INDEX `fk_criteria_has_study_study1_idx` (`study_id` ASC) VISIBLE,
  INDEX `fk_criteria_has_study_criteria1_idx` (`criteria_id` ASC) VISIBLE,
  INDEX `fk_criteria_study_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_criteria_has_study_criteria1`
    FOREIGN KEY (`criteria_id`)
    REFERENCES `master_db`.`criteria` (`id`),
  CONSTRAINT `fk_criteria_has_study_study1`
    FOREIGN KEY (`study_id`)
    REFERENCES `master_db`.`study` (`id`),
  CONSTRAINT `fk_criteria_study_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`thesis_defense_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`thesis_defense_user` ;

CREATE TABLE IF NOT EXISTS `master_db`.`thesis_defense_user` (
  `thesis_defense_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `role` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_unicode_520_ci' NOT NULL,
  PRIMARY KEY (`thesis_defense_id`, `user_id`),
  INDEX `fk_thesis_defense_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_thesis_defense_has_user_thesis_defense1_idx` (`thesis_defense_id` ASC) VISIBLE,
  CONSTRAINT `fk_thesis_defense_has_user_thesis_defense1`
    FOREIGN KEY (`thesis_defense_id`)
    REFERENCES `master_db`.`thesis_defense` (`id`),
  CONSTRAINT `fk_thesis_defense_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


-- -----------------------------------------------------
-- Table `master_db`.`user_study`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `master_db`.`user_study` ;

CREATE TABLE IF NOT EXISTS `master_db`.`user_study` (
  `study_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`study_id`, `user_id`),
  INDEX `fk_study_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_study_has_user_study_idx` (`study_id` ASC) VISIBLE,
  CONSTRAINT `fk_study_has_user_study`
    FOREIGN KEY (`study_id`)
    REFERENCES `master_db`.`study` (`id`),
  CONSTRAINT `fk_study_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `master_db`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_520_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
