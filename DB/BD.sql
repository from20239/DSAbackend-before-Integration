DROP DATABASE Projecte_DSA;
CREATE DATABASE Projecte_DSA;
USE Projecte_DSA;

--USER INFORMATION TABLE
CREATE TABLE User(
	id VARCHAR(36) NOT NULL PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	mail VARCHAR(255) NOT NULL,
	money DOUBLE DEFAULT 50,
	puntos INTEGER DEFAULT 0,
    level INTEGER DEFAULT 1
);

--OBJECT INFORMATION TABLE
CREATE TABLE StoreObject(
	id VARCHAR(255) NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	price DOUBLE NOT NULL,
    description VARCHAR(1024) NOT NULL,
	url VARCHAR(255)
);

INSERT INTO StoreObject(id, name, price, url, description) VALUES ("innerWall", "Caja", 1, "images/innerWall.png", "Obstáculo del mapa");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("innerWall2", "Piedras", 1, "images/innerWall2.png", "Obstáculo del mapa");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("outerWall", "Pared", 1, "images/outerWall.png", "Pared para delimitar el área del nivel");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("food", "Moneda", 3, "images/coin.png", "Monedas para comprar más ítems");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("player", "Jugador", 7, "images/player.png", "Posición incial del jugador. Sólo se puede colocar uno por partida.");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("enemy", "Serpiente", 3, "images/enemy.png", "Enemigos del juego");
INSERT INTO StoreObject(id, name, price, url, description) VALUES ("exit", "Salida", 10, "images/exit.png", "Punto final del nivel. Sólo se puede colocar uno por partida");

--INVENTORY TABLE OF ALL USERS
CREATE TABLE Inventory(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
	userID VARCHAR(36),
	objectID VARCHAR(36),
	quantity INTEGER NOT NULL,
	FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE,
	FOREIGN KEY (objectID) REFERENCES StoreObject(id) ON DELETE CASCADE
);

--EXISTING LEVELS TABLE
CREATE TABLE CustomLevel(
	id VARCHAR(36) NOT NULL PRIMARY KEY,
	userId VARCHAR(36) NOT NULL,
	levelName VARCHAR(255),
	FOREIGN KEY (userId) REFERENCES User(id) ON DELETE CASCADE
);

--LEVEL INFORMATION TABLE
CREATE TABLE MapElement(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    elementId VARCHAR(255) NOT NULL,
	levelId VARCHAR(36) NOT NULL,
	x INTEGER NOT NULL,
	y INTEGER NOT NULL,
	FOREIGN KEY (levelId) REFERENCES CustomLevel(id) ON DELETE CASCADE
);

--PLAYED GAMES TABLE
CREATE TABLE Game(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
	userID VARCHAR(36),
	levelID VARCHAR(36),
	totalTime DATETIME NOT NULL,
	pointsGiven INTEGER NOT NULL,
	FOREIGN KEY (userID) REFERENCES User(id) ON DELETE CASCADE,
	FOREIGN KEY (levelID) REFERENCES CustomLevel(id) ON DELETE CASCADE
);

