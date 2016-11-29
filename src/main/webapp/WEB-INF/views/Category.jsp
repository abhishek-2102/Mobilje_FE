<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<style>
#b1 {
width:100px;
margin-left:20px;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

 <script>
	var cat = ${catData}

	angular.module('catModule', []).controller('catController',
			function($scope) {
				$scope.cat = cat;
			});
</script>

</head>
<body>
	<div class="container">
		<br> <br>
		<div style="text-align: center">
				<c:if test="${entry == true}">
	${catMessage}
	<br>
			</c:if>
			<c:if test="${error == true}">
	${catMessage}
	<br>
			</c:if>
			<c:if test="${update == true}">
	${catMessage}
	<br>
			</c:if>
		</div>
		<div class="jumbotron">
			<h3 style="text-align: center">Enter Category Details</h3>
			<br>
<c:if test="${whenCatSave==true}">
			<form:form class="form-group" commandName="cat_form" method="post"
				action="categoryPage">
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category ID:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_id" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat-id -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category Name:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_name" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat-name -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category Details:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_desc" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat desc -->
				<br>

				<div class="col-sm-4 col-sm-offset-4">
					<form:button type="submit" class="btn btn-success btn-block"><b>Submit</b></form:button>
				</div>
			</form:form>
			<!-- End Form -->
</c:if>
<c:if test="${whenCatUpdate}">
			<form:form class="form-group" commandName="cat_form" method="post"
				action="cateUpdatePage">
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category ID:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_id" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat-id -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category Name:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_name" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat-name -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category Details:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="c_desc" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- end cat desc -->
				<br>

				<div class="col-sm-4 col-sm-offset-4">
					<form:button type="submit" class="btn btn-warning btn-block"><b>Update</b></form:button>
				</div>
			</form:form>
			<!-- End Form -->
</c:if>
		</div>
		<!-- End Jumbotron -->
		
		<h3 style="margin-bottom: 10px">
				<b>Category List</b>
			</h3>
		<div ng-app="catModule" ng-controller="catController">
			<div class="col-sm-4">
			<div class="input-group">
  				<span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
  				<input class="form-control" type="text" placeholder="search here..." ng-model="searchCat">
			</div><!-- End Search -->
			</div><!-- End col for search -->
			
			<table class="table table-hover">
				<thead><tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr></thead>
				<tbody>
				<tr ng-repeat="c in cat|filter:searchCat">
					<td>{{c.c_id}}</td>
					<td>{{c.c_name}}</td>
					<td>{{c.c_desc}}</td>
					<td><a href="updateCat?cid={{c.c_id}}" id="b1" class="btn btn-primary"><i class="fa fa-pencil"></i></a></td>
					<td><a href="deleteCat?cid={{c.c_id}}" id="b1" class="btn btn-danger"> <i class="fa fa-trash-o"></i></a></td>
				</tr></tbody>
			</table>
		</div>
		<!-- End Category Display -->
	</div>
	<!-- End Container -->
</body>
</html>