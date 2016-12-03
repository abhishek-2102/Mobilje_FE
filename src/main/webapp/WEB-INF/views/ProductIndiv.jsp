<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="cw" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<style>
#small{
padding:0px 10px 25px 10px;
}
#big{
padding:25px 0px 25px 0px;
width:500px;
}

</style>
</head>

<body>
<div class="container">
	<cw:forEach items="${indivData}" var="iData">
	<div class="col-sm-6 panel panel-default " style="margin-top:40px">
	
			<div class="col-sm-10 col-sm-offset-1" id="big">
				<img class="img-responsive" src="upimg/${iData.image1}" id="imgb">
			</div><!-- end top image -->
	
		<div class="row">
		<h6 align="center" style="color:grey">Click to change image</h6>
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image1}" id="imgs1">
			</div>
			
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image2}" id="imgs2">
			</div>
			
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image3}" id="imgs3">
			</div>
		</div><!-- end bottom image -->
	</div><!-- End Col for outter box-->
	
		<div class="col-sm-6" style="margin-top:30px">
			<h6 style="color:grey">${category}</h6>
			<h1>${iData.p_name}</h1>
			<h4 style="color:red">Rs.${iData.p_price}/-</h4>
			
			<form action="tocart">
			<input class="form-control" type="number" name="quantity" />
			
			<br>
			<br>
			<a class="btn btn-lg btn-success" href="#">
		 	 	Buy Now <i class="fa fa-truck"></i></a>
		 	 	
			<button  type="submit"  class="btn btn-lg btn-warning" >
		  		Add to cart <i class="fa fa-tags"></i></button>
		  	</form>	
			
			<h4>Description:</h4>
			
			<pre style="font-family:candra; font-size:medium;">${description}</pre>
			
	</div>
	</cw:forEach>
</div>
<script>
$(function(){
	$('#imgs1').click(function(){
		var val=$('#imgs1').attr('src');
		
		$('#imgb').attr('src',val);
	});
	$('#imgs2').click(function(){
		var val=$('#imgs2').attr('src');
			
		$('#imgb').attr('src',val);
	});
	$('#imgs3').click(function(){
		var val=$('#imgs3').attr('src');
		
		$('#imgb').attr('src',val);
	});
});
</script>
</body>
</html>