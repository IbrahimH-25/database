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
	            <c:forEach var="clientQuote" items="${listClientQuotes}">
	                <tr style="text-align:center">
	                    <td><c:out value="${clientQuote.orderID}" /></td>
	                    <td><c:out value="${clientQuote.quoteStatus}" /></td>
	                    <td><c:out value="${clientQuote.initialPrice}" /></td>
	                    <td><c:out value="${clientQuote.note}" /></td>
	            </c:forEach>
	        </table>
	        <form action = "reloadClientQuoteTable" >
					<input type = "submit" value = "reload"/>
			</form>
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
					<th>Change Amount: </th>
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
	            <c:forEach var="bills" items="${clientBillList}">
	                <tr style="text-align:center">
	                    <td><c:out value="${bills.billId}" /></td>
	                    <td><c:out value="${bills.billPaid}" /></td>
	                    <td><c:out value="${bills.billStatus}" /></td>
	            </c:forEach>
	        </table>
				<form action = "reloadBillTable" >
					<input type = "submit" value = "reload"/>
				</form>
		</div>
        
        
        <br></br>
        <br></br>
        <caption><h2>Current Bills</h2></caption>
        <form action="billPayFromClient">
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
						<input type="text" name="billPaid" size="45"  value="Pay Amount" onfocus="this.value=''">
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