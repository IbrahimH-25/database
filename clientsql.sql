GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists Quotes; 
CREATE TABLE if not exists Quotes( 
    orderID VARCHAR(10) NOT NULL, 
    quoteStatus VARCHAR(10) NOT NULL, 
    initialPrice VARCHAR(10) NOT NULL, 
	note VARCHAR(100) NOT NULL, 
    PRIMARY KEY (orderID) ); 
    insert into Quotes(orderID, quoteStatus, initialPrice,note)
    values ('000000', 'notsent', '0','lipsumOrum');
select * from Quotes;            