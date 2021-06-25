/* 6. Napisati upit kojim se prikazuje prosečna ocena za svakog studenta na Fakultetu. U
prosečnu ocenu se ne računaju ocene 5, već samo položeni predmeti.*/

SELECT ime, prezime, student.indeks, avg(ocena) AS prosecna_ocena
FROM `student` 
JOIN `overa`
ON overa.indeks = student.indeks
WHERE ocena > 5
GROUP BY student.indeks;

/* 9. Napisati upit kojim se prikazuje prosečna ocena na svakom predmetu na fakultetu. Prikazati
id predmet, naziv I prosečnu ocenu koju su dobili svi student koji su predmet položili. Ne
računati one koji su predmet pali. */

SELECT predmet.predmet_id, naziv, avg(ocena) AS prosecna_ocena
FROM `predmet` 
JOIN `overa`
ON overa.predmet_id = predmet.predmet_id
WHERE ocena > 5
GROUP BY predmet_id;

/* 12. Napisati upit kojim se prikazuju podaci o predmetu koji je položilo najviše studenata. */

SELECT overa.predmet_id, naziv, espb, br_cas_predavanja, br_cas_vezbe
FROM `predmet`
JOIN `overa`
ON overa.predmet_id = predmet.predmet_id
HAVING COUNT(ocena) > 5
ORDER BY COUNT(ocena) DESC;