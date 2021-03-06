package hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbConnect {
	public static void main(String[] args) {
	//String query = "SELECT code, name FROM country WHERE continent = 'North America' and code = ?";
	//assume you take the countrycode from the user 
	// ? inside the query means you want to read the value later 
	String query = "SELECT code, name FROM country WHERE continent = 'North America' and (code = ? or code = ?)";
	String id = "can"; //request.getParameter("id")  in JSP
	String id_2 = "usa";
	
	try { //need a try-catch in case there is a runtime error
		String dbURL = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
 //retrieved from mySQL workbench 
		Connection connection = DriverManager.getConnection(dbURL, "root", "password"); //returns an object whose type is Connection 
		PreparedStatement pstmt = connection.prepareStatement(query); //this can be any type of SQL command
		//returns an object that is of type PreparedStatement
		
		pstmt.setString(1,  id); //this fills in the gaps you have from above (the question marks) -- the data you're going to insert is a String (hence setString)
		//first parameter = how many gaps; second parameter = what you want to fill gaps with 
		
		pstmt.setString(2,  id_2);
		
		//this executes the query
		ResultSet rs = pstmt.executeQuery(); //returns a table of the result 
		
		//get the result and process it row by row
		while(rs.next()) 
			System.out.println(rs.getString(1) + "\t" + rs.getString(2)); //get two Strings because in SELECT you want code and name (2 things)
		connection.close(); //when you're done working with the database 
	} catch (SQLException e) {
		e.printStackTrace();
		
		} //catch
	}
}

