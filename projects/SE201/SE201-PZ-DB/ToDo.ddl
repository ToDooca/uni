/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     06/01/2021 3:29:24 PM                        */
/*==============================================================*/


drop table if exists employee;

drop table if exists tag;

drop table if exists task;

/*==============================================================*/
/* Table: employee                                              */
/*==============================================================*/
create table employee
(
   employee_id          int not null auto_increment,
   task_id              int not null,
   name                 varchar(64) not null,
   primary key (employee_id)
);

/*==============================================================*/
/* Table: tag                                                   */
/*==============================================================*/
create table tag
(
   tag_id               int not null auto_increment,
   task_id              int not null,
   name                 varchar(64) not null,
   color                varchar(16) not null,
   primary key (tag_id)
);

/*==============================================================*/
/* Table: task                                                  */
/*==============================================================*/
create table task
(
   task_id              int not null auto_increment,
   title                varchar(64) not null,
   description          text,
   image                varchar(512),
   createdat            datetime not null,
   issuetype            varchar(32) not null,
   primary key (task_id)
);

alter table employee add constraint fk_task_employee_fk foreign key (task_id)
      references task (task_id) on delete restrict on update restrict;

alter table tag add constraint fk_task_tag_fk foreign key (task_id)
      references task (task_id) on delete restrict on update restrict;

