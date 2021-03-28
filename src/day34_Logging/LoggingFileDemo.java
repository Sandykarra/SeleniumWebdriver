package day34_Logging;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggingFileDemo {
	
	WebDriver driver;
	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 System.out.println("chrome browser launched");

			
			System.out.println("put the wait time page to load");
		 driver.get("https://demo.opencart.com/");
		 System.out.println("opencart application got opened");
		 driver.manage().window().maximize();
		 System.out.println("Broeser got maximized");
	}
	@Test
	void testregistation() {
		driver.findElement(By.xpath("//span[contains(text(),  'My Account')]")).click(); //My account
		System.out.println("My account button has clicked");
		driver.findElement(By.xpath("//a[contains(text(),  'Register')]")).click(); //register
		System.out.println("clicked the register button");
	driver.findElement(By.id("input-firstname")).sendKeys("xyz");//firstname
	System.out.println("given the firstname");
	driver.findElement(By.id("input-lastname")).sendKeys("12");
	System.out.println("given the last name");
	driver.findElement(By.id("input-email")).sendKeys("headp@gmail.com");
	System.out.println("enter the email address");
	driver.findElement(By.id("input-telephone")).sendKeys("0987654");
	System.out.println("send the phone number");
	driver.findElement(By.id("input-password")).sendKeys("Welcome12");
	System.out.println("enter the password");
	driver.findElement(By.id("input-confirm")).sendKeys("Welcome12");
	System.out.println("repeat the password");
	driver.findElement(By.xpath("//input[@value='0']")).click();
	System.out.println("select the No sudscribe button");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	System.out.println("agreed the terms and condition");
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	System.out.println("sumbit it button cliked");
	String text=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	System.out.println("validation message: "+text);
	
	if(text.equals("Warning: E-Mail Address is already registered!")) {
		System.out.println("Test case passed");
		System.out.println("Success: email Address is already exists");
		
	}else {
		
		System.out.println("Test Failed");
		System.out.println("Error: User email Registered again ..");	
	}
	
	}
	@AfterClass
	void tearDown() {
		driver.close();
		System.out.println("chrome browser closed");
	}

}
