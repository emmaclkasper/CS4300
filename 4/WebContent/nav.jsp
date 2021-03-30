<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
          <a class="navbar-brand" href="#"><i style="color: red">YOUSSEF </i><i style="font-size: 10px; color:yellow;">shop</i></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="Home.jsp">Home</a></li>
      <li class=""><a href="addcart?submit=mycart"><fmt:message key="home.panier" /></a></li>
      <li class=""><a href="order"><fmt:message key="home.cmd" /></a></li>
    </ul>
    <!--  ul class="nav navbar-nav navbar-right">
      <li><a href="#">Sign Up</a></li>
      <li><a href="#">Login</a></li>
    </ul>-->
    <ul class="nav navbar-nav navbar-right" ">
    <li><form ><select onchange="submit()" name="lang" style="margin-top: 35%;background: transparent;color: white;"> 
    <option value="en" style="background: black;">En</option>
    <option value="fr" <c:out value="${param.lang=='fr'?'selected':''}" />style="background: black;" >fr</option>
    <option value="ar" <c:out value="${param.lang=='ar'?'selected':''}" />style="background: black;" >ar</option>
    </select></form></li>
      <li ><a href="#" style="color:white;"><span class="glyphicon glyphicon-user"></span> ${sessionScope.username}</a></li>
      <li style="margin-top: 9px;"> <form action="logout" method="post"><span class="glyphicon glyphicon-log-in" style="color:white;"></span><input type="submit" name="logout" style="color:white;" class="btn btn-link" value=" <fmt:message key="home.logout"/>"></form></li>
    </ul>
  </div>
</nav>
</div>