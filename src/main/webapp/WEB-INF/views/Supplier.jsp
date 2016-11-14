<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Form</title>
</head>
<body>
<div class="container">
<div class="jumbotron">
<h3 style="text-align:center">Enter Supplier Details</h3>
    <br>
<form:form class="form-group" commandName="sup_form" method="post" action="supplierPage">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier ID:</b></div>     
<div class="col-sm-4"><form:input path="s_id" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end cat-id -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier Name:</b></div>     
<div class="col-sm-4"><form:input path="s_name" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end cat-id -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier Address:</b></div>     
<div class="col-sm-4"><form:input path="s_address" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end cat-id -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier Email:</b></div>     
<div class="col-sm-4"><form:input path="s_email" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end cat-id -->
               <br>
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier Number:</b></div>     
<div class="col-sm-4"><form:input path="s_numb" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end supplier-number-->
               <br>
               
<div class="col-sm-2 col-sm-offset-5">
<form:button type="submit" class="btn btn-success">Submit</form:button>
</div><!-- End Sumbit -->

</form:form><!-- End Form -->
</div><!-- End Jumbotron -->
</div><!-- End Container -->
</body>
</html>