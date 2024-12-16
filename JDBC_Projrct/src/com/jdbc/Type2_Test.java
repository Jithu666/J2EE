package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type2_Test {

	private static final String SALES_MARKETS_QUERY = "SELECT * FROM MARKETS";
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		
		String url = "jdbc:mysql://localhost:3306/sales";
		String user = "root";
		String password = "jiu";


		try {
			// Register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection.
			Connection con = DriverManager.getConnection(url, user, password);
			// create statement object
			if(st!=null)
				st = con.createStatement();
			// send and execute sql query.
			if(st!=null)
				rs = st.executeQuery(SALES_MARKETS_QUERY);
			// process the resultset
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getString(1)+ " " + rs.getString(2) + rs.getString(3));
				} // while
			} // if
				
		} // try 
		catch (SQLException se){
			se.printStackTrace();
		}
		
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// close jdbc objects
			try {
				if(rs!=null) 
					rs.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			} 
			catch (SQLException se) {	
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}
			
		}	//finally block
	}		// main method
}			// class ConnTest
