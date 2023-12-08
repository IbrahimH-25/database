GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists User; 
CREATE TABLE if not exists User( 
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
    insert into User(email, firstName, lastName, password, clientID, creditCard, phoneNum ,adress_street_num, adress_street, adress_city, adress_state, adress_zip_code)
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
    
    

drop table if exists Quotes; 
CREATE TABLE if not exists Quotes( 
    orderID VARCHAR(10) NOT NULL, 
    quoteStatus VARCHAR(50) NOT NULL, 
    initialPrice VARCHAR(10) NOT NULL, 
	note VARCHAR(100) NOT NULL, 
    PRIMARY KEY (orderID) ); 
    insert into Quotes(orderID, quoteStatus, initialPrice,note)
    values ('000000', 'notsent', '1','lipsumOrum'),
    ('000009','quoteFromClient','2000','5000 is too much for me'),
    ('000001','quoteFromContractor','6000','Initial Response Fom Contractor for 6000'),
	('000002','quoteFromContractor','9000','Initial Response Fom Contractor for 9000'),
	('000003','quoteFromContractor','5000','Initial Response Fom Contractor for 5000'),
	('000004','quoteFromClient','1000','this works for me'),
	('000005','quoteFromClient','600','highest i can spend right now'),
	('000006','quoteFromClient','7000','I need more work done'),
	('0000010','Accepted','8500','Looks good'),
	('000008','Accepted','6000','Better be worth it'), 
    ('000007','Ended','7000','Wont work for me');


drop table if exists Bills; 
CREATE TABLE if not exists Bills( 
    billId VARCHAR(50) NOT NULL, 
    billPaid VARCHAR(10) NOT NULL, 
	billStatus VARCHAR(100) NOT NULL, 
    billDiscount VARCHAR(10) NOT NULL,
    billTotal VARCHAR(100) NOT NULL,
    PRIMARY KEY (billId) ); 
    insert into Bills(billId, billPaid, billStatus,billTotal)
    values ('000000', '10000', 'Paying', "0%", 30000),
    ('000009','0','Paid',"0%",1030),
    ('000006','1300','Paying',"0%",1948),
	('000006','1300','Paying',"0%",1999),
	('000006','2330','Paying',"10%",4000),
	('000006','1400','Paying',"0%",4999),
    ('000006','3000','Overdue',"0%",5999),
    ('000007','1039','Paying',"0%",4000);
