<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reg from</title>

</head>

<body>
<div class="container">

<div class="jumbotron">
    <h3 style="text-align:center">Register With Us!</h3>
    <br>

<form:form action="reg_page" class="form-group" method="post" commandName="user_form">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>User Name:</b></div>     
<div class="col-sm-4"><form:input path="username" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Password:</b></div>     
<div class="col-sm-4"><form:input path="password" class="form-control" type="password" required="true"></form:input>
               </div>
               </div><!-- end password -->               
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>E-mail:</b></div>     
<div class="col-sm-4"><form:input path="email" class="form-control" type="email" required="true"></form:input>
               </div>
               </div>  <!-- end email -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Number:</b></div>     
<div class="col-sm-4"><form:input path="number" class="form-control" type="tele" required="true"></form:input>
               </div>
               </div>     <!-- end number tag -->          
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Address:</b></div>     
<div class="col-sm-4"><form:textarea path="address" class="form-control" ></form:textarea>
               </div>
               </div>    <!-- end address tag -->           
               <br>
                   
 <div class="col-sm-2 col-sm-offset-5">
				<form:button type="submit" class="btn btn-success">Start Shopping</form:button></div>
</form:form><!-- End form tag -->
<br><br>
</div>
</div>
</body>
</html>