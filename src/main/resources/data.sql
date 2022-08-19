insert into course
(id,name,last_Update_Date,created_Date)
values(2001L,'Chemistry',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course
(id,name,last_Update_Date,created_Date)
values(2002L,'Math',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course
(id,name,last_Update_Date,created_Date)
values(2003L,'English',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into Passport
(id,number)
values(60001,'NJNSDFHI4785');
insert into Passport
(id,number)
values(60002,'JGJGGUIE89989');
insert into Passport
(id,number)
values(60003,'HJUU68898990');

insert into Student
(id,name,Passport_id)
values(40001,'Rohit',60001);
insert into Student
(id,name,Passport_id)
values(40002,'Pratiksha',60002);
insert into Student
(id,name,Passport_id)
values(40003,'Amit',60003);



insert into Review
(id,rating,description)
values(80001,'1','Great Course');
insert into Review
(id,rating,description)
values(80002,'2','Good one');
insert into Review
(id,rating,description)
values(80003,'3','Average');
