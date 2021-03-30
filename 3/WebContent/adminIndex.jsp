<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="shopping.*"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="data" class="shopping.DBQuery" scope="session" />


<jsp:useBean id="beans" class="shopping.Beans" scope="session" />

<jsp:setProperty property="*" name="beans" />
<%-- <jsp:setProperty property="*" name="itemslist" /> --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if(session.getAttribute("username") != null && !data.isAdmin(session.getAttribute("username").toString()))
			response.sendRedirect(request.getContextPath() + "/login.jsp");
	
	
	%>
	<h1 align="center">List of Items</h1>
	<h3>
	<%
		//runs each time page load if button delete is clicked
		if(request.getParameter("delete") != null)
		{
			int item_id = Integer.parseInt(request.getParameter("delete"));
			out.println("Deleted item with id : " + item_id);
		}
	
	
		//ADDED AN ITEM MESSAGE
		if(request.getParameter("addItem") != null)
		{
			int item_id = Integer.parseInt(request.getParameter("addItem"));
			out.println("Added item with id : " + item_id);
		}
	%>
	</h3>
	<table border="1">


		<tr align="center">
			<td>Items</td>
			<td>Info</td>
		</tr> 
		
		<tr><%= data.listOfItem() %></tr>

	</table>
	<br />
	<br />
	<table>
		<tr>
			<td><a href="adminAddItems.jsp"><button id="addItem"
						name="addItemButton" onClick="addItem.jsp">add Item</button></a></td>
		</tr> 
		<tr>
			<td><a href="order.jsp"><button id="viewOrders"
						name="addOrdersButton">View Orders</button></a></td>
		</tr>
		<tr>
			<td><a href="accounts.jsp"><button id="viewAccounts"
						name="addViewAccountsButton">View Accounts</button></a></td>
		</tr>
		<tr>
			<td><a href="login.jsp?logout">Logout</a></td>
		</tr>
	</table>



</body>
</html>