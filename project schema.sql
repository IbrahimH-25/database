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
            ('jeannette@gmail.com', 'Jeannette ', 'Stone','jeannette1234', '000005', '4981967026437975', '5554808461','0183','snoop street', 'kojik', 'HW', '87654'),
            ('root', 'default', 'default','pass1234', '000000', '0000000000000000', '5554807492','0000','Default', 'Default', '0', '00000');
select * from User;            