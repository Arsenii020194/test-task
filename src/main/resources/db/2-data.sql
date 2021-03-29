insert into LIST.CURRENCY(CODE)
values ('USD'),
       ('EUR'),
       ('RUB');
insert into LIST.OPERATION_TYPE(CODE)
values ('DEPOSIT'),
       ('WITHDRAWAL');
insert into BANK.USER(NAME)
values ('user1'),
       ('user2'),
       ('user3');
insert into BANK.USER_ACCOUNT(ID_USER,
                              ID_CURRENCY,
                              NAME,
                              AMOUNT)
values (1, 1, '11111111111', 1028.22),
       (1, 2, '22222222222', 1028.22),
       (1, 3, '33333333333', 1028.22),
       (2, 1, '44444444444', 1028.22),
       (2, 2, '55555555555', 1028.22),
       (2, 3, '66666666666', 1028.22),
       (3, 1, '77777777777', 1028.22),
       (3, 2, '88888888888', 1028.22),
       (3, 3, '99999999999', 1028.22);