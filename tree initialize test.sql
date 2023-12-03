GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists tree; 
CREATE TABLE if not exists tree( 
    treeID VARCHAR(10) NOT NULL, 
    size VARCHAR(10) NOT NULL, 
    height  VARCHAR(10) NOT NULL, 
	location  VARCHAR(50) NOT NULL, 
    PRIMARY KEY (treeID) ); 
    insert into tree(treeID, size, height,location)
    values ('000000', '0 ', '0','yonder');
select * from tree;            