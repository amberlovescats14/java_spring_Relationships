drop database spring_blog;
show databases ;
use spring_blog;
show tables;
select * from vet;
describe pets;

describe vet;

insert into pet_owner (name, email, phone_number)
values ('amber', 'amber@mail.com', '2104296474'),
       ('mom', 'mom@mail.com', '2107059770'),
       ('cami', 'cami@mail.com', '2104202094');

select * from vet;

insert into vet (vet_name, phone_number, pet_owner_id)
values ('pacheco', '2105551234', 2),
       ('pacheco', '2105551234', 1);

insert into pets (name, age, owner_id)
values ('casper', 16, 1);



