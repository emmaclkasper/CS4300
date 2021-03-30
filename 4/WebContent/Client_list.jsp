<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<c:set var="language" value="${not empty param.lang?param.lang:not empty lang?lang:model.langue}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style_home.css">

	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
          <a class="navbar-brand" href="#"><i style="color: red">YOUSSEF </i><i style="font-size: 10px; color:yellow;">shop</i></a>
    </div>
    <ul class="nav navbar-nav">
<li class=""><a href="lsar">Home</a></li>
      <li class="active"><a href="lsclient"><fmt:message key="home_admin.client" /></a></li>
      <li class=""><a href="lscmd"><fmt:message key="home_admin.order" /></a></li>
      <li class=""><a href="Add_ar.jsp"><fmt:message key="home_admin.add" /></a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right" ">
      <li><form ><select onchange="submit()" name="lang" style="margin-top: 35%;background: transparent;color: white;"> 
    <option value="en" style="background: black;">En</option>
    <option value="fr" <c:out value="${param.lang=='fr'?'selected':''}" />style="background: black;" >fr</option>
    <option value="ar" <c:out value="${param.lang=='ar'?'selected':''}" />style="background: black;" >ar</option>
    </select></form></li>
      <li ><a href="#" style="color:white;"><span class="glyphicon glyphicon-user"></span> admin</a></li>
      <li style="margin-top: 9px;"> <form action="logout" method="post"><span class="glyphicon glyphicon-log-in" style="color:white;"></span><input type="submit" name="logout" style="color:white;" class="btn btn-link" value=" <fmt:message key="home.logout"/>"></form></li>
    </ul>
  </div>
</nav>
</div>

<div class="container">
  <h2><fmt:message key="ls_client.tit" /></h2>          
  <table class="table table-hover">
    <thead>
      <tr>
        <th><fmt:message key="ls_client.nom" /></th>
        <th><fmt:message key="ls_client.mail" /></th>
        <th><fmt:message key="ls_client.adress" /></th>
        <th><fmt:message key="ls_client.tel" /></th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${clients}" var="cl">
          <tr>
        <td>${cl.nom}</td>
        <td>${cl.email }</td>
        <td>${cl.adresse}</td>
         <td>${cl.tel}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>