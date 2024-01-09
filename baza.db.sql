BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Drzava" (
	"Drzava_id"	INTEGER,
	"Naziv"	TEXT,
	"Glavni_grad"	INTEGER,
	PRIMARY KEY("Drzava_id")
);
CREATE TABLE IF NOT EXISTS "Grad" (
	"Grad_id"	INTEGER,
	"Naziv"	TEXT,
	"Broj_stanovnika"	INTEGER,
	"Drzava"	INTEGER,
	PRIMARY KEY("Grad_id"),
	FOREIGN KEY("Drzava") REFERENCES "Drzava"("Drzava_id")
);
INSERT INTO "Drzava" VALUES (1,'Fracuska',1);
INSERT INTO "Drzava" VALUES (2,'Velika Britanija',2);
INSERT INTO "Drzava" VALUES (3,'Austrija',3);
INSERT INTO "Grad" VALUES (1,'Pariz',2200000,1);
INSERT INTO "Grad" VALUES (2,'London',8300000,2);
INSERT INTO "Grad" VALUES (3,'Bec',1800000,3);
INSERT INTO "Grad" VALUES (4,'Mancester',570000,2);
INSERT INTO "Grad" VALUES (5,'Graz',250000,3);
COMMIT;
