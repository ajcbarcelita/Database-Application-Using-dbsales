package dbapp_using_dbsales;

import java.sql.*; //imports Connection, DriverManager, SQLException

public class MySQLConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/dbsales";
	private static final String USER = "root";
	private static final String PASSWORD = "Frieren.#6950";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
