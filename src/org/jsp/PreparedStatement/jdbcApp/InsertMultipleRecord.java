package org.jsp.PreparedStatement.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMultipleRecord {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into JdbcPractice.student1 value(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish with database server");
			pstmt=con.prepareStatement(qry);
			//Set the value for placeholder before execution //
			
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Jayant");
			pstmt.setString(3, "EE");
			pstmt.setDouble(4, 57.10);
			//Execute sql query //
			pstmt.executeUpdate();
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Rinku");
			pstmt.setString(3, "XII");
			pstmt.setDouble(4, 78.80);
			//Execute sql query //
			pstmt.executeUpdate();
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Verma");
			pstmt.setString(3, "X");
			pstmt.setDouble(4, 68.00);
			//Execute sql query //
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)
				try {
					pstmt.close();
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
