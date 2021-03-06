package language;

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


@WebServlet("/language")
public class language extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
  
    public language() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title> Worksheet 16");
		out.println("</head><body><h1>Worksheet 16");
		
		String dbURL = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String query = "SELECT  c.name,l.Language, l.Percentage" + 
						"FROM country as  c" + 
						"INNER JOIN countrylanguage l ON c.code = l.CountryCode" + 
						"WHERE c.name like ?" + 
						"GROUP BY c.name, l.language, l.Percentage\n" + 
						"ORDER BY Percentage DESC" + 
						"LIMIT 0, ?";
		
		String id_1 = request.getParameter("country");
		String id_2 = request.getParameter("number");
		
		/*String [] id_3 = request.getParameterValues("continent");
		String [] name_3 = {"*", "*", "*", "*", "*"};
		for(int i = 0;i < id_3.length;i++)
			name_3[i] = id_3[i];
	
*/
		try { // need a try-catch in case there is a runtime error
			
			Connection connection = DriverManager.getConnection(dbURL, "root", "password"); // returns an object whose
			// type is Connection
			PreparedStatement pstmt = connection.prepareStatement(query); // this can be any type of SQL command
			// returns an object that is of type PreparedStatement

			pstmt.setString(1, id_1); // this fills in the gaps you have from above (the question marks) -- the data
			// you're going to insert is a String (hence setString)
			// first parameter = how many gaps; second parameter = what you want to fill
			// gaps with

			pstmt.setString(2, id_2);
		/*	
			for(int i = 0; i< name_3.length; i++)
				pstmt.setString(i+4, name_3[i]);
		*/		
			// this executes the query
			ResultSet rs = pstmt.executeQuery(); // returns a table of the result

			// get the result and process it row by row
			while (rs.next())
				System.out.println(rs.getString(1) + "\t" + rs.getString(2)); // 
			
				// get two Strings because in SELECT you
			// want code and name (3 things)
			connection.close(); // when you're done working with the database
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		out.println("</body></html>");
		out.close();
		
		
	}
	
	/*
	
	"SELECT country.name, city.name "
	+ "FROM city, country"
	+ "WHERE county.code = city.countrycode and " 
	+ "(city.name like ? and city.name like ? and city.name like ?)"
	+ "and (continent = ? or continent = ? or continent = ? or continent = ? or continent = ?)"
	+ "and city.population < ?";
	
	*/

}
