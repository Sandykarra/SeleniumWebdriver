package day14;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameLocatorsDemo {

	public static void main(String[] args) {
		
		//first 2 statments help to launch the browser
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();   //creating a webdriver object
	// to open the application url we have to use get method
	driver.get("http://automationpractice.com/index.php");
	// to maximize the browser
	driver.manage().window().maximize();
	// using id and name locators
	// methods always return somevalues. findelement is a method its always return webelement
	WebElement searchbox=driver.findElement(By.id("search_query_top"));
	searchbox.sendKeys("T-shirts");
	driver.findElement(By.name("submit_search")).click();
	
	}

}
