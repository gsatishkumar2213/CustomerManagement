<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer | <<%=application.getInitParameter("applicationName") %>></title>
</head>
<body>
	<form action="addCustomer" method="post">
		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>Customer Name:</td>
				<td><input type="text" name="custName" /></td>
			</tr>
			<tr>
				<td>Customer Email:</td>
				<td><input type="text" name="custEmail" /></td>
			</tr>
			<tr>
				<td>Customer Phone:</td>
				<td><input type="text" name="custPhone" /></td>
			</tr>
			<tr>
				<td>Customer Address:</td>
				<td> <textarea cols ="6" rows= "6" name="custAddress"></textarea></td>
			</tr>
			<tr>
				<td>Customer Age:</td>
				<td><input type="text" name="custAge" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="right">
				<input type="submit" value="add" /> 
				<input type="reset" value="Cancel" /></td>
			</tr>

		</table>
	</form>
	<%@ include file="errorMessage.jsp" %>
</body>
</html>