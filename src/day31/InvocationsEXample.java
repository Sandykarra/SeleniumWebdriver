package day31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvocationsEXample {
WebDriver driver;

	@Test(invocationCount=5)
	void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
	Assert.assertEquals("Account Login", driver.getTitle());
	driver.quit();
	
	}




}
