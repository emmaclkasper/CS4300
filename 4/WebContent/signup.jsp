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
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body background="img/12.png">

<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><i style="color: red">YOUSSEF </i><i style="font-size: 10px; color:yellow;">shop</i></a>
    </div>
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
<div class="container">    
        <div id="loginbox" style="margin-top:50px;margin-left: 33%;" class="mainbox col-md-4 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                        <div class="panel panel-info" >
                
                     <div class="panel-heading" style="background-color:green;">
                        <div class="panel-title" style="color:white"><fmt:message key="insc.desc" /></div>
                    </div> 

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form" method="post" action="signup">
                                    
                             <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                       <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="<fmt:message key="insc.nom" />">                                        
                                    </div>
                                    
                                 <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="	glyphicon glyphicon-envelope"></i></span>
                                       <input id="login-username" type="text" class="form-control" name="email" value="" placeholder="<fmt:message key="insc.email" />">                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="input-group">
                                      <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                       <input id="login-username" type="text" class="form-control" name="adress" value="" placeholder="<fmt:message key="insc.addr" />">                                        
                                    </div>
                                    
                                     <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="	glyphicon glyphicon-earphone"></i></span>
                                       <input id="login-username" type="text" class="form-control" name="phone" value="" placeholder="<fmt:message key="insc.tel" />">                                        
                                    </div>
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="<fmt:message key="insc.pass" />">
                                    </div>

                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                      <input name="submit" type="submit" id="btn-login"  class="btn btn-success" value="<fmt:message key="insc.desc" />">
                             
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            
                                     <center>  <a href="login.jsp" >
                                            Log In Here
                                        </a></center> 
                                        </div>
                                    </div>
                                </div>    
                            </form>     
                        </div>                     
                    </div>  
        </div>
</div>
</body>
</html>