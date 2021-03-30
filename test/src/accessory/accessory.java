package accessory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accessory")
public class accessory extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public accessory() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title> Worksheet 16");
		out.println("</head><body><h1>Worksheet 16");

		String name = request.getParameter("name");
		String price = request.getParameter("price");

		String dbURL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		// String query = "INSERT INTO
		// accessories(first_name,last_name,city_name,email)values('"+name+"','"+price+"')";

		try { // need a try-catch in case there is a runtime error

			Connection connection = DriverManager.getConnection(dbURL, "root", "password"); // returns an object whose
			// type is Connection
			Statement st = connection.createStatement();

			int i = st.executeUpdate("insert into test.accessories(first_name,last_name,city_name,email)values('" + name
					+ "','" + price + "')");
			out.println("Data is successfully inserted!");
			connection.close(); // when you're done working with the database
		} catch (SQLException e) {
			e.printStackTrace();

		}

		out.println("</body></html>");
		out.close();

	}

}
