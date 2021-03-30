<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="language" value="${not empty param.lang?param.lang:not empty lang?lang:model.langue}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="language.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="nav.jsp" %>

<div class="container">
	<div class="row">
		<div class="col-xs-8">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<div class="row">
							<div class="col-xs-6">
								<h5><span class="glyphicon glyphicon-shopping-cart"></span><fmt:message key="cart.cart" /></h5>
							</div>
							<div class="col-xs-6">
								<a type="button" class="btn btn-primary btn-sm btn-block" href="Home.jsp">
									<span class="glyphicon glyphicon-share-alt"></span><fmt:message key="cart.continue" />
								</a>
							</div>
						</div>
					</div>
				</div>
				<c:forEach items="${info.cart}" var="er">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-2"><img class="img-responsive" src="img/${er.img}" style="height: 70px;width: 100px">
						</div>
						<div class="col-xs-4">
							<h6 class="product-name"><strong>${er.design}</strong></h6>
						</div>
						<form action="cmd" method="post">
						<div class="col-xs-6">
							<div class="col-xs-6 text-right">
								<h6><strong>${er.prix}<span class="text-muted"> x</span></strong></h6>
							</div>
							
							<div class="col-xs-4" style="margin-left: -25px;">
								<input type="text" class="form-control input-sm" value="1" name="nbr">
								<input value="${er.id_art}" type="hidden" name="id">
							</div>
							<div class="col-xs-2" style="margin-top: 3px;margin-left: -25px">	
							<input name="submit" type="submit" value="<fmt:message key="cart.check" />" title="szs" class="btn btn-info btn-xs"> 
							</div>
						</div>
						</form>
					</div>
				</div>
				<hr>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</body>
</html>