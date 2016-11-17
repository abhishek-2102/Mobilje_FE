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
				<b>Supplier List</b>
			</h3>
				<div class="col-sm-4">
			<div class="input-group">
  				<span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
  				<input class="form-control" type="text" placeholder="search here..." ng-model="searchSup">
			</div><!-- End Search -->
			</div><!-- End col for search -->
			
			<table class="table table-hover">
				<thead><tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>E-mail</th>
					<th colspan="3">Phone</th>
				
				</tr></thead>
				<tbody>
				<tr ng-repeat="s in sup|filter:searchSup">
					<td>{{s.s_id}}</td>
					<td>{{s.s_name}}</td>
					<td>{{s.s_address}}</td>
					<td>{{s.s_email}}</td>
					<td>{{s.s_numb}}</td>
					<td><a class="btn btn-primary" id="b1" href="updateSup?sid={{s.s_id}}"><i class="fa fa-pencil"></i></a></td>
					<td><a class="btn btn-danger" id="b1" href="deleteSup?sid={{s.s_id}}"><i class="fa fa-trash-o"></i></a></td>
					
				</tr></tbody>
			</table>
		</div>
		
</div><!-- End Container -->
</body>
</html>