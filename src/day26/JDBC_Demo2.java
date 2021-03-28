package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Demo2 {

	public static void main(String[] args) throws SQLException {
	

		//1. create a connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "sandya84");
		
				//2 AND 3 CREATE AND EXCUTE THE STATMENT
			Statement stat=con.createStatement();
			//we store the string in the variable 
	String query="select * from employname";
		

			ResultSet rs=stat.executeQuery(query);
			// for only select class we have to use excutequery method and after that we have to store 
			//in Resultset variable
			// rs contain date from db we have to print ...so we use loop
			// but we dont know how much data it have.. while loop we have to use
			while(rs.next()) {
				int serial=rs.getInt("SNO");
			String city=rs.getString("SNAME");
			String sala=rs.getString("SALARY");
			System.out.println(serial+"  "+city+"  "+sala);
			
			
			}
			//4.close the connetion
			con.close();
			
			System.out.println("program is done!!!");
			
	
	
	
	
	
	
	
	
	
	
	}

}
