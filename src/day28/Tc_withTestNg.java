package day28;
/*open orange HRM application
 * login and logout the application
 * verrify TC passed or not*/

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tc_withTestNg {
	WebDriver driver;
	
	@Test(priority=1)
void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");	
}
	//	here driver is the local variable we can't access outside the method; to access outside the method also
    //we have to declare webdriver as a global variable 
	@Test(priority=2)
	void captureScreenshot() throws IOException {
		
		WebElement Title=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
	File Source=Title.getScreenshotAs(OutputType.FILE);
	File Target=new File(System.getProperty("user.dir")+"\\screenshot1\\orange.jpg");
	FileUtils.copyFile(Source, Target);
	
	}
	@Test(priority=3)
	void login() {
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	driver.findElement(By.id("btnLogin")).click();


//validation
	
	String Actual_url=driver.getCurrentUrl();
	String expected_url="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	/*if(Actual_url.equals(expected_url)) 
	{		System.out.println("Test case passed!!!!!!!!!!");
	Assert.assertTrue(true);
	}else 
	{		System.out.println("Test case Failed.....");
	Assert.assertFalse(false);
	}*/
	
	//shortcut for the validation
	Assert.assertEquals(Actual_url, expected_url,"Test case Failed...");
	
	} 
   @Test(priority=4)
  void tearDown() 
{
	driver.close();
}

	//don't know where the screenshot is storing 

















}
