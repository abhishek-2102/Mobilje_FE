<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
	<script>
		var cate =<%=session.getAttribute("categoryData")%>;
		angular.module('onloadModule',[]).controller('onloadController',function($scope){
					$scope.cate=cate;
				});
		
		$(function(){
			$('#upper').on('keyup',function(){
				var t=$(this).val().toUpperCase();
				
				$('#upper').val(t);
			});
		});

	</script>
<style>
body {
	position: relative;
}

.affix {
	top: 0;
	width: 100%;
	z-index: 9999 !important;
}

.navbar {
	margin-bottom: 0px;
}

.affix ~ .container-fluid {
	position: relative;
	top: 50px;
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
	<div ng-app="onloadModule" ng-controller="onloadController">
	<div class="container-fluid"
		style="background-color: white; height: 180px;" >
		<div class="col-sm-4" >
		<a class="brand" href="home"><img src="img/insta.gif" alt="Brand"></a>
		</div><!-- End logo -->
		<div class="col-sm-8">
			
		</div>
	</div>

	<div class="navbar navbar-inverse" data-spy="affix"
		data-offset-top="197">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home">Mobilje</a>
			</div>
			<div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="home">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="product?cid={{c.c_id}}" ng-repeat="c in cate">{{c.c_name}}</a></li>
							</ul></li>
						<li><a href="contact_us">Contact Us</a></li>
					</ul>
					<!-- End left side navbar -->
				<div class="col-sm-4">
			        <form class="navbar-form" action="product" method="post">
			        <div class="input-group">
			            <input type="text" class="form-control" placeholder="Search" name="search" id="upper">
			            <div class="input-group-btn">
			                <button class="btn btn-default" type="submit" style="height: 34px"><i class="glyphicon glyphicon-search"></i></button>
			            </div>
			        </div>
			        </form>
			    </div><!-- End search -->
					<ul class="nav navbar-nav navbar-right">
						<li><a href="reg_page"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="login_page"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>
					<!-- End Right side navbar -->
				</div>
			</div>
		</div>
	</div>
	</div>

</body>
</html>