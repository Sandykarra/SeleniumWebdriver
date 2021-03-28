package day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* 1.create a connection
 * 2.create statment/query
 * 3.excute statment/query
 * 4.close the connection*/
 
 
public class JDBC_Demo {

	public static void main(String[] args) throws SQLException {
		
//1. create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "sandya84");
	// WE USE CONNECTION CLASS FOR THIS
		
		//2 AND 3 CREATE AND EXCUTE THE STATMENT
	Statement stat=con.createStatement();
	//we store the string in the variable 
	
	//String query="INSERT INTO EMPLOYNAME VALUES(106,'gita', 14000)";
	// for update the name 
//String query="update employname set sname ='praveen' where sno=100";
// FOR DELETE THE STATMENT 
String query="DELETE FROM employname WHERE SNO=103";

	stat.execute(query);
	
	//4.close the connetion
	con.close();
	
	System.out.println("program is done!!!");
	
	
	
	
	
	
	
	
	
	}

}
