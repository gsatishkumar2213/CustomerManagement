<%@ page import="java.util.List"%>
<%@ page import="com.sidgs.to.CustomerDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= request.getAttribute("screenName") %> |<%=application.getInitParameter("applicationName") %></title>
</head>
<body>

	<%
		List<CustomerDetails> customerList;
		customerList = (List<CustomerDetails>) request.getAttribute("customers");
	%>

	<div style="width: 50%;">
		<div style="padding: 10px; text-align: right; width: 50%;">
			<a href="addCustomer.jsp">Add customer</a>
		</div>
		<div style="width: 50%;">
			<table border="1" cellpadding="5" cellspacing="5">
				<tr>
					<th>Name</th>
					<th>EmailID</th>
					<th>Phone No</th>
					<th>Address</th>
					<th>Action</th>
				</tr>
				<%
					for (CustomerDetails customer : customerList) {
				%>
				<tr>
					<td><%=customer.getCustName()%></td>
					<td><%=customer.getCustEmail()%></td>
					<td><%=customer.getCustPhone()%></td>
					<td><%=customer.getCustAddress()%></td>
					<td><%=customer.getCustAge()%></td>


					<td><a href="getCustomer?custId=<%=customer.getCustId() %>">Details</a></td>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</div>
</body>
</html>