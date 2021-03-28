package day27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadingPropertiesFromFile {

	public static void main(String[] args) throws IOException {
	
//appraoch:1 reading from resource file
		//1. get the location
		File f=new File(System.getProperty("user.dir")+"\\propertiesfile\\app.properties");
	
// to read the data from file
		FileInputStream fis=new FileInputStream(f); 
		//to load the data into file
		/*Properties pro=new Properties();
		pro.load(fis);
		 
		String url=pro.getProperty("url");
	String username=pro.getProperty("username");
	String pwd=pro.getProperty("pwd");
	System.out.println(url);
	System.out.println(username);
	System.out.println(pwd);*/
	
	

	//Appraoch2
		//first method is importand according to intreview 
		//mostly we use this method in real time but folder has to be in the resource place only with this approach
	ResourceBundle rb=ResourceBundle.getBundle("app");
	String url=rb.getString("url");
	String email=rb.getString("useremail");
	String password=rb.getString("userpassword");
	
	System.out.println(url);
	System.out.println(email);
	System.out.println(password);
	 
	}

}
