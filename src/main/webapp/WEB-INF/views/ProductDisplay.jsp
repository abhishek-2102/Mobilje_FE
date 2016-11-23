<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.js"></script>
<script>
var prod = ${pData};
var app=angular.module('pmod',[]);
app.controller('pcon',function($scope){
	$scope.product=prod;
});
</script>
</head>
<body>
<div class="container">
${pData}
	<div ng-app="pmod" ng-controller="pcon">
		<div ng-repeat="p in product">
		{{p.p_id}}
		<br>
		{{p.p_name}}
		</div>	
	</div><!-- End ng-controller for view products -->
</div><!-- End Container -->
</body>
</html>