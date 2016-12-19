<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://path/to/font-awesome/css/font-awesome.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1"
	crossorigin="anonymous">
</head>
<body>
<div class="contaienr">
<div class="col-sm-10 col-sm-offset-1">
	<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">Image</th>
						<th class="text-center">Product Name</th>
						<th class="text-center">Quantity</th>
						<th class="text-center">Price</th>
						
					</tr>
				</thead>
				<%Object cart=session.getAttribute("Cart"); %>
		<c:forEach var="cart" items="<%=cart%>">		
				<tbody>
					<tr class="text-center">
						<td width="150px"><img class="img-responsive" src="upimg/${cart.p_id}_1.jpg"></td>
						<td style="padding:30px;">${cart.p_name}</td>
						<td style="padding:20px;">${cart.quantity}</td>
						<td style="padding:30px;">${cart.price}</td>
					</tr>
				</tbody>
		</c:forEach>
			</table>
			<div class="jumbotron text-right" style="padding:10px; color:green; font-size:20px;"><b>Total:<%=session.getAttribute("total") %></b></div>
			
			<div class="col-sm-6 col-sm-offset-6">

			</div><!-- end shipping address -->

			<div class="col-sm-6 col-sm-offset-6">

			</div><!-- end billing address -->
			
			
			<input name="_eventId_back" class="btn btn-primary col-sm-3 col-sm-offset-1" value="Cancel" type="submit">
			<input name="_eventId_payment" class="btn btn-success col-sm-3 col-sm-offset-4" value="Proceed to payment" type="submit">
			
		</div><!-- end table responsive -->
</div><!-- end col span -->

</div><!-- end container -->
</body>
</html>