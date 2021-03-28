package day16;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommands {
	/*get commands 
	-----------
	get(url)    // opens the url on browser
	getTitle()  //Title of the page
	getCurrentURL()  // URL of application
	getPageSource()  // HTML code of the epage
	getWindowHandle()
	getWindowHandles()*/
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dri=new ChromeDriver();
		dri.get("https://demo.opencart.com/");
	String	title=dri.getTitle();
	System.out.println("The tile of the page: "+title);
	String url=dri.getCurrentUrl();
	System.out.println("The URL of the page: "+url);
	// page source means bring html 
	//System.out.print(dri.getPageSource());
	String winid=dri.getWindowHandle();
	System.out.println(winid); //keep on change the value dynamically
	                            
	
	Set<String>  winids=dri.getWindowHandles();
	System.out.println(winids); 
	//set wont allow the duplicates
	// set<string> hold mulipile commands
		
		
		
		

	}

}
