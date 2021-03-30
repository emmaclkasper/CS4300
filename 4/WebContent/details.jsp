<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="language" value="${model.langue}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div class="wrapper">
    <div class="product-img">
      <img src="img/${info.detail.photo}" height="420" width="327">
    </div>
    <div class="product-info">
      <div class="product-text" style="margin-left: 10px;">
        <h1>${info.detail.designation}</h1><br><br>
        <h6> <fmt:message key="detail.aut" /> : ${info.detail.auteur} </h6>
        <h6><span><fmt:message key="detail.price" /> :  ${info.detail.prix}</span>$</h6>
        <h6><span><fmt:message key="detail.stock" /> :  ${info.detail.stock}</span></h6><br>
      </div>
      <div class="product-price-btn">   
       <center> <a class="btn btn-info" href="addcart?submit=add&id=${info.detail.id}" ><fmt:message key="detail_panier" /></a>
     </center> </div>
    </div>
  </div>

</body>
</html>