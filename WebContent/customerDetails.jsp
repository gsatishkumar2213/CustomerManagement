<%@page import="com.sidgs.to.CustomerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= request.getAttribute("screenName") %> | <%=application.getInitParameter("applicationName") %></title>
</head>
<body>

	<% CustomerDetails customerDetails; %>
	<% customerDetails = (CustomerDetails)request.getAttribute("cutomerdetails"); %>

<h1 style= color:red>CustomerDetails</h1>
	<table cellpadding="5" cellspacing="5">
		<tr>
			<td>Customer Id:</td>
			<td><%= customerDetails.getCustId()%></td>
		</tr>
		<tr>
			<td>Customer Name:</td>
			<td><%= customerDetails.getCustName()%></td>
		</tr>
		<tr>
			<td>Customer Email:</td>
			<td><%= customerDetails.getCustEmail()%></td>
		</tr>
		<tr>
			<td>Customer Phone:</td>
			<td><%= customerDetails.getCustPhone()%></td>
		</tr>
		<tr>
			<td>Customer Address:</td>
			<td><%= customerDetails.getCustAddress() %></td>
		</tr>
		<tr>
			<td>Customer Age:</td>
			<td><%= customerDetails.getCustAge() %></td>
		</tr>
		<tr>
			<td></td>

		</tr>

	</table>


</body>
</html>