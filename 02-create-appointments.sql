-- -----------------------------------------------------
-- Schema clinic-management-system
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `clinic-management-system`;

CREATE SCHEMA `clinic-management-system`;
USE `clinic-management-system` ;

-- -----------------------------------------------------
-- Table `clinic-management-system`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic-management-system`.`patient` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `clinic-management-system`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic-management-system`.`appointment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) DEFAULT NULL,
  `patient_name` VARCHAR(255) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `diagnose_price` DECIMAL(13,2) DEFAULT NULL,
  `contact_number` VARCHAR(255) DEFAULT NULL,
  `appointment_status` ENUM('COMPLETED', 'NOT_COMPLETED'),
  `active` BIT DEFAULT 1,
  `employee_id` BIGINT(11) DEFAULT NULL,
   `date_created` DATETIME(6) DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  `patient_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_patient` (`patient_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------

INSERT INTO patient(first_name) VALUES ('');

INSERT INTO appointment (title, patient_name, description, diagnose_Price, active, contact_number,
appointment_status, patient_id, date_created)
VALUES ('Go to clinic 14', 'Abdel-kader', 'Get some meds',
'10.10'
,1,01005264857,NOT_COMPLETED,1, NOW());



