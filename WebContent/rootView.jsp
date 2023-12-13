<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>



<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>



<body style="background-color:lightgreen">


	<sql:setDataSource
	    var="jspSQL"
	    driver="com.mysql.jdbc.Driver"
	    url="jdbc:mysql://127.0.0.1:3306/DavesTimber"
	    user="john" password="john1234"
	/>
<sql:query var="big_client" dataSource="${jspSQL}">
    SELECT clientID from Tree2 As bigClient group by clientID Order by count(clientID) desc, clientID desc LIMIT 1;
</sql:query>
<sql:query var="easy_client" dataSource="${jspSQL}">
    SELECT contractor2.clientID from Contractor2 Join quotes2 On contractor2.orderID=quotes2.orderID where quotesTimesResent=0 and quoteStatus='Accepted';
</sql:query>
<sql:query var="one_tree" dataSource="${jspSQL}">
    SELECT contractor2.orderID from Contractor2 Join tree2 On tree2.clientID=contractor2.clientID Join quotes2 On quotes2.orderID=contractor2.orderID where quotes2.quoteStatus='Accepted' group by contractor2.orderID having count(contractor2.orderID)=1 ;
</sql:query>
<sql:query var="prospect" dataSource="${jspSQL}">
    SELECT clientID from contractor2 where billID='000000';
</sql:query>
<sql:query var="highest_tree" dataSource="${jspSQL}">
    SELECT treeId from Tree2 where treeStatus='cut'order by height desc limit 1;
</sql:query>
<sql:query var="overdue_bills" dataSource="${jspSQL}">
    SELECT billId from bills2 where billDays >=7;
</sql:query>
<sql:query var="bad_clients" dataSource="${jspSQL}">
    SELECT billId from bills2 where billPaid=billTotal;
</sql:query>
<sql:query var="good_clients" dataSource="${jspSQL}">
    SELECT clientID from contractor2 join bills2 on bills2.billId=contractor2.billID where bills2.billDays=0 and bills2.billPaid=0;
</sql:query>


<div align = "center">

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Address</th>
                <th>Password</th>
                <th>Phone Number</th>
                <th>Client ID</th>
                <th>Credit Card</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value="${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.phoneNum}" /></td>
                    <td><c:out value="${users.clientID}"/></td>
                    <td><c:out value="${users.creditCard}" /></td>
            </c:forEach>
        </table>
	</div>
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	<br></br>
	<form action = "deleteAllUsers">
		<input type = "submit" value = "Delete users from the Database"/>
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	</div>

<h1>Big Client</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query1" items="${big_client.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query1.clientID}" /></td>
            </c:forEach>
        </table>
	</div>

<h1>Easy Clients</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query2" items="${easy_client.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query2.clientID}" /></td>
            </c:forEach>
        </table>
	</div>

<h1>Clients With One Tree</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query33" items="${one_tree.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query33.orderID}" /></td>
            </c:forEach>
        </table>
	</div>
	
<h1>Prospect Clients Clients</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query3" items="${prospect.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query3.clientID}" /></td>
            </c:forEach>
        </table>
	</div>	

<h1>Client With Highest Tree</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query4" items="${highest_tree.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query4.treeId}" /></td>
            </c:forEach>
        </table>
	</div>

<h1>Client Overdue payments</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query5" items="${overdue_bills.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query5.billId}" /></td>
            </c:forEach>
        </table>
	</div>

<h1>Bad Clients</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ClientID</th>
            </tr>
            <c:forEach var="query6" items="${bad_clients.rows}">
                <tr style="text-align:center">
                    <td><c:out value="${query6.billId}" /></td>
            </c:forEach>
        </table>
	</div>

</body>
</html>