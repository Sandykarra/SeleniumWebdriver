package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText_Locators {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver(); 
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();  	// to maximize the browser
// link text and partial linktext helps to find links
	
	//driver.findElement(By.linkText("Blouse")).click(); //linktext (full value);partial (printed summer dress)
	driver.findElement(By.partialLinkText("Summer Dress")).click(); //partial linktext
	//linked test we have to pass full value; if we use partial text then we have to pass partial value of the text
	}

}
