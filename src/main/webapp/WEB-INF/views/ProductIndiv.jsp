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
padding:25px 50px 25px 0px;
width:500px;
}
</style>
</head>

<body>
<div class="container">
	<cw:forEach items="${indivData}" var="iData">
		<div class="col-sm-6 panel panel-default" style="margin-top:40px">
			<div class="col-sm-10 col-sm-offset-1" id="big">
				<img class="img-responsive" src="upimg/${iData.image1}" id="imgb">
			
			</div><!-- end top image -->
			
		<div class="row">
		<h6 align="center">Click to change image</h6>
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