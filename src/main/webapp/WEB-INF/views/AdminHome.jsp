<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="http://path/to/font-awesome/css/font-awesome.min.css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<jsp:include page="AdminHeader.jsp"/>			<!-- Admin Header -->

<c:choose>
<c:when test="${onclickCategory == 1}">	  		<!-- Category -->
<jsp:include page="Category.jsp"/>
</c:when>

<c:when test="${onclickSupplier == 1}">	  		<!-- Supplier -->
<jsp:include page="Supplier.jsp"/>
</c:when>

<c:when test="${onclickProduct == 1}">	  		<!-- Product -->
<jsp:include page="Product.jsp"/>
</c:when>

<c:otherwise>
<jsp:include page="AdminDemo.jsp"/>				<!-- Admin Default -->
</c:otherwise>

</c:choose>
<jsp:include page="Footer.jsp"/>				<!-- Footer -->
</body>
</html>