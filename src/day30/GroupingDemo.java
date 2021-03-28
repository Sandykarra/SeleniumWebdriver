package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupingDemo {
	WebDriver driver;
	
	@BeforeClass
public void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//1. Open link http://automationpractice.com/index.php
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	System.out.println("before class is this........");
}
	@Test(priority=1,groups= {"A"})
void women(){
	//2. Move your cursor over Women's link.
		 Actions act=new Actions(driver);
		 WebElement women=driver.findElement(By.xpath("//*[@title='Women' and @class='sf-with-ul']"));
		 act.moveToElement(women).perform();
		 System.out.println("group a");
}
	
@Test(priority=2,groups= {"B"})
 void shirt() {
	//3. Click on sub menu 'T-shirts'
		WebElement	tshirts=driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']/li[1]/ul/li[1]/a"));
		tshirts.click();
		System.out.println("group b");
 }
@Test(priority=3,groups= {"C"})
void groups() {
	
	//4. Get Name/Text of the first product displayed on the page.
		WebElement tshirtName=driver.findElement(By.xpath("//a[normalize-space()='Faded Short Sleeve T-shirts']"));
		System.out.println("The text of the first product: "+tshirtName.getText());
System.out.println("group c");
}
@Test(priority=4,groups= {"A"})
void product() {
//5. Now enter the same product name in the search bar present on top of page and click search button
WebElement searchbox=driver.findElement(By.id("search_query_top"));
	searchbox.sendKeys("Faded Short Sleeve T-shirts");
	searchbox.click();
	System.out.println("group a");

}
@Test(priority=5,groups= {"C"})
void validation() {
	//6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
	
	WebElement afsearch=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
   System.out.println("Afsearch the text: "+afsearch.getText());
  String tshirtName="Faded Short Sleeve T-shirts";
if(tshirtName.equals(afsearch)) 
{
		System.out.println("Search product functionality is working.....Testcase paseed!!!!!!!!!!!");
	}else {
		System.out.println("Testcase Failed..");
	}
}
@AfterClass
void teatdown() {
	driver.close();
	System.out.println("after class this....");
}
	
	}
	

