
use DavesTimber;

SELECT clientID,count(clientID) from Tree2 As bigClient group by clientID Order by count(clientID) desc, clientID desc LIMIT 1;

SELECT contractor2.clientID from Contractor2 Join quotes2 On contractor2.orderID=quotes2.orderID where quotesTimesResent=0 and quoteStatus='Accepted';

SELECT * from Contractor2 Join tree2 On tree2.clientID=contractor2.clientID Join quotes2 On quotes2.orderID=contractor2.orderID where quotes2.quotesTimesResent=0 and quotes2.quoteStatus='Accepted';
