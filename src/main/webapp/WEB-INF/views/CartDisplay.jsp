<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
<div class="container">
<c:if test="${dupMessage==true}">
	<div class="row">
		<h4 class="alert alert-warning text-center col-sm-6 col-sm-offset-3">Product exists in cart</h4>
	</div>
</c:if>

<c:if test="${upMessage==true}">
	<div class="row">
		<h4 class="alert alert-success text-center col-sm-6 col-sm-offset-3">Quantity Updated</h4>
	</div>
</c:if>

<c:if test="${delMessage==true}">
	<div class="row">
		<h4 class="alert alert-danger text-center col-sm-6 col-sm-offset-3">Product removed from cart</h4>
	</div>
</c:if>
<br><br>
<div class="col-sm-10 col-sm-offset-1">
	<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">Image</th>
						<th class="text-center">Product Name</th>
						<th style="padding-left:25px">Quantity</th>
						<th class="text-center">Price</th>
						<th class="text-center">Date</th>
					</tr>
				</thead>
				
		<c:forEach var="cart" items="${cart}">		
				<tbody>
					<tr class="text-center">
						<td width="150px"><img class="img-responsive" src="upimg/${cart.p_id}_1.jpg"></td>
						<td style="padding:30px;">${cart.p_name}</td>
						<td style="padding:20px;">
							<form action="updatequant" method="post">
							<div class="col-sm-6">
							<input class="form-control" value="${cart.quantity}" type="number" min="1" name="quant"/>
								<input type="hidden" value="${cart.ct_id}" name="ctid"/>	<!-- hidden -->
							</div>
									<button class="btn btn-primary" type="submit" style="height:32px">
									<i class="fa fa-plus-circle"></i></button>
							</form>
						</td>
						<td style="padding:30px;">${cart.price}</td>
						<td style="padding:30px;">${cart.date}</td>
						
						<td style="padding:20px;"><a href="deletCart?ctid=${cart.ct_id}" class="btn btn-danger" style="height:32px">
									<i class="fa fa-times-circle"></i></a></td>
					</tr>
				</tbody>
				
		</c:forEach>
			</table>
		</div><!-- end table responsive -->		

</div><!-- end col span -->
<br><br>
	<div class="">
		<a href="" class="btn btn-primary col-sm-3">Continue Shopping</a>
	</div>
	<div class="">
		<a href="checkout" class="btn btn-warning col-sm-3 col-sm-offset-6">Proceed to Checkout</a>
	</div>

<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
</div><!-- end container -->
</body>
</html>