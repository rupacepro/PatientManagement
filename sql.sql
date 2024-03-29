create database patientrecords;

CREATE TABLE `patientrecords`.`patients` (
  `patientId` INT NOT NULL,
  `name` VARCHAR(60) NULL,
  `contact` VARCHAR(60) NULL,
  `reason` VARCHAR(200) NULL,
  `disease` VARCHAR(60) NULL,
  `visitDate` DATE NULL,
  PRIMARY KEY (`patientId`));
  
  
  INSERT INTO `patientrecords`.`patients` (`patientId`, `name`, `contact`, `reason`, `disease`, `visitDate`)
VALUES 
(1, 'Ram Shrestha', '987-654-3210', 'Routine checkup', 'None', '2024-03-29'),
(2, 'Sita Rana', '987-654-3211', 'Headache', 'Migraine', '2024-03-30'),
(3, 'Hari Thapa', '987-654-3212', 'Fever', 'Flu', '2024-03-31'),
(4, 'Parvati Gurung', '987-654-3213', 'Cough', 'Bronchitis', '2024-04-01'),
(5, 'Govinda Pandey', '987-654-3214', 'Abdominal pain', 'Appendicitis', '2024-04-02');

use patientrecords;
select * from patients;


