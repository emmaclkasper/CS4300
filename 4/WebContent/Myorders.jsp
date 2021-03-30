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
<body style="background-color: #fdf1ec;">
<%@include file="nav.jsp" %>

<div class="container">
<center>  <h2>My orders</h2> </center>      
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Title</th>
        <th>Quantity</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${list}" var="cl">
          <tr>
        <td>${cl.design}</td>
        <td>${cl.qte }</td>
        <td>${cl.date}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
