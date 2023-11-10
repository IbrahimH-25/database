<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daves Root View</title>
</head>
<body style="background-color:lightgreen">

<div align = "center">
	


<h1>Portal View for DavesTimber</h1>
    <div align="center">
        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>Client ID</th>
                <th>Quote Status</th>
                <th>Bill ID</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                    <td><c:out value="${users.clientID}" /></td>
                    <td><c:out value="${users.quoteStatus}" /></td>
                    <td><c:out value="${users.billID}" /></td>

            </c:forEach>
        </table>
        <br></br>
        <br></br>
        
        <caption><h2>Current Quotes</h2></caption>
	    <div align="center">
	        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
	            <caption><h2>List of Users</h2></caption>
	            <tr>
	                <th>Order ID</th>
	                <th>Quote Status</th>
	                <th>Amount</th>
	                <th>Note</th>
	            </tr>
	            <c:forEach var="quote" items="${listQuote}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote.orderID}" /></td>
	                    <td><c:out value="${quote.quoteStatus}" /></td>
	                    <td><c:out value="${quote.initialAmount}" /></td>
	                    <td><c:out value="${quote.note}" /></td>
	            </c:forEach>
	        </table>
			<a href="login.jsp" target="_self">Return to Login Page</a>
		</div>
        
        
        <br></br>
        <br></br>
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