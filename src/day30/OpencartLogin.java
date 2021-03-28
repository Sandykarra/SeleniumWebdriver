package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
1) Launch chrome browser and open app
2) Login
3) Close browser
*/
public class OpencartLogin {
	
	WebDriver driver;
	
@BeforeClass
void getUrl() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/login");
	driver.manage().window().maximize();
}
	
@Test(priority=0)
void Myaccount() {
	
	driver.findElement(By.xpath("//span[contains(text(), 'My Account')]")).click();//my account
	driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//li[2]")).click();
	}
	
@Test(priority=1)
void returningcustomer() {
	driver.findElement(By.id("input-email")).sendKeys("karrasandya84@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("welcome84");
driver.findElement(By.xpath("//input[@value='Login']")).click();
}

@Test(priority=2)
 void validation() {
	String expected_url="https://demo.opencart.com/index.php?route=account/account";
	String current_url=driver.getCurrentUrl();
	System.out.println("current page URL: "+ current_url);
	Assert.assertEquals(current_url, expected_url,"Testcase Failed..");
	 
 }
	
	



















}
