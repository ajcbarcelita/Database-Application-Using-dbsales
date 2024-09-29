package dbapp_using_dbsales;

import java.sql.*;

public class EmployeeRecords {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = MySQLConnection.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees");

			System.out.println("Employee Records");
			System.out.println("=================================================");
			System.out.println("Employee Number\tLast Name\tFirst Name\tExtension\tEmail\tOffice Code\tReports To\tJob Title");
			System.out.println("=================================================");
			while (rs.next()) {
			    int id = rs.getInt("employeeNumber");
			    String name = rs.getString("lastName");
			    String firstName = rs.getString("firstName");
			    String extension = rs.getString("extension");
			    String email = rs.getString("email");
			    String officeCode = rs.getString("officeCode");
			    int reportsTo = rs.getInt("reportsTo");
			    String jobTitle = rs.getString("jobTitle");

			    // Use printf to align columns properly
			    System.out.printf("%-10d %-15s %-15s %-10s %-30s %-10s %-10d %-20s%n", 
			        id, name, firstName, extension, email, officeCode, reportsTo, jobTitle);
			    System.out.println("--------------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
