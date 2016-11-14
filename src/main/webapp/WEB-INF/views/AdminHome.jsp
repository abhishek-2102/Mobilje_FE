<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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

<c:when test="${onclickCat == 1}">	  			<!-- Category Success -->
<jsp:include page="CatSuccess.jsp"/>
</c:when>

<c:when test="${onclickProd == 1}">	  			<!-- Product Success -->
<jsp:include page="ProdSuccess.jsp"/>
</c:when>

<c:when test="${onclickloginbutton == 1}"> 		<!-- Login Success -->
<jsp:include page="LoginSucces.jsp"/>
</c:when>

<c:when test="${onclickReg == 1}">  			<!-- Registration Success -->
<jsp:include page="RegSuccess.jsp"/>
</c:when>

<c:when test="${onclickSup == 1}">	  			<!-- Category Success -->
<jsp:include page="SupSuccess.jsp"/>
</c:when>

<c:otherwise>
<jsp:include page="AdminDemo.jsp"/>				<!-- Admin Default -->
</c:otherwise>

</c:choose>
<jsp:include page="Footer.jsp"/>				<!-- Footer -->
</body>
</html>