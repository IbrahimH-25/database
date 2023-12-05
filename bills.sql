GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists Bills; 
CREATE TABLE if not exists Bills( 
    billId VARCHAR(50) NOT NULL, 
    billPaid VARCHAR(10) NOT NULL, 
	billStatus VARCHAR(100) NOT NULL, 
    PRIMARY KEY (billId) ); 
    insert into Bills(billId, billPaid, billStatus)
    values ('000000', '10000', 'Paying'),('000009','0','Paid'),('000006','1300','Overdue'),('000007','1039','Paying');
select * from Bills;  