<%@ page import = "shopping.*" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "java.sql.Statement" %>
<jsp:useBean id="data" class="shopping.DBQuery" scope = "session" />
<jsp:useBean id="beans" class="shopping.Beans" scope = "session" />

<HTML> 
	<HEAD>
			<TITLE>Registration</TITLE>
	</HEAD>
		<BODY>
			<form action='' method='POST'>
			Username: 
			<input type="text" name="username" /> <br>
			Password:
			<input type="password" name="password" /><br>
			<input type="submit" value="Create account" /></form>
			<%
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				if ((username == "")  && (password == "")) 
				{
					out.println("Please enter a username and password");
					
				}
				else if(username == "")
				{
					out.println("Please enter a username");
					
				}
				else if (password == "") 
				{
					out.println("Please enter a password");
				}
				else if((username != null) && (password != null))
				{
					data.insertRecordIntoTable(username, password);
					response.sendRedirect(request.getContextPath() + "/login.jsp");				
				}	
			%>
			
		</BODY>
</HTML>