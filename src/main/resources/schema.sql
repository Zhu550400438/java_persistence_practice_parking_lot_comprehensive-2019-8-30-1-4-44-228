CREATE TABLE parkingboy (
  employeeId INTEGER PRIMARY KEY,
  name VARCHAR(16)
);

CREATE TABLE parkinglot (
  prakingLotId INTEGER PRIMARY KEY,
  capacity INTEGER,
  availablePositionCount INTEGER
);

CREATE TABLE relationship (
  id INTEGER IDENTITY PRIMARY KEY,
  parkingboyId INTEGER,
  parkingLotId INTEGER
);

INSERT INTO parkingboy values (1, 'parkingboy_1');

INSERT INTO parkingboy values (2, 'parkingboy_2');

INSERT INTO parkingboy values (3, 'parkingboy_3');

INSERT INTO parkingboy values (4, 'parkingboy_4');

INSERT INTO parkingboy values (5, 'parkingboy_5');

INSERT INTO parkingboy values (6, 'parkingboy_6');

INSERT INTO parkinglot values (1, 10, 10);

INSERT INTO parkinglot values (2, 11, 11);

INSERT INTO relationship (parkingboyId, parkingLotId) values (1, 1);

INSERT INTO relationship (parkingboyId, parkingLotId) values (1, 2);
