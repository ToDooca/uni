set foreign_key_checks = 0;

drop table if exists question;
create table question
(
    question_id          int auto_increment primary key,
    question_text       varchar(128) not null,
    test_fk              int not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_question_test foreign key (test_fk)
        references test (test_id)  on delete cascade on update cascade
);

drop table if exists answer;
create table answer
(
    answer_id            int     not null auto_increment primary key,
    question_fk          int     not null,
    answer_text          varchar(128) not null,
    correct_answer       tinyint not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_answer_question foreign key (question_fk)
        references question (question_id) on delete cascade on update cascade
);

drop table if exists faculty;
create table faculty
(
    faculty_id           int auto_increment primary key,
    faculty_name         varchar(64) not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1
);

drop table if exists person;
create table person
(
    person_id            int auto_increment primary key,
    jmbg                 varchar(13) not null,
    name                 varchar(64) not null,
    surname              varchar(64) not null,
    phone_number         varchar(32) not null,
    email                varchar(64) not null,
    city_of_birth        varchar(32) not null,
    date_of_birth        date        not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1
);

drop table if exists student;
create table student
(
    student_id           int auto_increment primary key,
    person_fk            int         not null,
    study_type           varchar(16) not null,
    stud_email           varchar(64) not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_student_person foreign key (person_fk)
        references person (person_id) on delete cascade on update cascade
);

drop table if exists professor;
create table professor
(
    professor_id         int auto_increment primary key,
    person_fk            int         not null,
    professor_email      varchar(64) not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_professor_person foreign key (person_fk)
        references person (person_id) on delete cascade on update cascade

);

drop table if exists project;
create table project
(
    project_id           int auto_increment primary key,
    name                 varchar(128) not null,
    abstract             text         not null,
    key_words            text         not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1
);

drop table if exists project_obligation;
create table project_obligation
(
    project_obligation_id int auto_increment primary key,
    project_fk            int          not null,
    -- audit
    `created_date`        timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date`  timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`    varchar(64) default 'system',
    `record_status`       int         default 1,
    constraint fk_project_obligation_project foreign key (project_fk)
        references project (project_id) on delete cascade on update cascade
);

drop table if exists homework;
create table homework
(
    homework_id          int auto_increment primary key,
    `number`             int  not null,
    `text`               text not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1
);

drop table if exists homework_obligation;
create table homework_obligation
(
    homework_obligation_id int auto_increment primary key,
    homework_fk            int          not null,
    -- audit
    `created_date`         timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date`   timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`     varchar(64) default 'system',
    `record_status`        int         default 1,
    constraint fk_homework_obligation_homework foreign key (homework_fk)
        references homework (homework_id) on delete cascade on update cascade
);

drop table if exists test;
create table test
(
    test_id              int auto_increment primary key,
    test_name            varchar(32) not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1
);

drop table if exists test_obligation;
create table test_obligation
(
    test_obligation_id   int auto_increment primary key,
    test_fk              int          not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_test_obligation_test foreign key (test_fk)
        references test (test_id) on delete cascade on update cascade
);

drop table if exists obligation_definition;
create table obligation_definition
(
    obligation_definition_id int auto_increment primary key,
    homework_obligation_fk   int   null,
    project_obligation_fk    int   null,
    test_obligation_fk       int   null,
    max_points      float not null,
    -- audit
    `created_date`           timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date`     timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`       varchar(64) default 'system',
    `record_status`          int         default 1,
    constraint fk_obligation_definition_project_obligation foreign key (project_obligation_fk)
        references project_obligation (project_obligation_id) on delete cascade on update cascade,
    constraint fk_obligation_definition_homework_obligation foreign key (homework_obligation_fk)
        references homework_obligation (homework_obligation_id) on delete cascade on update cascade,
    constraint fk_obligation_definition_test_obligation foreign key (test_obligation_fk)
        references test_obligation (test_obligation_id) on delete cascade on update cascade
);

drop table if exists grading;
create table grading
(
    grading_id               int auto_increment primary key,
    student_fk               int          null,
    professor_fk             int          null,
    obligation_definition_fk int          null,
    file_location            varchar(256) not null,
    points                   real         not null,
    days_late                int          not null,
    -- audit
    `created_date`           timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date`     timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`       varchar(64) default 'system',
    `record_status`          int         default 1,
    constraint fk_grading_student foreign key (student_fk)
        references student (student_id) on delete cascade on update cascade,
    constraint fk_grading_professor foreign key (professor_fk)
        references professor (professor_id) on delete cascade on update cascade,
    constraint fk_grading_obligation_definition foreign key (obligation_definition_fk)
        references obligation_definition (obligation_definition_id) on delete cascade on update cascade
);

drop table if exists subject;
create table subject
(
    subject_id           int auto_increment primary key,
    professor_fk         int         not null,
    subject_code         varchar(5)  not null,
    subject_name         varchar(64) not null,
    espb                 int         not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_subject_professor foreign key (professor_fk)
        references professor (professor_id) on delete cascade on update cascade
);

drop table if exists study_program;
create table study_program
(
    program_id           int auto_increment primary key,
    faculty_fk           int,
    program_name         varchar(32) not null,
    duration             int         not null,
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_study_program_faculty foreign key (faculty_fk)
        references faculty (faculty_id) on delete cascade on update cascade
);

drop table if exists program_subject;
create table program_subject
(
    subject_fk           int not null,
    program_fk           int not null,
    primary key (subject_fk, program_fk),
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_program_subject_subject foreign key (subject_fk)
        references subject (subject_id) on delete cascade on update cascade,
    constraint fk_program_subject_program foreign key (program_fk)
        references study_program (program_id) on delete cascade on update cascade
);

drop table if exists student_obligation;
create table student_obligation
(
    student_obligation_id    int auto_increment primary key,
    student_fk               int          not null,
    obligation_definition_fk int          not null,
    -- audit
    `created_date`           timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date`     timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`       varchar(64) default 'system',
    `record_status`          int         default 1,
    constraint fk_student_obligation_student foreign key (student_fk)
        references student (student_id) on delete cascade on update cascade,
    constraint fk_student_obligation_obligation_definition foreign key (obligation_definition_fk)
        references obligation_definition (obligation_definition_id) on delete cascade on update cascade
);

drop table if exists student_subject;
create table student_subject
(
    student_fk           int not null,
    subject_fk           int not null,
    primary key (student_fk, subject_fk),
    -- audit
    `created_date`       timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_date` timestamp   default CURRENT_TIMESTAMP(),
    `last_modified_by`   varchar(64) default 'system',
    `record_status`      int         default 1,
    constraint fk_student_subject_student foreign key (student_fk)
        references student (student_id) on delete cascade on update cascade,
    constraint fk_student_subject_subject foreign key (subject_fk)
        references subject (subject_id) on delete cascade on update cascade
);

set foreign_key_checks = 1;
