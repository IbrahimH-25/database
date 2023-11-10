<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daves Timber</title>
</head>
<body style="background-color:lightgreen">
 <center>	<h1> Welcome to Daves Timber </h1> </center>
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