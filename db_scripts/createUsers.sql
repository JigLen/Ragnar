CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  User_id INT NOT NULL,
  Password VARCHAR(45) NULL,
  Access_Level INT NOT NULL,
  PRIMARY KEY (User_id))
ENGINE = InnoDB;