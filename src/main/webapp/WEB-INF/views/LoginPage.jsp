<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
  <div class="form-group">
    <label for="LoginEmail">Email address:</label>
    <input type="email" class="form-control" id="LoginEmail">
  </div>
  <div class="form-group">
    <label for="LoginPassword">Password:</label>
    <input type="password" class="form-control" id="LoginPassword">
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>