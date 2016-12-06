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
#box{
margin-top:20px;
}
#inbox{
height:200px;
padding:20px 10px 20px 10px;
}
#botbox{
line-height:70%;
padding:0px 10px 20px 10px;
}
</style>
<script>

</script>
</head>
<body>

<div class="container-fluid">

<c:if test="${pMess == true}">
<div class="row">
<h4 class="alert alert-success text-center col-sm-6 col-sm-offset-3">Product Added to cart</h4>
</div>
</c:if>

<c:forEach var="prod" items="${pData}">
	<div class="col-sm-3 text-center" id="box">
		<div class="panel panel-defualt">
		<div class="panel-body" id="inbox">
			<div >
				<a href="indivProdDisp?pid=${prod.p_id}">
				<img class="img-rounded img-responsive" src="upimg/${prod.image1}" >
				</a>
			</div><!-- end align -->
		</div><!-- end panel body-->
			<div id="botbox" >
			
				<p><span><b>${prod.p_name}</b></span></p>
				<p style="color:blue"><span><b>Rs.${prod.p_price}</b></span></p>
				<p style="color:green"><span><b>Stock:${prod.stock}</b></span></p>
				
				<a id="onclick-add" class="btn btn-warning" href="tocart?pid=${prod.p_id}&pname=${prod.p_name}">
		  		Add to cart <i class="fa fa-tags "></i></a>
				<a class="btn btn-success" href="#" >
		 	 	Buy Now <i class="fa fa-truck"></i></a>
			
			</div><!-- end panel footer -->
		</div><!-- End pannel -->
	</div><!-- End col -->
</c:forEach><!-- End ForEach -->
</div><!-- End Container -->
</body>
</html>