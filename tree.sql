GRANT ALL PRIVILEGES ON *.* TO 'john'@'localhost';
CREATE DATABASE if not exists DavesTimber;
FLUSH PRIVILEGES;
use DavesTimber;
drop table if exists Tree; 
CREATE TABLE if not exists Tree( 
    treeID VARCHAR(10) NOT NULL, 
    size VARCHAR(10) NOT NULL, 
    height VARCHAR(10) NOT NULL, 
	location VARCHAR(100) NOT NULL, 
	photo1 longblob NOT NULL,
	photo2 longblob NOT NULL,
	photo3 longblob NOT NULL,
    PRIMARY KEY (treeID) ); 
    insert into Tree(treeID, size, height, location, photo1, photo2, photo3)
    values ('000001', '8 feet', '25 feet','yes');
select * from Tree;            
