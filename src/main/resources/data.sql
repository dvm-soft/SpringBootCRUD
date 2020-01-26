/*
create table PERSON
(
    ID          INT auto_increment,
    FIRST_NAME  VARCHAR2(50) not null,
    MID_NAME    VARCHAR2(50),
    SECOND_NAME VARCHAR2(50) not null,
    SEX         BOOLEAN,
    BIRTHDAY    DATE
);

create unique index PERSON_ID_UINDEX
    on PERSON (ID);

alter table PERSON
    add constraint PERSON_PK
        primary key (ID);

*/

INSERT INTO PERSON (first_Name, mid_name, second_name, sex) VALUES ('Ivan', 'Ivanovich', 'Ivanov', 1)

