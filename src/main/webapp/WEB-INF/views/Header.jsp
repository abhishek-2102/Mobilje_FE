<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Header</title>
  <style>
  .navbar-custom{
  border-radius:0;
  }
  body {
      position: relative;
  }
  .affix {
      top:0;
      width: 100%;
      z-index: 9999; <!-- important -->
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
<div class="container-fluid" style="background-color:;height:180px;">
		 <a class="brand" href="home"><img class ="img-responsive" src="img/insta.gif" alt="Brand"></a>
</div>
  	<div class="navbar navbar-inverse navbar-custom">
		<div class="container-fluid">
			<div class="navbar-header">	
  				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        			<span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				    <span class="icon-bar"></span>
				</button>		
			<a class="navbar-brand" href="home">MobilJe</a>						
			</div>
				<div class="collapse navbar-collapse" >
					      <ul class="nav navbar-nav ">
					        <li><a href="home">Home</a></li>
					        <li class="dropdown">
					          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products<span class="caret"></span></a>
					          <ul class="dropdown-menu">
					            <li><a href="#">Bedroom</a></li>
					            <li><a href="#">Living Room</a></li>
					            <li><a href="#">Kitchen and Dining</a></li>
					            <li><a href="#">Office and Study</a></li>
					          </ul>
					        </li>
					        <li><a href="contact_us">Contact Us</a></li>
					      </ul>
					      <ul class="nav navbar-nav navbar-right">
					        <li><a href="reg_page"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					        <li><a href="login_page"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					      </ul>
				</div>
  		</div>
  	</div>		
</body>
</html>