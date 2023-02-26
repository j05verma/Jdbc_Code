package org.jsp.PreparedStatement.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchParticularRecords {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from JdbcPractice.student1 where sid=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter sid??");
		int sid=sc.nextInt();
		sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish with database server");
			pstmt=con.prepareStatement(qry);
			// set the data for placeholder before execution
			pstmt.setInt(1, sid);
			// execute sql query
			rs=pstmt.executeQuery();
			//check for record in cursor or buffer memory
			if(rs.next())
			{
				//fetch record from cursor or buffer memory
				String sname=rs.getString(2);
				String sbranch=rs.getString(3);
				double sper=rs.getDouble(4);
				System.err.println(" SName -> "+sname+"\n"+" SBranch -> "+sbranch+"\n"+" Sper -> "+sper);
			}
			else
			{
				System.err.println("No data found for sid "+sid);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
