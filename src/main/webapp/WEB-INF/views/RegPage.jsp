<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration from</title>
<style>
.jumbotron{

background-size:1150px 800px;
margin-bottom:0px;
background-image:url("img/save_web.jpg");
background-repeat:no-repeat; 

}
</style>
</head>

<body>
<div class="container">
<br><br>
<div class="jumbotron">
    <h3 style="text-align:center; color:white;">Register With Us!</h3>
    <br>

<form:form action="reg_page" class="form-group" method="post" commandName="user_form">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>User Name:</b></div>     
<div class="col-sm-4"><form:input path="username" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
               <div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>Name:</b></div>     
<div class="col-sm-4"><form:input path="name" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>Password:</b></div>     
<div class="col-sm-4"><form:input path="password" class="form-control" type="password" required="true"></form:input>
               </div>
               </div><!-- end password -->               
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:white"><b>Confirm Password:</b></div>     
<div class="col-sm-4"><input name="confirm_password" class="form-control" type="password" required="true"></input>
               </div>
               </div><!-- end confirm_password -->               
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px;color:white"><b>E-mail:</b></div>     
<div class="col-sm-4"><form:input id="email-1" path="email" class="form-control" type="email" required="true"></form:input>
               </div>
               </div>  <!-- end email -->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:#62001b"><b>Confirm E-mail:</b></div>     
<div class="col-sm-4"><input id="confirm_email"name="confirm_email" class="form-control" type="email" required="true"></input>
               </div>
               </div>  <!-- end confirm_email -->
               <br>
                              
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:#62001b"><b>Gender:</b></div>     
<div class="col-sm-4">
      <form:select path="gender" class="form-control" required="true">
      	<option>Select..</option>
        <option>Female</option>
        <option>Male</option>
      </form:select></div>
               </div><!-- end gender !!!!!edit this!!!! -->               
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:#62001b"><b>Date Of birth:</b></div>     
<div class="col-sm-4"><form:input path="dob" class="form-control" type="date" required="true" placeholder="mm/dd/yyyy"></form:input>
               </div>
               </div><!-- end dob -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:#62001b"><b>Number:</b></div>     
<div class="col-sm-4"><form:input path="number" class="form-control" type="tele" required="true"></form:input>
               </div>
               </div><!-- end number tag -->          
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px; color:#62001b"><b>Address:</b></div>     
<div class="col-sm-4"><form:textarea path="address" class="form-control" ></form:textarea>
               </div>
               </div>    <!-- end address tag -->           
               <br>
                   
 <div class="col-sm-2 col-sm-offset-5">
<form:button type="submit" class="btn btn-success">Submit</form:button></div>
</form:form><!-- End form tag -->
</div><!-- End Jummbotron-->
</div><!-- End Container -->
</body>
</html>