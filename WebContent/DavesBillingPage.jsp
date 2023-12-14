<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Daves Root View</title>
</head>

<div align = "center">
	


<h1>Portal View for DavesTimber's Billing</h1>
    <div align="center">
        <br></br>
        <br></br>
        
        <caption><h2>Current Bills</h2></caption>
		<div align="center">
	        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
	            <caption><h2>List of Quotes</h2></caption>
	            <tr>
	                <th>Bill ID</th>
	                <th>Bill Paid</th>
	                <th>Bill Status</th>
	            </tr>
	            <c:forEach var="quote" items="${listBills}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote.billId}" /></td>
	                    <td><c:out value="${quote.billPaid}" /></td>
	                    <td><c:out value="${quote.billStatus}" /></td>
	            </c:forEach>
	        </table>
				<form action = "reloadBillTable" >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
        
        
        <br></br>
        <br></br>
        <caption><h2>Update Bill</h2></caption>
        <form action="billUpdateFromDave">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Quote ID: </th>
					<td align="center" colspan="3">
						<input type="text" name="billId" size="45"  value="000000" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Status: </th>
					<td>
						<input type="text" name="billPaid" size="45"  value="'Sent','Recieved','Pending'" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>InitialPrice: </th>
					<td>
						<input type="text" name="billStatus" size="45"  value="$" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Update Bill"/>
					</td>
				</tr>
			</table>
		<a href="login.jsp" target="_self">Return to Login Page</a>
	</form>
	</div>

	<br></br>
	



</body>
</html>