insert into user (email,password,user_type) values("ioannis@ioannou.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",false);
insert into user (email,password,user_type) values("georgios@georgiou.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",false);
insert into user (email,password,user_type) values("akis@akis.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",true);
insert into user (email,password,user_type) values("tsapas@gmail.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",true);
insert into member (address,firstname,lastname,vat,user_id)  values('Karpenisiou 3','loannis','Ioannou',123234345,1);
insert into member (address,firstname,lastname,vat,user_id)  values('Kavalas 12','Georgios','Georgiou',123345789,2);
insert into member (address,firstname,lastname,vat,user_id)  values('Athinas 8','Akis','Dimopoulos',456852397,3);
insert into member (address,firstname,lastname,vat,user_id)  values('Kabalas 10','Kostas','Poulakakis',222312312,4);

insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description1', '0', '11:45:00', false, '1');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description2', '1', '10:00:00', true, '2');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description3', '2', '08:45:00', false, '3');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description4', '0', '17:00:00', true, '1');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description5', '1', '19:15:00', false, '3');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description6', '2', '12:45:00', true, '2');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-22', 'This is a description7', '0', '12:30:00', false, '1');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description8', '0', '11:45:00', false, '3');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description9', '0', '11:00:00', true, '2');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description10', '0', '08:00:00', false, '1');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description11', '1', '11:00:00', true, '3');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description12', '2', '09:15:00', false, '1');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description13', '1', '12:15:00', true, '2');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description14', '1', '12:30:00', false, '3');
insert into repair ( date, description, status, time, type, user_id) VALUES ('2017-10-21', 'This is a description14', '1', '12:30:00', false, '4');

INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'BMW', 'Red', '94', 'ABC-1234', '2017-10-21', '1');
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Toyota', 'Blue', '94', 'DEF-1234', '2017-10-21', '2');
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Nissan', 'Black', '94', 'GHI-1234', '2017-10-21', '3');
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Scoda', 'White', '94', 'JKL-1234', '2017-10-21', '4');
