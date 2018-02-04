<%--
  Created by IntelliJ IDEA.
  User: gsati
  Date: 8/20/2017
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up | <%=application.getInitParameter("applicationName") %></title>
</head>
<body>
<h1>Sign up</h1>
<form action="register" method="post">

    <table cellpadding="5" cellspacing="5">
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="mail"/>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="password" name="pw"/>
            </td>
        </tr>

        <tr >
            <td><a href="index.jsp">Sign in</a></td>

            <td align="right">
                <input align="right" type="submit" value="Register">
            </td>
        </tr>


    </table>
</form>
<%@ include file="errorMessage.jsp" %>


</body>
</html>
