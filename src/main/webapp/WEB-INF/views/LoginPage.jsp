<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
.jumbotron{

background-size:1150px 500px;
background-image:url("img/save_web.jpg");
background-repeat:no-repeat;
}
</style>
</head>
<body>
<div class="container">

<c:if test="${cartText == true}">
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
	<h3 class="alert alert-danger text-center">Login before add to cart</h3>
</div>
</div>
</c:if>

<c:if test="${error == true}">
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
	<h3 class="alert alert-warning text-center">Incorrect Username and password</h3>
</div>
</div>
</c:if>
<br>
<div class="jumbotron">
<h3 style="text-align:center; color:white">Login to shop</h3>

<form action="login_success" class="form-group" method="post" >
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>Email:</b></div>     
<div class="col-sm-4"><input name="login_email" class="form-control" type="text" required="true"></input>
               </div>
               </div><!-- end user name -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>Password:</b></div>     
<div class="col-sm-4"><input name="login_password" class="form-control" type="password" required="true"></input>
               </div>
               </div><!-- end user name -->
               <br>
<div class="col-sm-2 col-sm-offset-5">
<button type="submit" class="btn btn-success">Start Shopping</button> 
</div>
</form><!-- End form tag -->
<br>
</div><!-- End jumbotron -->
</div><!-- End Container -->
</body>
</html>