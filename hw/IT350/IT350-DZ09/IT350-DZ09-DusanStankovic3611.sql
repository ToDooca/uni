/* 6.Napisati upit kojim se prikazuju podaci o onim predmetima koji vrede manje od 10 ESPB-a. */

SELECT * FROM `predmet` WHERE espb < 10; 

/* 12.Napisati upit kojim se prikazuju podaci o predmetima koji imaju više od 2 časa vežbanja. */

SELECT * FROM `predmet` WHERE br_cas_vezbe > 2;

/* 24.Napisati upit koji izračunava najveću i prosečnu ocenu po svakoj školskoj godini, po
svakom ispitnom roku i svakom predmetu */

SELECT avg(ocena), max(ocena), predmet_id FROM `overa` GROUP BY predmet_id;
SELECT avg(ocena), max(ocena), datum_overa FROM `overa` GROUP BY datum_overa;
SELECT avg(ocena), max(ocena), godina_roka FROM `overa` GROUP BY godina_roka;