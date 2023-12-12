
use DavesTimber;

SELECT clientID,count(clientID) from Tree2 As bigClient group by clientID Order by count(clientID) desc, clientID desc LIMIT 1;