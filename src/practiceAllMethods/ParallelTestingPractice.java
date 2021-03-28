package practiceAllMethods;

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

public class ParallelTestingPractice {
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
@Test(priority=3)
void tearDown1() {
driver.close();
		}
	
	@Test(priority=4)
	public void Logotest() {
		boolean logo=driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	Assert.assertEquals(logo, true,"Logo is not present");
	System.out.println("logo test...");
	}
	@Test(priority=5)
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
