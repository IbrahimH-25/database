<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ page import="java.util.List" %>



<!DOCTYPE html>
<html>



<head>
<meta charset="ISO-8859-1">
<title>Daves Admin View</title>
</head>


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
	            <c:forEach var="quote" items="${listQuote}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote.orderID}" /></td>
	                    <td><c:out value="${quote.quoteStatus}" /></td>
	                    <td><c:out value="${quote.initialPrice}" /></td>
	                    <td><c:out value="${quote.note}" /></td>
	            </c:forEach>
	        </table>
				<form action = "reloadQuoteTable" >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
        
        
        <br></br>
        <br></br>
        <caption><h2>Submit Initial Quote</h2></caption>
        <form action="quoteInsertFromDave">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				
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
	
	<h1>Portal View for Needed responses to clients</h1>
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
	            <c:forEach var="quote2" items="${listQuoteReplies}">
	                <tr style="text-align:center">
	                    <td><c:out value="${quote2.orderID}" /></td>
	                    <td><c:out value="${quote2.quoteStatus}" /></td>
	                    <td><c:out value="${quote2.initialPrice}" /></td>
	                    <td><c:out value="${quote2.note}" /></td>
	            </c:forEach>
	        </table>
				<form action = ${reloadQuoteTable} >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
		
		<br></br>
<caption><h2>Respond to Clients</h2></caption>
        <form action="quoteUpdateFromDave">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Quote ID to update for client: </th>
					<td align="center" colspan="3">
						<input type="text" name="orderID" size="45"  value="000000" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>NewPrice: </th>
					<td>
						<input type="text" name="initialPrice" size="45"  value="$" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<th>Note: </th>
					<td>
						<input type="text" name="note" size="45"  value="N/A" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Send Response"/>
					</td>
				</tr>
			</table>
		<a href="login.jsp" target="_self">Return to Login Page</a>
	</form>
	</div>


	<br></br>
	</div>
	
	
	
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
	            <c:forEach var="bills" items="${listBills}">
	                <tr style="text-align:center">
	                    <td><c:out value="${bills.billId}" /></td>
	                    <td><c:out value="${bills.billPaid}" /></td>
	                    <td><c:out value="${bills.billStatus}" /></td>
	            </c:forEach>
	        </table>
				<form action = "reloadQuoteTable" >
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
						<input type="text" name="billPaid" size="45"  value="$" onfocus="this.value=0">
					</td>
				</tr>
				<tr>
					<th>InitialPrice: </th>
					<td>
						<input type="text" name="billStatus" size="45"  value="'billToCustomer','billFromCustomer'" onfocus="this.value=''">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="Update Bill"/>
					</td>
				</tr>
			</table>
	</form>
	</div>

	<br></br>

    <div align="center">
        <br></br>
        <br></br>
        <caption><h2>Current Trees</h2></caption>
		<div align="center">
	        <table border="1" cellpadding="6" style="background-color:DarkGoldenRod">
	            <caption><h2>List of Quotes</h2></caption>
	            <tr>
	                <th>tree ID</th>
	                <th>tree size</th>
	                <th>tree height</th>
	                <th>tree location</th>
	                <th>tree photo1</th>
	                <th>tree photo2</th>
	                <th>tree photo3</th>
	            </tr>
	            <c:forEach var="tree" items="${listTrees}">
	                <tr style="text-align:center">
	                    <td><c:out value="${tree.treeID}" /></td>
	                    <td><c:out value="${tree.size}" /></td>
	                    <td><c:out value="${tree.height}" /></td>
	                    <td><c:out value="${tree.location}" /></td>
	                    <td><c:out value="${tree.photo1}" /></td>
	                    <td><c:out value="${tree.photo2}" /></td>
	                    <td><c:out value="${tree.photo3}" /></td>
	            </c:forEach>
	        </table>
				<form action = "reloadBillTable" >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
        

</body>
</html>