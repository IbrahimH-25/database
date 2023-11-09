GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists Contractor; 
CREATE TABLE if not exists Contractor( 
    clientID VARCHAR(10) NOT NULL, 
    billID VARCHAR(10) NOT NULL, 
    orderID VARCHAR(10) NOT NULL, 
    PRIMARY KEY (clientID) ); 
    insert into Contractor(clientID, billID, orderID)
    values ('000000', '000000 ', '000000');
select * from User;            