<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="language" value="${model.langue}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="language.text" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body style="" background="img/12.png">
<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><i style="color: red">YOUSSEF </i><i style="font-size: 10px; color:yellow;">shop</i></a>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
    </ul>
    <!--  ul class="nav navbar-nav navbar-right">
      <li><a href="#">Sign Up</a></li>
      <li><a href="#">Login</a></li>
    </ul>-->
  </div>
</nav>
</div>
<div>
<center><h1 style="font-family: Myfont;color:white;margin-top: 70px;">Welcom in youssef store...</h1></center>
</div>

<div style="margin-top: 90px;"><center>
<input type="button" class="btn btn-success" value="<fmt:message key="index.ident" />" onclick="location.href = 'login.jsp';">  
<input style="margin-left: 20px;" type="button" class="btn btn-success" value="<fmt:message key="index.insc" />" onclick="location.href = 'signup.jsp';">
</center></div>

</body>
</html>