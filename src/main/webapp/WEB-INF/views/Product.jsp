<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
var cate=${categoryData}
var sup=${supplierData}

angular.module('prodModule',[]).controller('prodController',function($scope)
		{
			$scope.cate=cate;
			$scope.sup=sup;
		});
</script>
</head>
<body ng-app="prodModule" ng-controller="prodController">
<div class="container">
<div class="jumbotron">
<h3 style="text-align:center">Product Entry</h3>

<form:form class="form-group" method="post" commandName="prod_form" action="productPage">
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Product ID:</b></div>     
<div class="col-sm-4"><form:input path="p_id" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- Product ID-->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Product Name:</b></div>     
<div class="col-sm-4"><form:input path="p_name" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- Product name-->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Price:</b></div>     
<div class="col-sm-4"><form:input path="p_price" class="form-control" type="number" required="true"></form:input>
               </div>
               </div><!-- Product price-->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Category ID</b></div>     
<div class="col-sm-4"><form:select path="c_id" class="form-control" type="text" required="true">
				<form:option value="-1">Select Category</form:option>
				<form:option ng-repeat="cat in cate" value="{{cat.c_id}}">{{cat.c_name}}</form:option>
				</form:select>
               </div>
               </div><!-- Category  ID -->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Supplier ID</b></div>     
<div class="col-sm-4"><form:select path="s_id" class="form-control" type="text" required="true">
				<form:option value="-1">Select supplier</form:option>
               <form:option ng-repeat="s in sup" value="{{s.s_id}}">{{s.s_name}}</form:option></form:select>
               </div>
               </div><!-- Supplier ID -->
               <br> 
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Stock</b></div>     
<div class="col-sm-4"><form:input path="stock" class="form-control" type="number" required="true"></form:input>
               </div>
               </div><!-- Stock -->
               <br>
               
<div class="row">	
<div class="col-sm-2 col-sm-offset-2" style="text-align:right; margin-top:6px"><b>Product Desc:</b></div>     
<div class="col-sm-4"><form:input path="p_desc" class="form-control" type="text" required="true"></form:input>
               </div>
               </div><!-- Product Description-->
               <br>
               
<div class="col-sm-2 col-sm-offset-5">
<form:button type="submit" class="btn btn-success">Sumbit</form:button> 
</div>                                                           
</form:form><!-- End form -->
</div><!-- End jumbotron -->
</div><!-- End container -->
</body>
</html> 