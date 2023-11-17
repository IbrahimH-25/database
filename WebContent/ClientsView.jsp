<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daves Timber</title>
</head>
<body style="background-color:lightgreen">

<body style="background-color:lightgreen">
	<sql:setDataSource
    var="jspSQL"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://127.0.0.1:3306/DavesTimber"
    user="john" password="john1234"
/>
<sql:query var="list_quotes_contractor_response" dataSource="${jspSQL}">
    SELECT * FROM quotes where quoteStatus = "quoteFromContractor";
</sql:query>

 <center>	<h1> Welcome to Daves Timber </h1> </center>
 
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
	            <c:forEach var="quote" items="${list_quotes_contractor_response.rows}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote.orderID}" /></td>
	                    <td><c:out value="${quote.quoteStatus}" /></td>
	                    <td><c:out value="${quote.initialAmount}" /></td>
	                    <td><c:out value="${quote.note}" /></td>
	            </c:forEach>
	        </table>
		</div>
 
 <caption><h2>Respond to Quote</h2></caption>
        <form action="quoteUpdateFromClient">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Quote ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="orderID" size="45"  value="000000" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>InitialPrice: </th>
					<td>
						<input type="text" name="Change Price" size="45"  value="$" onfocus="this.value=''">
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
						<input type="submit" value="Send Response"/>
					</td>
				</tr>
			</table>
	</form>
	</div>
 
  <caption><h2>Accept Quote</h2></caption>
        <form action="quoteAcceptFromClient">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Quote ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="orderID" size="45"  value="000000" onfocus="this.value=''">
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
						<input type="submit" value="Send Response"/>
					</td>
				</tr>
			</table>
	</form>
	</div>
 
 
	<div align="center">
		<p> ${loginFailedStr} </p>
		<form action="NewOrder.jsp" method="post">
			<table border="1" style="background-color:DarkGoldenRod">
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="New Order"/>
					</td>
				</tr>
			</table>
		</form>
		<form action="ExistingOrder.jsp" method="post">
			<table border="1" style="background-color:DarkGoldenRod">
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Existing Order"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>