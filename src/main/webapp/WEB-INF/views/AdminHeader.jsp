<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">  
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <style>
  body {
      position: relative;
  }
  .affix {
      top:0;
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

<div class="container-fluid" style="background-color:white; height:180px;">
  <div class="col-sm-4">
  <a class="brand" href="home"><img src="img/insta.gif" alt="Brand"></a>
  </div>
  <div class="col-sm-8">
  		<%=session.getAttribute("username") %></h5>
	</div>
  </div>
<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
      </button>
			<a class="navbar-brand" href="#">MobilJe</a>						
			</div>
				<div class="collapse navbar-collapse" >
					      <ul class="nav navbar-nav ">
					          <li><a  href="productPage">Products</a></li>
					          <li><a  href="supplierPage">Supplier</a></li>
					          <li><a  href="categoryPage">Category</a></li>					        
					      </ul>
					      <ul class="nav navbar-nav navbar-right">
					        <li><a href="reg_page"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					        <li><a href="login_page"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
					      </ul><!-- End Right side navbar -->
      </div>
    </div>
</nav>
  </body>
</html>