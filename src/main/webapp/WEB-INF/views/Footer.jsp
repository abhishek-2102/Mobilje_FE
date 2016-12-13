<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.tooltip {
    position: relative;
    display: inline-block;
    border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
    visibility: hidden;
    width: 120px;
    background-color: black;
    color: #fff;
    
    border-radius: 6px;
    padding: 5px 0;
    position: absolute;
    z-index: 1;
    top: 150%;
    left: 50%;
    margin-left: -60px;
}

.tooltip .tooltiptext::after {
    content: "";
    position: absolute;
    bottom: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: transparent transparent black transparent;
}

.tooltip:hover .tooltiptext {
    visibility: visible;
}
</style>
</head>

<body>
	<div class="container-fluid" style="background-color: #222222">
		<footer>
		<div class="container" style="color: #ffffff">
			<div class="row">
				<div class="col-sm-2">
				<h3 style="color:#0080ff;">MOBILJE</h3>
					<h6>
						Copyright &copy; 2016 <br>Mobilje
						<p>
							<br>Logo Credits:<br>Shanawaz
							<p>Call us:9876543210</p>	
						</p>
					</h6>

				</div>
				<!-- end col-sm-2 -->

				<div class="col-sm-8">
				<br>
					<h5 style="color:#0080ff;">About Us</a></h5>
						
						<p style="text-align:justify"> We aspire to get you the best products with 
						world class service with best advice at your door step. You will not have to
						get out of your house or roam around to pick any furniture for your house.</p>
						<p> For more details <a href="about_us">Click Here</a></p>
					
				</div>
				<!-- end col-sm-4 -->

				<!--	<div class="col-sm-2">
						<div class="text-center center-block">
						<h6>Navigation</h6>
						</div>
						<ul class="unstyled">
							<li><a href="Home">Home</a></li>
							<li><a href="Services">Services</a></li>
							<li><a href="Contact">Contact</a></li>
						</ul>
						
					</div><!-- end col-sm-2 -->

				<div class="col-sm-2">
<br>
					<p class="txt-railway" style="color:#0080ff;">Follow us</p>
					
					<a href="https://www.facebook.com/abhishek.b.0221"><span class="fa fa-facebook-official fa-2x" style="color:white"></span></a> 
					<a href="#"><span class="fa fa-steam fa-2x" style="color:white"></span></a>
					<a href="https://github.com/abhishek-2102/Mobilje_FE.git"><span class="fa fa-github fa-2x" style="color:white"></span></a>
					<a href="https://plus.google.com/u/0/108465920621098787961"><span class="fa fa-google-plus fa-2x" style="color:white"></span></a>
	
				</div>
				<!-- end col-sm-2 -->
</div><!-- end container -->
			</div>
			<!-- end row -->
		</div>
		<!-- end container fluid --> </footer>
</body>
</html>