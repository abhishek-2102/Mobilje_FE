<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
	var sup = ${supData}

	angular.module('supModule', []).controller('supController',
			function($scope) {
				$scope.sup = sup;
			});
</script>

</head>
<body>
<div class="container">
<br><br>
<div style="text-align:center">
<c:if test="${entry == true}">
	${supMessage}
	<br>
			</c:if>
			<c:if test="${error == true}">
	${supMessage}
	<br>
			</c:if>
</div>
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
<div ng-app="supModule" ng-controller="supController">
			<h3 style="margin-bottom: 10px">
				<b>Category List</b>
			</h3>
			<table class="table table-striped table-bordered table-hover table-">
				<thead><tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>E-mail</th>
					<th>Phone</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr></thead>
				<tbody>
				<tr ng-repeat="s in sup">
					<th>{{s.s_id}}</th>
					<th>{{s.s_name}}</th>
					<th>{{s.s_address}}</th>
					<th>{{s.s_email}}</th>
					<th>{{s.s_numb}}</th>
					<th><a class="btn btn-default" hrfe="">Edit</a></th>
					<th><a class="btn btn-danger" href="deleteSup?sid={{s.s_id}}">Delete</a></th>
					<th></th>
				</tr></tbody>
			</table>
		</div>
		
</div><!-- End Container -->
</body>
</html>