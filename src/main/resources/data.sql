/*
create table PERSON
(
    ID          INT auto_increment,
    FIRST_NAME  VARCHAR2(50) not null,
    MID_NAME    VARCHAR2(50),
    SECOND_NAME VARCHAR2(50) not null,
    GENDER         BOOLEAN,
    BIRTHDAY    DATE
);

create unique index PERSON_ID_UINDEX
    on PERSON (ID);

alter table PERSON
    add constraint PERSON_PK
        primary key (ID);

*/

INSERT INTO PERSON (first_Name, mid_name, last_name, gender, birthday) VALUES ('Ivan', 'Ivanovich', 'Ivanov', 1, to_date('10.03.1972', 'DD.MM.YYYY'))

