package org.jsp.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecord 
{
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String qry1="insert into jdbcpractice.student values(3, 'Rohan',88.88)";
		String qry2="insert into jdbcpractice.student values(4, 'Debashis',85.86)";
		String qry3="insert into jdbcpractice.student values(5, 'Deepak',98.66)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database server");
			stmt=con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("Record Inserted");
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
