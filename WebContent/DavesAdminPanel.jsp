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


    
</div>

</body>
</html>