<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Mobilje</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<jsp:include page="Header.jsp"/>

<c:choose>
<c:when test="${onclickhome == 1}">
<jsp:include page="home.jsp"/>
</c:when>

<c:when test="${onclicklogin == 1}"> <!--Login page  -->
<jsp:include page="LoginPage.jsp"/>
</c:when>

<c:when test="${onclickloginbutton == 1}"> <!-- Login Success -->
<jsp:include page="LoginSucces.jsp"/>
</c:when>

<c:when test="${onclickRegPage == 1 }">  <!-- Registration Page -->
<jsp:include page="RegPage.jsp"/>
</c:when>

<c:when test="${onclickReg == 1}">  <!-- Registration Success -->
<jsp:include page="RegSuccess.jsp"/>
</c:when>

<c:otherwise>
<jsp:include page="home.jsp"/>
</c:otherwise>


</c:choose>
<jsp:include page="Footer.jsp"/>
</body>
</html>