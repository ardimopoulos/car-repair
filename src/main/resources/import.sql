insert into user (email,password,user_type) values("ioannis@ioannou.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",false);
insert into user (email,password,user_type) values("georgios@georgiou.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",false);
insert into user (email,password,user_type) values("akis@akis.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",true);
insert into user (email,password,user_type) values("tsapas@gmail.gr","$2a$10$/1vpOmGiECBAdjklH8sfYexhlxWWrp5KA.wA9E4K2YjVf8ZI5asqe",true);

insert into member (address,firstname,lastname,vat,user_id)  values('Karpenisiou 3','loannis','Ioannou','123234345',1);
insert into member (address,firstname,lastname,vat,user_id)  values('Kavalas 12','Georgios','Georgiou','123345789',2);
insert into member (address,firstname,lastname,vat,user_id)  values('Athinas 8','Akis','Dimopoulos','456852397',3);
insert into member (address,firstname,lastname,vat,user_id)  values('Kabalas 10','Kostas','Poulakakis','222312312',4);

INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'BMW', 'Red', 'Model1', 'ABC-1234', '2017-01-01', 1);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Toyota', 'Blue', 'Model1', 'KEF-1234', '2012-01-01', 2);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Nissan', 'Black', 'Model1', 'BHI-1234', '1999-01-01', 3);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Scoda', 'White', 'Model1', 'AKL-1234', '2000-01-01', 4);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'BMW', 'Red', 'Model1', 'ABC-4321', '2002-01-01', 4);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Toyota', 'Blue', 'Model1', 'HHH-4321', '2014-01-01', 3);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Nissan', 'Black', 'Model1', 'XHI-4321', '2014-01-01', 2);
INSERT INTO vehicle ( brand, color, model, plate, year, user_id) VALUES ( 'Scoda', 'White', 'Model1', 'OPI-4321', '2014-01-01', 1);

insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 11:00:00','100', 'This is a description1', '0', false,1);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 12:00:00','100', 'This is a description2', '1',  true,2);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 13:00:00','100', 'This is a description3', '2',  false,3);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 10:00:00','100', 'This is a description4', '0',  true,4);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 09:00:00','100', 'This is a description1', '0', false,1);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 08:00:00','100', 'This is a description2', '1',  true,2);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 07:00:00','100', 'This is a description3', '2',  false,3);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:30:00','100', 'This is a description4', '0',  true,4);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:45:00','100', 'This is a description1', '0', false,1);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:15:00','100', 'This is a description2', '1',  true,2);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 20:15:00','100', 'This is a description3', '2',  false,3);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 19:30:00','100', 'This is a description4', '0',  true,4);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 14:45:00','100', 'This is a description1', '0', false,1);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:00:00','100', 'This is a description2', '1',  true,2);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:00:00','100', 'This is a description3', '2',  false,3);
insert into repair ( repair_date, cost, description, status, type, vehicle_id) VALUES ('2017-10-25 15:00:00','100', 'This is a description4', '0',  true,4);





