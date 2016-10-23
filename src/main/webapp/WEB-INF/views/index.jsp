<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"/>

<c:choose>

<c:when test="${onclickLogin == 1}">
<jsp:include page="LoginPage.jsp"></jsp:include>
</c:when>

<c:when test="${onclickReg == 1}">
<jsp:include page="RegPage.jsp"></jsp:include>
</c:when>

<c:otherwise>

</c:otherwise>

</c:choose>


<jsp:include page="Footer.jsp"/>
</body>
</html>