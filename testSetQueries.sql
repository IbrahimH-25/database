
use DavesTimber;

SELECT clientID from Tree2 As bigClient group by clientID Order by count(clientID) desc, clientID desc LIMIT 1;

SELECT contractor2.clientID from Contractor2 Join quotes2 On contractor2.orderID=quotes2.orderID where quotesTimesResent=0 and quoteStatus='Accepted';

SELECT * from Contractor2 Join tree2 On tree2.clientID=contractor2.clientID Join quotes2 On quotes2.orderID=contractor2.orderID where quotes2.quotesTimesResent=0 and quotes2.quoteStatus='Accepted';
SELECT contractor2.orderID from Contractor2 Join tree2 On tree2.clientID=contractor2.clientID Join quotes2 On quotes2.orderID=contractor2.orderID where quotes2.quoteStatus='Accepted' group by contractor2.orderID having count(contractor2.orderID)=1 ;
SELECT * from Contractor2  Join tree2 On tree2.clientID=Contractor2.clientID Join quotes2 On quotes2.orderID=contractor2.orderID;

SELECT clientID from contractor2 where billID='000000';

SELECT treeId from Tree2 where treeStatus='cut'order by height desc limit 1;

SELECT billId from bills2 where billDays >=7;

SELECT billId from bills2 where billPaid=billTotal;

SELECT clientID from contractor2 join bills2 on bills2.billId=contractor2.billID where bills2.billDays=0 and bills2.billPaid=0;
