<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>

<html>
<head>
<title>JDBC Connection example</title>
</head>

<body>
<h1>JDBC Connection example</h1>

<%
  String db = request.getParameter("db");
  String user = db; // assumes database name is the same as username
  
  String name=request.getParameter("gucci");
  String price=request.getParameter("price");
  
  Connection conn = null;
  String dbURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

  try {
    java.sql.Connection con;
    Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(dbURL, "root", "password");
    
    Statement st=conn.createStatement();

    int i=st.executeUpdate("insert into test.accessories(item,price)values('hello','howdy')");
    out.println("Data is successfully inserted!");
    
  
  }
  catch(SQLException e) {
    out.println("SQLException caught: " +e.getMessage());
  }
%>

</body>
</html>
