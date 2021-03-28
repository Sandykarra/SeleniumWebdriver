package day34_Logging;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log4j2_Demo {
	
	WebDriver driver;
	Logger logger;
	@BeforeClass
	public void setup() {
		logger=LogManager.getLogger("Log4j2_Demo");

		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		logger.info("chrome browser launched");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			logger.info("put the wait time page to load");
		 driver.get("https://demo.opencart.com/");
		 logger.info("opencart application got opened");
		 driver.manage().window().maximize();
		 logger.info("Browser got maximized");
	}
	@Test(priority=1)
	void testregistation() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),  'My Account')]")).click(); //My account
		logger.info("My account button has clicked");
		driver.findElement(By.xpath("//a[contains(text(),  'Register')]")).click(); //register
		logger.info("clicked the register button");
	driver.findElement(By.id("input-firstname")).sendKeys("xyz");//firstname
	logger.info("given the firstname");
	driver.findElement(By.id("input-lastname")).sendKeys("12");
	logger.info("given the last name");
	driver.findElement(By.id("input-email")).sendKeys("headp@gmail.com");
	logger.info("enter the email address");
	driver.findElement(By.id("input-telephone")).sendKeys("0987654");
	logger.info("sent the phone number");
	driver.findElement(By.id("input-password")).sendKeys("Welcome12");
	logger.info("entered the password"); 
	driver.findElement(By.id("input-confirm")).sendKeys("Welcome12");
	logger.info("repeated the password");
	driver.findElement(By.xpath("//input[@value='0']")).click();
	logger.info("select the No sudscribe button");
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	logger.info("agreed the terms and condition");
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	logger.info("sumbit it button cliked");
	logger.debug("capturing API calls....");
	
	String text=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	logger.info("validation message: "+text);
	
	if(text.equals("Warning: E-Mail Address is already registered!")) {
		
		logger.info("Success: email Address is already exists...Test passed");
		Assert.assertTrue(true);
	}else {
		
		logger.error("Error: User email Registered again ..Test failed");
		Assert.assertTrue(false);
	}
	
	}
@Test(priority=2)
void testLogin() throws InterruptedException {
	driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	logger.info("My account link got clicked");
	driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li[2]/a")).click();
	logger.info("Login link got clicked");
driver.findElement(By.id("input-email")).sendKeys("headp@gmil.com");
logger.info("provided email id");
driver.findElement(By.id("input-password")).sendKeys("Welcome12");
logger.info("provided password");
driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
logger.info("Login button clicked");
logger.debug("capturing all the steps.......................");
//validation

String Logo_visible=driver.findElement(By.xpath("//a[contains(text(), \"Your Store\")]")).getText();
Thread.sleep(3000);
logger.info("To validation comparing the logo text: "+Logo_visible);
logger.info("test passed..");
//Assert.assertEquals(Logo_visible, "Your Store2","This message from Assertions...Test failed");

if(Logo_visible.equals("Your Store2")) {
	logger.info("Test passed.....");
	Assert.assertTrue(true);

}else
	{
	logger.error("Test failed.....");
	Assert.assertTrue(false);
	}
	
	/*driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	logger.info("My account link got clicked..for the logout");
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	logger.info("clicked the logout.....");*/

}
	//@AfterClass
	void tearDown() {
		driver.close();
		logger.info("chrome browser closed");
	}

	
	
	

}
