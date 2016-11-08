<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<div class="container">

<div class="jumbotron">
    <h3 style="text-align:center">Enter the Categories</h3>
    <br>

<form:form action="Category" class="form-group" method="post" commandName="cat_form">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Cat ID:</b></div>     
<div class="col-sm-4"><form:input path="c_id" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Cat Name:</b></div>     
<div class="col-sm-4"><form:input path="c_name" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>
               
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Cat ID:</b></div>     
<div class="col-sm-4"><form:input path="c_desc" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- end user name -->
               <br>

<div class="col-sm-2 col-sm-offset-5">
<form:button type="submit" class="btn btn-success">Submit</form:button></div>

</form:form>

</body>
</html>