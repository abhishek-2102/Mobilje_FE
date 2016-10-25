<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg from</title>
</head>
<body>
<form:form action="reg_page" method="post" commandName="user_form">
	<table border="0">
                <tr>
                    <td colspan="2" align="center"><h2> Registration</h2></td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><form:input type="text" path="username"/></td>
                </tr>
                
                <tr>
                    <td>Password:</td>
                    <td><form:input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input type="email" path="email"/></td>
                </tr>
	
                <tr>
                    <td>Phone:</td>
                    <td><form:input path="number"/></td>
                </tr>
                               
                <tr>
                    <td>Profession:</td>
                    <td><form:select path="profession" items="${profession}"/></td>
                </tr>       
</table>
				<form:button type="submit">Register</form:button>
</form:form>
</body>
</html>