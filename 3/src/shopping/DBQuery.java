package shopping;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.*;
import java.util.ArrayList;

public class DBQuery {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USER = "scott";
	private static final String DB_PASSWORD = "tiger";

	public static void main(String[] argv) throws SQLException {
	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	public void insertRecordIntoTable(String username, String password) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO users" + "(user_id, username, password, user_type_id) VALUES"
				+ "(ID_SEQ.NEXTVAL,?,?, 2)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// execute insert SQL statement
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public boolean exist(String username, String password) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean exist = false;

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection
					.prepareStatement("SELECT USERNAME, PASSWORD from users WHERE USERNAME = ? AND PASSWORD = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();

			exist = resultSet.next();
			System.out.println("Account Exist : " + exist);
			;

		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ignore) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ignore) {
				}
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException ignore) {
				}
		}

		return exist;
	}

	public boolean isAdmin(String username) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isAdmin = false;

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement("SELECT user_type_id from users WHERE USERNAME = ?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next())
				isAdmin = resultSet.getString("user_type_id").equals("1");
			System.out.println("user " + username + " is admin : " + isAdmin);

		} catch (Exception e) {
			System.out.println("isAdmin error : " + e.getMessage());
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException ignore) {
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException ignore) {
				}
			if (dbConnection != null)
				try {
					dbConnection.close();
				} catch (SQLException ignore) {
				}
		}

		return isAdmin;
	}

	public String listOfItem() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		String data = "";

		String selectTableSQL = "SELECT NAME, item_id from ITEM";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);
			Beans row = new Beans();
			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {
				row.setItemName(rs.getString("NAME"));
				String name = rs.getString("NAME");

				data += "<tr>" + " <td>" + name + "</td>" + " <td><a href='adminItems.jsp?item_id="
						+ rs.getString("item_id") + "'>Get Details</a></td>" + "</tr>";

				System.out.println(row.getItemName());

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return data;
	}

	public void selectRegisteredAccounts() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT USERNAME, PASSWORD from users";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
			Beans row = new Beans();
			while (rs.next()) {
				row.setUsername(rs.getString("USERNAME"));
				row.setPassword(rs.getString("PASSWORD"));
				System.out.println(row.getUsername());
				System.out.println(row.getPassword());

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public void selectRecordsFromDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT FIRSTNAME, LASTNAME from DBUSER";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");

				System.out.println("First name : " + firstname);
				System.out.println("Last name : " + lastname);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public String displayList() throws SQLException {
		ArrayList<String> al = new ArrayList<String>();
		Connection dbConnection = null;
		Statement statement = null;
		String data = "";

		String selectTableSQL = "SELECT FIRSTNAME, LASTNAME from DBUSER";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				al.add(rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));

			}
			for (String display : al) {
				data += "<tr> <td>" + display + " " + "</td> </tr>";
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return data;
	}

	public Item getItem(int item_id) throws SQLException {
		Connection dbConnection = null;
		PreparedStatement statement = null;

		String selectTableSQL = "select name, price, item_description, quantity from item where item_id = ?";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.prepareStatement(selectTableSQL);
			statement.setInt(1, item_id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Item item = new Item();
				item.setName(resultSet.getString("name"));
				item.setDescription(resultSet.getString("item_description"));
				item.setPrice(resultSet.getDouble("price"));
				item.setQuantity(resultSet.getInt("quantity"));
				return item;
			} else {
				return null;
			}

		} catch (SQLException e) {

			System.out.println("getItem : ");
			e.printStackTrace();

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return null;
	}

	public void deleteItem(int item_id) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteTableSQL = "delete from item where item_id=?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteTableSQL);

			// execute insert SQL statement
			preparedStatement.setInt(1, item_id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	public Item addItem(int item_id,String name, double price, String description, int quantity) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO item" + "(item_id,name, price, description,quantity) VALUES"
				+ "(ID_SEQ.NEXTVAL,?,?, 2)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			// execute insert SQL statement
			preparedStatement.setInt(1, item_id);
			preparedStatement.setString(2, name);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, description);
			preparedStatement.setInt(5, quantity);

			preparedStatement.executeUpdate();

			System.out.println("Record is inserted into Item table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return null;
     }

	public void updateItem(int item_id, String name, double price, String description, int quantity)
			throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "update item set name=?, price=?, item_description=?, quantity=? where item_id=?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			// execute insert SQL statement
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, description);
			preparedStatement.setInt(4, quantity);
			preparedStatement.setInt(5, item_id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	

}
