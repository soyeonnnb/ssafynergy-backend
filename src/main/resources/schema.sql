-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafynergy
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafynergy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafynergy` DEFAULT CHARACTER SET utf8 ;
USE `ssafynergy` ;

-- -----------------------------------------------------
-- Table `ssafynergy`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`User` (
  `id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `nickname` VARCHAR(30) NOT NULL,
  `regist_date` DATETIME NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `type` VARCHAR(10) NOT NULL DEFAULT 'N',
  `img` VARCHAR(200) NULL,
  `socialLogin` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;

INSERT INTO user 
VALUES('admin', 'admin', 'admin', 'admin', now(), 'admin@ssafy.com', 'A', null, 'F'),
('ssafy1', 'ssafy1', 'ssafy1', 'ssafy1', now(), 'ssafy1@ssafy.com', 'N', null, 'F'),
('ssafy2', 'ssafy2', 'ssafy2', 'ssafy2', now(), 'ssafy2@ssafy.com', 'N', null, 'F'),
('junghun', 'junghun', 'junghun', 'junghun', now(), 'junghun@ssafy.com', 'N', null, 'F'),
('soyeon', 'soyeon', 'soyeon', 'soyeon', now(), 'soyeon@ssafy.com', 'N', null, 'F');


-- -----------------------------------------------------
-- Table `ssafynergy`.`Follow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Follow` (
  `User_id` VARCHAR(30) NOT NULL,
  `Follow_User_id` VARCHAR(30) NOT NULL,
  `created_at` DATETIME NOT NULL,
  INDEX `fk_Follow_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Follow_User2_idx` (`Follow_User_id` ASC) VISIBLE,
  PRIMARY KEY (`User_id`, `Follow_User_id`),
  CONSTRAINT `fk_Follow_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Follow_User2`
    FOREIGN KEY (`Follow_User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO follow
VALUES ('ssafy1', 'ssafy2',now());

-- -----------------------------------------------------
-- Table `ssafynergy`.`challenge_difficulty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`challenge_difficulty` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `index` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO challenge_difficulty
VALUES
(0, '쉬움', 1),
(0, '보통', 2),
(0, '어려움', 3);

-- -----------------------------------------------------
-- Table `ssafynergy`.`Challenge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Challenge` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `start_at` DATETIME NOT NULL,
  `finish_at` DATETIME NOT NULL,
  `description` TEXT NULL,
  `limit_person_num` INT NOT NULL DEFAULT 1,
  `public` TINYINT NOT NULL DEFAULT 0,
  `challenge_difficulty_id` INT NOT NULL,
  `opportunity` INT NOT NULL DEFAULT 1,
  `is_giveup` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`, `challenge_difficulty_id`),
  INDEX `fk_Challenge_challenge_difficulty1_idx` (`challenge_difficulty_id` ASC) VISIBLE,
  CONSTRAINT `fk_Challenge_challenge_difficulty1`
    FOREIGN KEY (`challenge_difficulty_id`)
    REFERENCES `ssafynergy`.`challenge_difficulty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO challenge
VALUES(0, '미라클챌린지', now(), '2023-06-01', '2023-06-30', '미라클챌린지입니다.', 60, 0, 1, 3, 0 );


-- -----------------------------------------------------
-- Table `ssafynergy`.`Challenge_participate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Challenge_participate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_id` VARCHAR(30) NOT NULL,
  `Challenge_id` INT NOT NULL,
  `participated_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_has_Challenge_Challenge1_idx` (`Challenge_id` ASC) VISIBLE,
  INDEX `fk_User_has_Challenge_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Challenge_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Challenge_Challenge1`
    FOREIGN KEY (`Challenge_id`)
    REFERENCES `ssafynergy`.`Challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO challenge_participate
VALUES(0, 'ssafy1', 0, now());


-- -----------------------------------------------------
-- Table `ssafynergy`.`Challenge_ing`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Challenge_ing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Challenge_participate_id` INT NOT NULL,
  `index` INT NOT NULL,
  `content` VARCHAR(500) NULL,
  `check` TINYINT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL,
  `img` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Challenge_ing_Challenge_participate1_idx` (`Challenge_participate_id` ASC) VISIBLE,
  CONSTRAINT `fk_Challenge_ing_Challenge_participate1`
    FOREIGN KEY (`Challenge_participate_id`)
    REFERENCES `ssafynergy`.`Challenge_participate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO challenge_ing
VALUES (0, 0, 1, '화이팅1', 1, now(), "temp.png"),
(0, 0, 2, '화이팅2', 1, now(),  "temp.png"),
(0, 0, 3, '화이팅3', 1, now(),  "temp.png"),
(0, 0, 4, '화이팅4', 1, now(),  "temp.png"),
(0, 0, 5, '화이팅5', 0, now(),  "temp.png"),
(0, 0, 6, '화이팅6', 1, now(),  "temp.png"),
(0, 0, 7, '화이팅7', 1, now(),  "temp.png");

-- -----------------------------------------------------
-- Table `ssafynergy`.`Challenge_content`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Challenge_content` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Challenge_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `index` INT NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Challenge_content_Challenge1_idx` (`Challenge_id` ASC) VISIBLE,
  CONSTRAINT `fk_Challenge_content_Challenge1`
    FOREIGN KEY (`Challenge_id`)
    REFERENCES `ssafynergy`.`Challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Challenge_Like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Challenge_Like` (
  `User_id` VARCHAR(30) NOT NULL,
  `Challenge_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`User_id`, `Challenge_id`),
  INDEX `fk_User_has_Challenge_Challenge2_idx` (`Challenge_id` ASC) VISIBLE,
  INDEX `fk_User_has_Challenge_User2_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Challenge_User2`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Challenge_Challenge2`
    FOREIGN KEY (`Challenge_id`)
    REFERENCES `ssafynergy`.`Challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `Challenge_id` INT NOT NULL,
  `User_id` VARCHAR(30) NOT NULL,
  `rating` INT NOT NULL DEFAULT 5,
  PRIMARY KEY (`id`),
  INDEX `fk_Review_Challenge1_idx` (`Challenge_id` ASC) VISIBLE,
  INDEX `fk_Review_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Review_Challenge1`
    FOREIGN KEY (`Challenge_id`)
    REFERENCES `ssafynergy`.`Challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Review_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Board_Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Board_Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `is_authorized` TINYINT NOT NULL DEFAULT 0,
  `writer_type` TINYINT NOT NULL DEFAULT 0,
  `reviewer_type` TINYINT NOT NULL DEFAULT 0,
  `like_type` TINYINT NOT NULL DEFAULT 1,
  `is_challenge` TINYINT NULL DEFAULT 0,
  `Challenge_id` INT NULL DEFAULT -1,
  PRIMARY KEY (`id`),
  INDEX `fk_Board_Category_Challenge1_idx` (`Challenge_id` ASC) VISIBLE,
  CONSTRAINT `fk_Board_Category_Challenge1`
    FOREIGN KEY (`Challenge_id`)
    REFERENCES `ssafynergy`.`Challenge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` DATETIME NOT NULL,
  `User_id` VARCHAR(30) NOT NULL,
  `Board_Category_id` INT NOT NULL,
  `view_cnt` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_Board_User1_idx` (`User_id` ASC) VISIBLE,
  INDEX `fk_Board_Board_Category1_idx` (`Board_Category_id` ASC) VISIBLE,
  CONSTRAINT `fk_Board_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Board_Board_Category1`
    FOREIGN KEY (`Board_Category_id`)
    REFERENCES `ssafynergy`.`Board_Category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Board_Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Board_Review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Board_id` INT NOT NULL,
  `User_id` VARCHAR(30) NOT NULL,
  `content` VARCHAR(500) NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Board_Review_Board1_idx` (`Board_id` ASC) VISIBLE,
  INDEX `fk_Board_Review_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Board_Review_Board1`
    FOREIGN KEY (`Board_id`)
    REFERENCES `ssafynergy`.`Board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Board_Review_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafynergy`.`Board_Like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafynergy`.`Board_Like` (
  `User_id` VARCHAR(30) NOT NULL,
  `Board_id` INT NOT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`User_id`, `Board_id`),
  INDEX `fk_User_has_Board_Board1_idx` (`Board_id` ASC) VISIBLE,
  INDEX `fk_User_has_Board_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Board_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `ssafynergy`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Board_Board1`
    FOREIGN KEY (`Board_id`)
    REFERENCES `ssafynergy`.`Board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
