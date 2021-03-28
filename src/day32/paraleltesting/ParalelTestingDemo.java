package day32.paraleltesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParalelTestingDemo {
WebDriver driver;

@BeforeClass
@Parameters({"browser", "app"})
public void setup(String br,String url) {
	if(br.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
		
	 
	 }
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 
	}else if(br.equals("edge")) {
		System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		 driver=new EdgeDriver();
	}
	driver.get(url);
}
@Test(priority=1)
public void Logotest() {
	boolean logo=driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
Assert.assertEquals(logo, true,"Logo is not present");
System.out.println("logo test...");
}
@Test(priority=2)
 void gmailtest() {
	 boolean gmail=driver.findElement(By.xpath("//a[normalize-space()='Gmail']")).isDisplayed();
 Assert.assertEquals(gmail, true,"not present");
System.out.println("gmailtest....."); 
}
 @AfterClass
  void tearDown() {
	  driver.close();
  }



}
