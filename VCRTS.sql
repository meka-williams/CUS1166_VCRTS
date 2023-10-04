create database VCRTS;

use VCRTS;

CREATE TABLE Owner	(
	ownerID VARCHAR(6),
    vehicleMake VARCHAR(20),
    vehicleModel VARCHAR(20),
    vehiclePlate VARCHAR(20),
    residencyTime DATETIME
    );
    
CREATE TABLE Client	(
	clientID VARCHAR(6),
    jobDuration TIME,
    jobDeadline DATETIME
    );
    
    
    
    
    
