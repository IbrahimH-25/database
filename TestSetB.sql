GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists User2; 
CREATE TABLE if not exists User2( 
    email VARCHAR(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    clientID VARCHAR(20) NOT NULL, 
	creditCard VARCHAR(20) NOT NULL, 
    phoneNum VARCHAR(20) NOT NULL, 
    adress_street_num VARCHAR(4) , 
    adress_street VARCHAR(30) , 
    adress_city VARCHAR(20), 
    adress_state VARCHAR(2),
    adress_zip_code VARCHAR(5),
    PRIMARY KEY (email) ); 
    insert into User2(email, firstName, lastName, password, clientID, creditCard, phoneNum ,adress_street_num, adress_street, adress_city, adress_state, adress_zip_code)
    values ('susie@gmail.com', 'Susie ', 'Guzman', 'susie1234', '000001', '4740076302131963','5554801283' ,'1234','whatever street', 'detroit', 'MI', '48202'),
            ('sophie@gmail.com', 'Sophie', 'Pierce','sophie1234', '000002', '4715394634405687', '5554801232','4321','yolos street', 'ides', 'CM', '24680'),
            ('angelo@gmail.com', 'Angelo', 'Francis','angelo1234', '000003', '4182884872690531', '5554809582' ,'2643','egypt street', 'lolas', 'DT', '13579'),
            ('rudy@gmail.com', 'Rudy', 'Smith','rudy1234', '000004', '4423945702309771','5554809184' ,'1231','sign street', 'samo ne tu','MH', '09876'),
            ('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '000005', '4914738193918094', '5554808461','8471','john street', 'wayne', 'MI', '47182'),
            ('ruby@gmail.com', 'Ruby ', 'Smith','ruby1234', '000006', '1084710191821739', '5551384919','8130','lemon street', 'colombus', 'OH', '18048'),
            ('grace@gmail.com', 'Grace ', 'Randy','Grace1234', '000007', '1092831748109481', '5551381923','4728','apple street', 'colombus', 'OH', '13918'),
            ('jean@gmail.com', 'Jean ', 'Stone','jean1234', '000008', '1848190128471092', '5554820481','4819','grape street', 'novi', 'MI', '48174'),
            ('ralph@gmail.com', 'Ralph ', 'Randy','Ralph1234', '000009', '8458101941101913', '5551848091','9184','jame street', 'jameville', 'DT', '76839'),
            ('grandy@gmail.com', 'Grandy ', 'Grody','grandy1234', '000010', '5739101393801928', '5559999999','1849','hearth street', 'woji', 'HW', '39184'),
            ('root', 'default', 'default','pass1234', '000000', '0000000000000000', '5554807492','0000','Default', 'Default', '0', '00000');
    
    

drop table if exists Quotes2; 
CREATE TABLE if not exists Quotes2( 
    orderID VARCHAR(10) NOT NULL, 
    quoteStatus VARCHAR(50) NOT NULL, 
    initialPrice int NOT NULL, 
    quotesTimesResent int NOT NULL,
	note VARCHAR(100) NOT NULL, 
    PRIMARY KEY (orderID) ); 
    insert into Quotes2(orderID, quoteStatus, initialPrice,quotesTimesResent,note)
    values ('000000', 'notsent', 1,0,'lipsumOrum'),
    ('000009','quoteFromClient',2000,0,'5000 is too much for me'),
    ('000001','quoteFromContractor',6000,0,'Initial Response Fom Contractor for 6000'),
	('000002','quoteFromContractor',9000,2,'Response Fom Contractor for 9000'),
	('000003','quoteFromContractor',5000,0,'Initial Response Fom Contractor for 5000'),
	('000004','quoteFromClient',1000,0,'this works for me'),
	('000005','quoteFromClient',600,3,'highest i can spend right now'),
	('000006','quoteFromClient',7000,4,'I need more work done'),
	('000010','Accepted',8500,0,'Looks good'),
	('000011','Accepted',6000,2,'Better be worth it'), 
    ('000012','Accepted',10000,1,'Thanks So Much'), 
    ('000013','Accepted',8000,5,'Finally happy to finish this'), 
    ('000014','Accepted',3000,2,'Thanks for cutting the small trees'), 
	('000015','Accepted',1030,2,''), 
    ('000007','Ended',7000,10,'Wont work for me');


drop table if exists Bills2; 
CREATE TABLE if not exists Bills2( 
    billId VARCHAR(50) NOT NULL, 
    billPaid int NOT NULL, 
	billStatus VARCHAR(100) NOT NULL, 
    billDays int Not Null,
    billDaysToPay int Not NUll,
	billDiscount VARCHAR(10) NOT NULL,
    billTotal int NOT NULL,
    PRIMARY KEY (billId) ); 
    insert into Bills2(billId, billPaid, billStatus,billDays,billDaysToPay,billDiscount,billTotal)
    values ('000000', 10000, 'Paying', 3,30,"0%", 30000),
    ('000009',0,'Paid',0,30,"0%",1030),
    ('000001',1300,'Paying',4,30,"0%",10000),
	('000002',1999,'Paying',7,30,"0%",1999),
	('000003',2330,'Paying',18,30,"10%",8500),
	('000004',1400,'Paying',5,30,"0%",8000),
    ('000005',3000,'Overdue',8,7,"0%",6000),
    ('000007',1039,'Paying',4,30,"20%",3000);

drop table if exists Tree2; 
CREATE TABLE if not exists Tree2( 
    treeID VARCHAR(10) NOT NULL, 
    clientID VARCHAR(10) NOT NULL,
    size int NOT NULL, 
    height int NOT NULL, 
	location VARCHAR(100) NOT NULL, 
    treeStatus VARCHAR(20) NOT NULL,
	photo1 longblob NOT NULL,
	photo2 longblob NOT NULL,
	photo3 longblob NOT NULL,
    PRIMARY KEY (treeID) ); 
    insert into Tree2(treeID, clientID, size, height, location, treeStatus,photo1, photo2, photo3)
    values ('000001','000008',8, 25,'yes','cut','yes','yes','yes'),
    ('000002','000003',14, 100,'yes','cut','yes','yes','yes'),
    ('000003','000005',9, 27,'yes','cut','yes','yes','yes'),
    ('000004','000010',10, 30,'yes','cut','yes','yes','yes'),
    ('000005','000001',12, 60,'yes','uncut','yes','yes','yes'),
    ('000006','000001',13, 70,'yes','cut','yes','yes','yes'),
    ('000007','000007',4, 12,'yes','cut','yes','yes','yes'),
    ('000008','000007',5, 13,'yes','uncut','yes','yes','yes'),
    ('000009','000007',8, 20,'yes','cut','yes','yes','yes'),
    ('000010','000005',6, 18,'yes','cut','yes','yes','yes'),
    ('000011','000012',8, 22,'yes','cut','yes','yes','yes'),
    ('000012','000008',13, 67,'yes','cut','yes','yes','yes')
    ;
    
drop table if exists Contractor2; 
CREATE TABLE if not exists Contractor2( 
    clientID VARCHAR(10) NOT NULL, 
    billID VARCHAR(10), 
    orderID VARCHAR(10) NOT NULL, 
    PRIMARY KEY (clientID) ); 
    insert into Contractor2(clientID, billID, orderID)
    values ('000003', '000003', '000010'),
    ('000001', '000005', '000011'),
    ('000005', '000001', '000012'),
    ('000008', '000004', '000013'),
    ('000007', '000007', '000014'),
	('000010', '000009', '000015'),
    ('000002', '000000', '000002'),
    ('000004', '000000', '000004'),
    ('000006', '000000', '000006'),
    ('000009', '000000', '000009')
    ;