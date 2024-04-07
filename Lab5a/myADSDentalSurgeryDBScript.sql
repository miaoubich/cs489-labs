CREATE DATABASE surgerydb;
USE surgerydb;
CREATE TABLE Address(
	addressId INT NOT NULL,
    street VARCHAR(45) NOT NULL,
    city VARCHAR(45) NOT NULL,
    state VARCHAR(45) NOT NULL,
    zip VARCHAR(45),
    PRIMARY KEY(addressId)
);
CREATE TABLE Billing(
	billId INT NOT NULL,
    billNumber INT,
    PRIMARY KEY(billId)
);
CREATE TABLE Patient (
  patientId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(45) NOT NULL,
  lastName VARCHAR(45) NOT NULL,
  phoneNumber VARCHAR(10) NOT NULL,
  email VARCHAR(100) NOT NULL,
  dateOfBirth DATE NOT NULL,
  outstandingBill DOUBLE NULL,
  fk_addressId INT NOT NULL,
  fk_billId INT,
  PRIMARY KEY (patientId),
  FOREIGN KEY (fk_addressId) REFERENCES Address(addressId),
  FOREIGN KEY (fk_BillId) REFERENCES Billing(billId)
);
CREATE TABLE Dentist(
	dentistId INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(45),
    lastName VARCHAR(45),
    phoneNumber VARCHAR(10),
    email VARCHAR(100),
    specialization VARCHAR(45),
    PRIMARY KEY(dentistId)
);
CREATE TABLE Appointment(
  dentistId INT NOT NULL,
  patientId INT NOT NULL,
  appointment_date DATE NOT NULL,
  appointment_time TIME NOT NULL,
  appointment_status VARCHAR(45) NOT NULL,
  notificationId INT NOT NULL,
  surgeryId INT,
  PRIMARY KEY (dentistId, patientId),
  FOREIGN KEY (dentistId) REFERENCES Dentist(dentistId),
  FOREIGN KEY (patientId) REFERENCES Patient(patientId)
);

DROP TABLE Appointment;
CREATE TABLE Notification(
	notificationId INT NOT NULL,
    sendNotificationEmail VARCHAR(45),
    sendConfirmationEmail VARCHAR(45)
);
CREATE TABLE Role(
 roleId INT NOT NULL,
 startDate DATE NOT NULL,
 stopDate DATE not NULL
);
CREATE TABLE Office_Manager(
	officeManager INT NOT NULL,
    roleId INT,
    notificationId INT
);
SHOW tables;
ALTER TABLE Office_Manager
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (notificationId) REFERENCES Notification(notificationId);
ALTER TABLE Office_Manager;
DROP TABLE Office_Manager;
SHOW TABLES;
SELECT *FROM Patient;
SELECT *FROM Appointment;
SELECT *FROM Address;
SELECT *FROM Billing;
SELECT *FROM appointment;
SELECT *FROM dentist;
SELECT *FROM notification;
SELECT *FROM office_manager;
SELECT *FROM role_tble;
SELECT *FROM surgery;

Alter Table role RENAME To role_tble;
ALTER TABLE Patient ADD COLUMN roleId INT;

INSERT INTO surgery VALUES(1,'IUSergury', 31756985,2),
(2,'ASD', 36985245,3),
(3,'CA_One', 65485236,1),
(4,'ASD', 36985245,2);

SELECT dentistId FROM Dentist order by lastName ASC;
       
SELECT DISTINCT ap.dentistId,ap.appointment_date,ap.appointment_time, ap.appointment_status,
    p.firstName,p.lastname,p.phoneNumber, p.email, p.dateOfBirth, p.outstandingBill,
    b.billNumber,
    ad.street, ad.city, ad.state, ad.zip
FROM 
    Appointment ap, Dentist d, Patient p, Address ad, Billing b
WHERE ap.dentistId = d.dentistId
AND ap.patientId = p.patientId
AND p.fk_addressId=ad.addressId
AND p.fk_billId=b.billId
AND ap.dentistId=2;

SELECT ap.appointment_date, ap.appointment_time, ap.appointment_status 
FROM Appointment ap, Surgery s, Address ad
WHERE ap.surgeryId=s.surgeryId
AND s.addressId=ad.addressId
AND ad.city='Des moines';

SELECT *FROM surgery;
SELECT *FROM Address;