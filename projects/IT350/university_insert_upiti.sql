INSERT INTO `faculty`(`faculty_name`) VALUES ('FIT');
INSERT INTO `faculty`(`faculty_name`) VALUES ('FDU');
INSERT INTO `faculty`(`faculty_name`) VALUES ('FAM');

INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('9876543212345', 'Tamara', 'Vukadinovic', '060777888', 'tamara@gmail.com', 'Nis', '1996-01-20');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('2564345165436', 'Marina', 'Damnjanovic', '06748453', 'marina@gmail.com', 'Nis', '1994-5-24');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('9876543212345', 'Nikola', 'Dimitrijevic', '060535331', 'nikola@gmail.com', 'Nis', '1985-02-17');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('6575487456745', 'Svetlana', 'Smolcic', '064757855', 'svetlana@gmail.com', 'Nis', '1992-04-28');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('2146456412231', 'Tijana', 'Pavlov', '0667575754', 'tijana@gmail.com', 'Beograd', '1987-10-09');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('6758646956334', 'Stefan', 'Alimpic', '06273566693', 'stefan@gmail.com', 'Nis', '1990-04-04');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('0105941241242', 'Tamara', 'Vucenovic', '0642126941', 'tamaravucenovic@gmail.com', 'Beograd', '1991-12-30');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('1234567898765', 'Dusan', 'Stankovic', '0625553333', 'stankovicd941@gmail.com', 'Pristina', '1999-02-08');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('4535246346452', 'Jovan', 'Vujovic', '0615567891', 'crnivuja@gmail.com', 'Nis', '1998-04-15');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('0504942194129', 'Nikola', 'Tasic', '0625322352', '7aske@gmail.com', 'Popovac', '1994-05-04');
INSERT INTO `person`(`jmbg`, `name`, `surname`, `phone_number`, `email`, `city_of_birth`, `date_of_birth`) VALUES ('1234567898765', 'Tomislav', 'Zivadinovic', '0654345525', 'tomcat123@gmail.com', 'Nis', '1999-04-09');

INSERT INTO `study_program`(`faculty_fk`, `program_name`, `duration`) VALUES (1, 'Softversko Inzenjerstvo', 4);
INSERT INTO `study_program`(`faculty_fk`, `program_name`, `duration`) VALUES (1, 'Racunarske igre', 4);
INSERT INTO `study_program`(`faculty_fk`, `program_name`, `duration`) VALUES (1, 'Informacione Tehnologije-3', 3);
INSERT INTO `study_program`(`faculty_fk`, `program_name`, `duration`) VALUES (2, 'Graficki dizajn', 4);
INSERT INTO `study_program`(`faculty_fk`, `program_name`, `duration`) VALUES (3, 'Menadzment', 4);

INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (1, 'tamara.vukadinovic@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (2, 'marina.damnjanovic@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (3, 'nikola.dimitrijevic@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (4, 'svetlana.smolcic@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (5, 'tijana.pavlov@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (6, 'stefan.alimpic@metropolitan.ac.rs');
INSERT INTO `professor`(`person_fk`, `professor_email`) VALUES (7, 'tamara.vucicevic@metropolitan.ac.rs');

INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (1, 'IT350', 'Baze Podataka', 8);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (1, 'CS101', 'Uvod u OOP', 8);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (1, 'IT101', 'Osnove Informacionih Tehnologija', 4);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (2, 'SE201', 'Uvod u softversko inzenjerstvo', 8);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (2, 'SE211', 'Konstruisanje softvera', 6);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (3, 'CS103', 'Algoritmi i strukture podataka', 6);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (3, 'CS230', 'Distribuirani sistemi', 8);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (4, 'AD111', 'Istorija umetnosti', 4);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (4, 'AD113', 'Istorija modnog dizajna', 6);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (5, 'AD131', 'Osnove savremenog odevanja 1', 4);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (6, 'MK470', 'Marketing analize', 8);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (6, 'MK440', 'Marketing planiranje', 6);
INSERT INTO `subject`(`professor_fk`, `subject_code`, `subject_name`, `espb`) VALUES (7, 'MK485', 'Menadzment specijalnih i medijskih dogadjaja', 6);

INSERT INTO `student`(`person_fk`, `study_type`, `stud_email`) VALUES (8, 'traditional', 'dusan.stankovic.3611@metropolitan.ac.rs');
INSERT INTO `student`(`person_fk`, `study_type`, `stud_email`) VALUES (9, 'traditional', 'jovan.vujovic.3860@metropolitan.ac.rs');
INSERT INTO `student`(`person_fk`, `study_type`, `stud_email`) VALUES (10, 'internet', 'nikola.tasic.3698@metropolitan.ac.rs');
INSERT INTO `student`(`person_fk`, `study_type`, `stud_email`) VALUES (11, 'traditional', 'tomislav.zivadinovic.3948@metropolitan.ac.rs');

INSERT INTO `test`(`test_name`) VALUES ('test 1');
INSERT INTO `test`(`test_name`) VALUES ('test 2');
INSERT INTO `test`(`test_name`) VALUES ('test 3');
INSERT INTO `test`(`test_name`) VALUES ('test 4');
INSERT INTO `test`(`test_name`) VALUES ('test 5');

INSERT INTO `test_obligation`(`test_fk`) VALUES (1);
INSERT INTO `test_obligation`(`test_fk`) VALUES (2);
INSERT INTO `test_obligation`(`test_fk`) VALUES (3);
INSERT INTO `test_obligation`(`test_fk`) VALUES (4);
INSERT INTO `test_obligation`(`test_fk`) VALUES (5);

INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 2+2', 1);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 4+6', 1);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 2+9', 1);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 1+1', 2);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 1+2', 2);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koja je formula vode', 3);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Jel ide gas', 3);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 10+5', 3);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 11+9', 4);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 4+21', 4);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 4+4', 5);
INSERT INTO `question`(`question_text`, `test_fk`) VALUES ('Koliko je 8+15', 5);

INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (1, '3', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (1, '4', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (1, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (1, '6', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (2, '12', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (2, '9', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (2, '10', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (2, '11', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (3, '3', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (3, '11', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (3, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (3, '6', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (4, '7', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (4, '2', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (4, '4', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (4, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (5, '1', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (5, '4', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (5, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (5, '3', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (6, 'N2O', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (6, 'NaCl', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (6, 'H2o', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (6, 'H', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (7, 'True', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (7, 'False', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (8, '1', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (8, '20', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (8, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (8, '15', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (9, '1', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (9, '4', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (9, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (9, '3', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (10, '26', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (10, '14', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (10, '52', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (10, '25', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (11, '1', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (11, '4', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (11, '5', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (11, '8', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (12, '23', 1);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (12, '22', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (12, '25', 0);
INSERT INTO `answer`(`question_fk`, `answer_text`, `correct_answer`) VALUES (12, '29', 0);



INSERT INTO `homework`(`number`, `text`) VALUES (1, 'tekst domaceg zadatka 1');
INSERT INTO `homework`(`number`, `text`) VALUES (2, 'tekst domaceg zadatka 2');
INSERT INTO `homework`(`number`, `text`) VALUES (3, 'tekst domaceg zadatka 3');
INSERT INTO `homework`(`number`, `text`) VALUES (4, 'tekst domaceg zadatka 4');
INSERT INTO `homework`(`number`, `text`) VALUES (5, 'tekst domaceg zadatka 5');
INSERT INTO `homework`(`number`, `text`) VALUES (6, 'tekst domaceg zadatka 6');
INSERT INTO `homework`(`number`, `text`) VALUES (7, 'tekst domaceg zadatka 7');
INSERT INTO `homework`(`number`, `text`) VALUES (8, 'tekst domaceg zadatka 8');
INSERT INTO `homework`(`number`, `text`) VALUES (9, 'tekst domaceg zadatka 9');
INSERT INTO `homework`(`number`, `text`) VALUES (10, 'tekst domaceg zadatka 10');
INSERT INTO `homework`(`number`, `text`) VALUES (11, 'tekst domaceg zadatka 11');
INSERT INTO `homework`(`number`, `text`) VALUES (12, 'tekst domaceg zadatka 12');
INSERT INTO `homework`(`number`, `text`) VALUES (13, 'tekst domaceg zadatka 13');
INSERT INTO `homework`(`number`, `text`) VALUES (14, 'tekst domaceg zadatka 14');
INSERT INTO `homework`(`number`, `text`) VALUES (15, 'tekst domaceg zadatkak 15');

INSERT INTO `homework_obligation`(`homework_fk`) VALUES (1);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (2);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (3);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (4);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (5);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (6);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (7);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (8);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (9);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (10);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (11);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (12);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (13);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (14);
INSERT INTO `homework_obligation`(`homework_fk`) VALUES (15);

INSERT INTO `project`(`name`, `abstract`, `key_words`) VALUES ('Projektni zadatak', 'Tekst projektnog zadatka', 'kljucna rec');

INSERT INTO `project_obligation`(`project_fk`) VALUES (1);

INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (1, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (2, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (3, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (4, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (5, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (6, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (7, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (8, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (9, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (10, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (11, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (12, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (13, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (14, 2);
INSERT INTO `obligation_definition`(`homework_obligation_fk`, `max_points`) VALUES (15, 2);

INSERT INTO `obligation_definition`(`project_obligation_fk`, `max_points`) VALUES (1, 30);

INSERT INTO `obligation_definition`(`test_obligation_fk`, `max_points`) VALUES (1, 2);
INSERT INTO `obligation_definition`(`test_obligation_fk`, `max_points`) VALUES (2, 2);
INSERT INTO `obligation_definition`(`test_obligation_fk`, `max_points`) VALUES (3, 2);
INSERT INTO `obligation_definition`(`test_obligation_fk`, `max_points`) VALUES (4, 2);
INSERT INTO `obligation_definition`(`test_obligation_fk`, `max_points`) VALUES (5, 2);

INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (1, 1);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (2, 1);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (2, 2);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (1, 2);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (1, 3);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (2, 3);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (2, 4);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (1, 10);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (3, 10);
INSERT INTO `student_obligation`(`student_fk`, `obligation_definition_fk`) VALUES (4, 10);

INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (1, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (1, 2);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (1, 3);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (2, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (2, 2);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (2, 3);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (3, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (3, 2);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (3, 3);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (4, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (4, 2);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (4, 3);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (5, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (6, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (6, 3);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (7, 1);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (8, 4);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (9, 4);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (10, 4);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (11, 5);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (12, 5);
INSERT INTO `program_subject`(`subject_fk`, `program_fk`) VALUES (13, 5);

INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 1);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 2);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 3);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 4);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 5);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 6);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (1, 7);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 1);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 2);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 3);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 4);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 5);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 6);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (2, 7);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 1);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 2);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 3);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 4);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 5);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 6);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (3, 7);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 1);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 2);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 3);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 4);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 5);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 6);
INSERT INTO `student_subject`(`student_fk`, `subject_fk`) VALUES (4, 7);

INSERT INTO `grading`(`student_fk`, `professor_fk`, `obligation_definition_fk`, `file_location`, `points`, `days_late`) VALUES (1, 2, 16, 'C:\\Users\\Dusan\\Metropolitan\\IT350\\Projekat', 30, 0);
INSERT INTO `grading`(`student_fk`, `professor_fk`, `obligation_definition_fk`, `file_location`, `points`, `days_late`) VALUES (1, 2, 16, 'C:\\Users\\Vuja\\Metropolitan\\IT350\\Projekat', 25, 0);
INSERT INTO `grading`(`student_fk`, `professor_fk`, `obligation_definition_fk`, `file_location`, `points`, `days_late`) VALUES (3, 2, 16, 'C:\\Users\\7aske\\Metropolitan\\IT350\\Projekat', 29, 0);
INSERT INTO `grading`(`student_fk`, `professor_fk`, `obligation_definition_fk`, `file_location`, `points`, `days_late`) VALUES (4, 2, 16, 'C:\\Users\\Toma\\Metropolitan\\IT350\\Projekat', 18, 4);
