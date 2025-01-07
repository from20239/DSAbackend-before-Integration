DROP DATABASE Projecte_DSA;
CREATE DATABASE Projecte_DSA;
USE Projecte_DSA;

--USER INFORMATION TABLE
CREATE TABLE User(
	id VARCHAR(36) NOT NULL DEFAULT(uuid()),
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	mail VARCHAR(255) NOT NULL,
	money DOUBLE DEFAULT 50,
	puntos INTEGER DEFAULT 0,
	PRIMARY KEY(id)
);

--OBJECT INFORMATION TABLE
CREATE TABLE StoreObject(
	id VARCHAR(36) NOT NULL DEFAULT(uuid()),
	name VARCHAR(255) NOT NULL,
	price DOUBLE NOT NULL,
    description VARCHAR(1024) NOT NULL,
	url VARCHAR(255),
	PRIMARY KEY(id)
);

INSERT INTO StoreObject(name, price, url, description) VALUES ("Plàtan", 3, "images/platano.jpg", "descripció del plàtan");
INSERT INTO StoreObject(name, price, url, description) VALUES ("Pell de plàtan", 1, "images/piel.jpg", "descripció de la pell de plàtan");
INSERT INTO StoreObject(name, price, url, description) VALUES ("Poció màgica", 15, "images/pocion.jpg", "descripció de la poció");

--INVENTORY TABLE OF ALL USERS
CREATE TABLE Inventory(
    id VARCHAR(36) NOT NULL DEFAULT(uuid()) PRIMARY KEY,
	userID VARCHAR(36),
	objectID VARCHAR(36),
	quantity INTEGER NOT NULL,
	FOREIGN KEY (UserID) REFERENCES User(id) ON DELETE CASCADE,
	FOREIGN KEY (ObjectID) REFERENCES StoreObject(id) ON DELETE CASCADE
);

--EXISTING LEVELS TABLE
CREATE TABLE CustomLevel(
	id VARCHAR(36) NOT NULL DEFAULT(uuid()),
	userId VARCHAR(36) NOT NULL,
	levelName VARCHAR(255),
	PRIMARY KEY (id),
	FOREIGN KEY (userId) REFERENCES User(id) ON DELETE CASCADE
);

--LEVEL INFORMATION TABLE
CREATE TABLE MapElement(
    id VARCHAR(36) NOT NULL,
	levelId VARCHAR(36) NOT NULL,
	x INTEGER NOT NULL,
	y INTEGER NOT NULL,
	FOREIGN KEY (levelId) REFERENCES CustomLevel(id) ON DELETE CASCADE
);

--PLAYED GAMES TABLE
CREATE TABLE Game(
    id VARCHAR(36) NOT NULL DEFAULT(uuid()) PRIMARY KEY,
	userID VARCHAR(36),
	levelID VARCHAR(36),
	totalTime DATETIME NOT NULL,
	pointsGiven INTEGER NOT NULL,
	FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE,
	FOREIGN KEY (levelID) REFERENCES CustomLevel(id) ON DELETE CASCADE
);