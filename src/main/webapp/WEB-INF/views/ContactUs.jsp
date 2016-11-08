<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<style>
#C02{
background-position:200px;
background-image:url("img/about_us.jpg");
}
#C03
{
width:470px;
height:300px;
background-color:#8D8E8F;
}

</style>
</head>
<body id="C02">
	<div class="container">
		<img src="img/contactus.png"/>
		<div class="row">
		<div class="col-sm-6">
			<form class="form-group col-sm-8" >
				<input class="form-control" style="padding:4px" placeholder="E-mail" type="email"/>
				<br>
				<input class="form-control" placeholder="Name" type="email"/>
				<br>
				<textarea class="form-control" rows="10" cols="10" placeholder="Message"></textarea>
				<br>
				<div class="btn btn-success" style="float:center">Submit</div>
			</form>
		</div><!-- End Col-6 for form-->

		<div class="col-sm-4 col-sm-offset-1">
			<div class="well" id="C03" >
				<iframe class="img-responsive" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3807.2021445202577!2d78.49010576431853!3d17.402084038069773!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bcb99c053bb2493%3A0xa952f890654bd16f!2sRTC+Cross+Road%2C+Himayatnagar%2C+Hyderabad%2C+Telangana!5e0!3m2!1sen!2sin!4v1478243460642" frameborder="0" style="width:430px; height:260px" allowfullscreen></iframe>
			</div><!-- End Col-4 for map-->
		</div><!-- End Well -->
		</div><!-- End row -->
		
	</div><!-- End container -->
</body>
</html>