<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div class="container">
<div class="jumbotron">
<h3 style="text-align:center;">Login to shop</h3>
<form:form action="login_page" class="form-group" method="post" commandName="login_form">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>User Name:</b></div>     
<div class="col-sm-4"><form:input path="login_email" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Password:</b></div>     
<div class="col-sm-4"><form:input path="login_password" class="form-control" type="password" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
<div class="col-sm-2 col-sm-offset-5">
<form:button type="submit" class="btn btn-success">Start Shopping</form:button> 
</div>
</form:form><!-- End form tag -->
<br>


</div><!-- End jumbotron -->
</div><!-- End Container -->
</body>
</html>