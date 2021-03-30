<%@ page import="shopping.*"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>


<jsp:useBean id="data" class="shopping.DBQuery" scope="session" />


<jsp:useBean id="beans" class="shopping.Beans" scope="session" />
<jsp:setProperty property="*" name="beans" />

<HTML>
<HEAD>
<TITLE>Login</TITLE>
</HEAD>
<BODY>
	<%
		//logout user
		if (request.getParameter("logout") != null)
			session.removeAttribute("username");

		if (session.getAttribute("username") != null)
			response.sendRedirect(request.getContextPath() + "/index.jsp");
	%>

	<form action='' method='POST'>
		Username: <input type="text" name="username" /> <br> Password: <input
			type="password" name="password" /><br> <a href="register.jsp">Register
			now!</a><br> <input type="submit" value="Login" />
	</form>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userpwAdmin = "admin";

		if ((username == "") && (password == "")) {
			out.println("Please enter a username and password");

		} else if (username == "") {
			out.println("Please enter a username");

		} else if (password == "") {
			out.println("Please enter a password");
		} else if (username != null && password != null) {

			//Statement statement = null;
			/* 						if (data.exist(username, password)) {
									if(username.equals("admin")  && password.equals("admin"))
									{
											response.sendRedirect(request.getContextPath() + "/adminIndex.jsp");
									}
									else
									{ */
			//session.setAttribute("username", username);
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
			/* } */

			if (data.exist(username, password)) {
				session.setAttribute("username", username);
				if (data.isAdmin(username))
					response.sendRedirect(request.getContextPath() + "/adminIndex.jsp");
				else
					response.sendRedirect(request.getContextPath() + "/index.jsp");
			} else {
				out.println("Username and password doesn't exist");
			}
		}
	%>

</BODY>
</HTML>