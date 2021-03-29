
create schema LIST;
create schema BANK;

create table LIST.CURRENCY
(
    ID SERIAL primary key,
    CODE varchar not null
);

create table LIST.OPERATION_TYPE
(
    ID SERIAL primary key,
    CODE varchar not null
);

create table BANK.USER
(
    ID SERIAL primary key,
    NAME varchar not null
);

create table BANK.USER_ACCOUNT
(
    ID SERIAL primary key,
    ID_USER int not null,
    ID_CURRENCY int not null,
    NAME varchar not null,
    AMOUNT decimal(20, 2) not null,
    foreign key (ID_CURRENCY) references LIST.CURRENCY(ID),
    foreign key (ID_USER) references BANK.USER(ID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table BANK.OPERATION
(
    ID SERIAL primary key,
    ID_TYPE int,
    ID_FROM int,
    ID_TO int,
    DATE date,
    AMOUNT decimal(20, 2) not null,
    foreign key (ID_FROM) references BANK.USER_ACCOUNT(ID),
    foreign key (ID_TO) references BANK.USER_ACCOUNT(ID),
    foreign key (ID_TYPE) references LIST.OPERATION_TYPE(ID)
);