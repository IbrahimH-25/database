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
        
        
        <form action="register">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Email: </th>
					<td align="center" colspan="3">
						<input type="text" name="email" size="45"  value="example@gmail.com" onfocus="this.value=''">
					</td>
				</tr>
			</table>
		<a href="login.jsp" target="_self">Return to Login Page</a>
	</form>
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

</body>
</html>