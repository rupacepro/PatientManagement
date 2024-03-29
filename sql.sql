create database patientrecords;

CREATE TABLE `patientrecords`.`patients` (
  `patientsId` INT NOT NULL,
  `name` VARCHAR(60) NULL,
  `contact` VARCHAR(60) NULL,
  `reason` VARCHAR(200) NULL,
  `disease` VARCHAR(60) NULL,
  `visitDate` DATE NULL,
  PRIMARY KEY (`patientsId`));

