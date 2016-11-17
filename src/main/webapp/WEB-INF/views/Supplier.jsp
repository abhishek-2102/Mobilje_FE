<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Form</title>
<style>
#b1 {
width:100px;
margin-left:20px;
}
</style>

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
			<c:if test="${delete == true}">
	${supMessage}
	<br>
			</c:if>
			<c:if test="${update == true}">
	${supMessage}
	<br>
			</c:if>
</div>
<div class="jumbotron">
<c:if test="${whenSupSave==true}">
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
               
<div class="col-sm-4 col-sm-offset-4">
<form:button type="submit" class="btn btn-success btn-block"><b>Submit</b></form:button>
</div><!-- End Sumbit -->

</form:form><!-- End Form -->
</c:if><!-- End Save -->

<c:if test="${whenSupUpdate==true}"><h3 style="text-align:center">Enter Supplier Details</h3>
    <br>
<form:form class="form-group" commandName="sup_form" method="post" action="supUpdatePage">
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
               
<div class="col-sm-4 col-sm-offset-4">
<form:button type="submit" class="btn btn-warning btn-block"><b>Update</b></form:button>
</div><!-- End Sumbit -->
</form:form>
</c:if><!-- End Update -->
</div><!-- End Jumbotron -->
<div ng-app="supModule" ng-controller="supController">
			<h3 style="margin-bottom: 10px">
				<b>Category List</b>
			</h3>
			<table class="table table-hover">
				<thead><tr>
					<th><u><i>ID</i></u></th>
					<th><u><i>Name</i></u></th>
					<th><u><i>Address</i></u></th>
					<th><u><i>E-mail</i></u></th>
					<th colspan="3"><u><i>Phone</i></u></th>
					
					<!-- <th></th>
					<th></th> -->
				</tr></thead>
				<tbody>
				<tr ng-repeat="s in sup">
					<td>{{s.s_id}}</td>
					<td>{{s.s_name}}</td>
					<td>{{s.s_address}}</td>
					<td>{{s.s_email}}</td>
					<td>{{s.s_numb}}</td>
					<td><a class="btn btn-primary" id="b1" href="updateSup?sid={{s.s_id}}"><b>Edit</b></a></td>
					<td><a class="btn btn-danger" id="b1" href="deleteSup?sid={{s.s_id}}"><b>Delete</a></b></td>
					
				</tr></tbody>
			</table>
		</div>
		
</div><!-- End Container -->
</body>
</html>