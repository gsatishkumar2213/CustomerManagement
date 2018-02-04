<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | <%=application.getInitParameter("applicationName") %></title>
</head>
<body>
	<!--  this is declaration tag -->
	<%!Date date;
	String formatDate;%>
	<%-- this is scriptlet tag --%>
	<%
		date = new Date();
		DateFormat df = new SimpleDateFormat("dd'th' MMM , YYYY");
		formatDate = df.format(date);
	%>
	<%--this is expresion tag --%>
	<h1><%=date%></h1>
	<h1><%=formatDate%></h1>
	<h1>Sign In</h1>
	<form action="login" method="post">

		<table cellpadding="5" cellspacing="5">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="un" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pw" /></td>
			</tr>

			<tr>
				<td><a href="SignUp.jsp">Sign Up</a></td>

				<td align="right"><input align="right" type="Submit"
					value="Login"></td>
			</tr>


		</table>
	</form>
	
	<%@ include file="errorMessage.jsp" %>


</body>
</html>