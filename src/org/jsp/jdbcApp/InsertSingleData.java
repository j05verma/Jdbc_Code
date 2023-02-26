package org.jsp.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleData
{
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry="insert into JdbcPractice.student values (3, 'Abcd',58.80)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish with Data Base Server");
			stmt=con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry);
			System.out.println("Record Inserted ");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("Closed all costly Resources");
		}
	}
}
