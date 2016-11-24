<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style>
.panel:hover {
    -webkit-filter: drop-shadow(3px 3px 5px black); /* Safari */
    filter: drop-shadow(3px 3px 5px black);
}
.repeat2{
margin-top:10px;
line-height:70%
}
</style>
</head>
<body>

<div class="container-fluid">
<c:forEach var="prod" items="${pData}">
	<div class="col-sm-2 text-center " id="div1">
	<div class="panel panel-defualt">
		<div class="body_img" >
			<a href="#"><img class="img-rounded img-responsive" src="img/placeholder.gif" alt="Placeholder"></a>
		</div>
		<div class="repeat2">
			<p><span><b>${prod.p_name}</b></span></p>
			<p style="color:blue"><span><b>Rs.${prod.p_price}</b></span></p>
			<p style="color:green"><span><b>Stock:${prod.stock}</b></span></p>
		</div><!-- end input text -->
		<div>	
		</div><!--  -->
		</div><!-- End pannel -->
	</div><!-- End col -->
</c:forEach><!-- End ForEach -->


</div><!-- End Container -->
</body>
</html>