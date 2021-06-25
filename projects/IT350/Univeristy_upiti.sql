/* 
1. Naći sve predmete koji se drže na nekom studijskom programu (odaberi neki koji imaš u bazi) i nose 6 ili više espb.
   Prikazati uz naziv predmeta i profesora koji drži predmet.
2. Naći studenta koji ima najveću ocenu za predati projekat.
3. Naći broj predmeta za svakog profesora, ne prikazivati profesore koji drže manje od jednog predmeta.
4. Naći sve testove koji imaju maksimalan broj pitanja. (Npr. mogu biti 3 testa sa istim, najvećim brojem pitanja) Sortirati ih po date_sent.
5. Za svaki studijski program čiji naziv sadrži reč 'info' prikazati profesore koji drže neke predmete na njemu.
   Rezultate sortirati po nazivu Studijskog programa po nazivu opadajuće, i po broju esbp rastuće.
*/


/* 1. */
SELECT `subject_id`, `subject_code`, `subject_name`, `espb` FROM `subject`
JOIN program_subject ps ON subject_id = ps.subject_fk
JOIN study_program sp ON sp.program_id = ps.program_fk
WHERE espb > 6 AND sp.program_id = 3

/* 2. */
SELECT `name`, `surname`, MAX(`points`) AS `max_project_points` FROM `person`
JOIN student s ON person.person_id = s.person_fk
JOIN student_obligation so ON s.student_id = so.student_fk
JOIN obligation_definition od ON od.obligation_definition_id = so.obligation_definition_fk
JOIN grading g ON s.student_id = g.student_fk
WHERE g.obligation_definition_fk = 16

/* 3. */
SELECT COUNT(subject_id) as `broj_predmeta`, `name`, `surname` FROM `person`
JOIN professor p on person.person_id = p.person_fk
JOIN subject s on p.professor_id = s.professor_fk
GROUP BY professor_id;

/* 4. */
SELECT MAX(num_of_questions)
FROM (SELECT COUNT(`test_fk`) AS `num_of_questions` FROM question
GROUP BY `test_fk`
ORDER BY `num_of_questions` DESC) as question_num

/* 5. */
SELECT DISTINCT `name`, `surname` FROM person
JOIN professor p on person.person_id = p.person_fk
JOIN subject s on p.professor_id = s.professor_fk
JOIN program_subject ps on s.subject_id = ps.subject_fk
JOIN study_program sp on ps.program_fk = sp.program_id
WHERE sp.program_name LIKE '%info%'
ORDER BY sp.program_name DESC, espb ASC