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
<center>

<div include="form-input-select()" style="margin-top: -9px;">
<form action="cat" method="post">
  <select required name="cate">
  <c:forEach items="${cate}" var="ca">
				      <option value="Adventure">${ca}</option>
</c:forEach>
  </select>
  <input type="submit" value="choisir" name="submit">
  </form>
</div></center>
<sql:setDataSource dataSource="jdbc/mvc"/>
<sql:query var="catalo">
select *from article 
</sql:query><div class="container" style="float: left">
<div class="row" >
<div class="row mb-5">
 <c:forEach items="${catalo.rows}" var="ar">

   
            <div class="col-sm-6 col-md-4 col-lg-3 mt-4" >
                <div class="card card-inverse card-info">
                    <img class="card-img-top" src="img/${ar.img}" style="height: 200px;">
                    <div class="card-block">
                       
                        <h6 class="card-title" style="font-size: 15px;">${ar.design }</h6>
                        <div class="card-text">
                            ${ar.prix } $
                        </div>
                    </div>
                    <div class="card-footer">
                        
                        <a class="btn btn-info float-right btn-sm" href="controleur?submit=detail&id=${ar.id} "><fmt:message key="home.det" /></a>
                    </div>
                </div>
            </div>
   
        
        
       
      </c:forEach> </div></div></div>
</body>
</html>
