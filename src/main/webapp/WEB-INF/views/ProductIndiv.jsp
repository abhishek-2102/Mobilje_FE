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
padding:25px 10px 25px 10px;
}
#big{
padding:25px 10px 25px 10px;
width:500px;
}
</style>
</head>

<body>
<div class="container">
	<cw:forEach items="${indivData}" var="iData">
		<div class="col-sm-6 panel panel-default" style="margin-top:40px">
			<div class="col-sm-10 col-sm-offset-1" id="big">
				<img class="img-responsive" src="upimg/${iData.image1}">
			</div>
			
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image1}">
			</div>
			
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image2}">
			</div>
			
			<div class="col-sm-4" id="small">
				<img class="img-responsive" src="upimg/${iData.image3}">
			</div>
			
		</div><!-- End Col for outter box-->
		
	</cw:forEach>
</div>
</body>
</html>