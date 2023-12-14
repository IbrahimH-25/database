<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.util.List" %>
<body style="background-color:lightgreen">
	<sql:setDataSource
    var="jspSQL"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://127.0.0.1:3306/DavesTimber"
    user="john" password="john1234"
/>
<sql:query var="list_quotes" dataSource="${jspSQL}">
    SELECT * FROM quotes;
</sql:query>
<sql:query var="list_quotes_client_response" dataSource="${jspSQL}">
    SELECT * FROM quotes where quoteStatus = "quoteFromClient";
</sql:query>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Daves Root View</title>
</head>
<body style="background-color:lightgreen">
	<sql:setDataSource
    var="jspSQL"
    driver="com.mysql.jdbc.Driver"
    url="jdbc:mysql://127.0.0.1:3306/DavesTimber"
    user="john" password="pass1234"
/>
<sql:query var="list_quotes" dataSource="${jspSQL}">
    SELECT * FROM quotes;
</sql:query>


<div align = "center">
	


<h1>Portal View for DavesTimber</h1>
    <div align="center">
        <br></br>
        <br></br>
        
        <caption><h2>Current Quotes</h2></caption>
		<div align="center">
	        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
	            <caption><h2>List of Quotes</h2></caption>
	            <tr>
	                <th>Order ID</th>
	                <th>Quote Status</th>
	                <th>Amount</th>
	                <th>Note</th>
	            </tr>
	            <c:forEach var="quote" items="${list_quotes.rows}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote.orderID}" /></td>
	                    <td><c:out value="${quote.quoteStatus}" /></td>
	                    <td><c:out value="${quote.initialAmount}" /></td>
	                    <td><c:out value="${quote.note}" /></td>
	            </c:forEach>
	        </table>
				<form action = ${reloadQuoteTable} >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
        
        
        <br></br>
        <br></br>
        <caption><h2>Submit Initial Quote</h2></caption>
        <form action="quoteInsertFromDave">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Quote ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="orderID" size="45"  value="000000" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Status: </th>
					<td>
						<input type="text" name="quoteStatus" size="45"  value="'Sent','Recieved','Pending'" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>InitialPrice: </th>
					<td>
						<input type="text" name="initialPrice" size="45"  value="$" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Note: </th>
					<td>
						<input type="text" name="note" size="45"  value="Lipsum" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Send Quote"/>
					</td>
				</tr>
			</table>
		<a href="login.jsp" target="_self">Return to Login Page</a>
	</form>
	</div>

	<br></br>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	</div>

</body>
</html>