<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Address</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://path/to/font-awesome/css/font-awesome.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>

<body>
<div class="container">
<br>
<div class="jumbotron">
<h3 style="text-align:center">Shipping Address</h3>

<form:form class="form-group" method="post" commandName="shippingAddress">

<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>House no.</b></div>     
<div class="col-sm-4"><form:input path="hno" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end hno -->
               <br>

<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Address Line #1:</b></div>     
<div class="col-sm-4"><form:input path="line1" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end line1 -->
               <br>

<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Address Line #1:</b></div>     
<div class="col-sm-4"><form:input path="line2" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end line2 -->
               <br>
                           
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>City:</b></div>     
<div class="col-sm-4"><form:input path="city" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end city -->
               <br>

<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Pin</b></div>     
<div class="col-sm-4"><form:input path="pin" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end line2 -->
               <br>

<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>State</b></div>     
<div class="col-sm-4"><form:input path="state" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end line2 -->
               <br>
	<a href="" class="btn btn-primary col-sm-3">Back</a>
	<form:button class="btn btn-success col-sm-3 col-sm-offset-6" type="submit" name="_eventId_saveship">Next</form:button>
</form:form><!-- End form tag -->
<br>

<div class="">
		
	</div>
	<div class="">
	<!-- 	<a name="_eventId_saveship" type="submit" class="btn btn-warning col-sm-3 col-sm-offset-6">Next</a>
	 --></div>
	
</div><!-- End jumbotron -->
</div><!-- End Container -->


</body>
</html>