<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
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
		</div>
		<div class="jumbotron">
			<h3 style="text-align: center">Enter Category Details</h3>
			<br>
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
					<form:button type="submit" class="btn btn-success btn-block">Submit</form:button>
				</div>
			</form:form>
			<!-- End Form -->
		</div>
		<!-- End Jumbotron -->

		<div ng-app="catModule" ng-controller="catController">
			<h3 style="margin-bottom: 10px">
				<b>Category List</b>
			</h3>
			<table class="table table-striped table-bordered table-hover table-">
				<thead><tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr></thead>
				<tbody>
				<tr ng-repeat="c in cat">
					<th>{{c.c_id}}</th>
					<th>{{c.c_name}}</th>
					<th>{{c.c_desc}}</th>
				</tr></tbody>
			</table>
		</div>
		<!-- End Category Display -->
	</div>
	<!-- End Container -->
</body>
</html>