<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
<jsp:include page="Header.jsp"/> 				<!-- Include Header -->

<c:choose> 
<c:when test="${onclickhome == 1}">				<!-- Home -->
<jsp:include page="home.jsp"/>
</c:when>

 
<c:when test="${onclickAdminHome == 1}">		<!-- Admin Home -->
<jsp:include page="AdminHome.jsp"/>
</c:when>

<c:when test="${onclickContact == 1}">			<!-- Home -->
<jsp:include page="ContactUs.jsp"/>
</c:when>

<c:when test="${onclicklogin == 1}"> 			<!--Login page  -->
<jsp:include page="LoginPage.jsp"/>
</c:when>

<c:when test="${onclickRegPage == 1 }">  		<!-- Registration Page -->
<jsp:include page="RegPage.jsp"/>
</c:when>

<c:when test="${onclickAbout_Us == 1}">  		<!-- About Us -->
<jsp:include page="AboutUs.jsp"/>
</c:when>

<c:when test="${userProduct == 1}">  		<!-- User display Product -->
<jsp:include page="ProductDisplay.jsp"/>
</c:when>

<c:otherwise>
<jsp:include page="home.jsp"/>					<!-- Default Page -->
</c:otherwise>
</c:choose>

<jsp:include page="Footer.jsp"/>				<!-- Include Footer -->
</body>
</html>