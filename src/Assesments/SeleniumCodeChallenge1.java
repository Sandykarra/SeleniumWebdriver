package Assesments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//Name:Sandya.k
/*Requirement: Challenge 1
Automate Search Product Functionality on Dummy E-Commerce Website

Steps to Automate:
1. Open link http://automationpractice.com/index.php
2. Move your cursor over Women's link.
3. Click on sub menu 'T-shirts'
4. Get Name/Text of the first product displayed on the page.
5. Now enter the same product name in the search bar present on top of page and click search button
6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.*/
public class SeleniumCodeChallenge1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//1. Open link http://automationpractice.com/index.php
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

	//2. Move your cursor over Women's link.
	 Actions act=new Actions(driver);
	 WebElement women=driver.findElement(By.xpath("//*[@title='Women' and @class='sf-with-ul']"));
	 act.moveToElement(women).perform();
	//3. Click on sub menu 'T-shirts'
	WebElement	tshirts=driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']/li[1]/ul/li[1]/a"));
	tshirts.click();
	//4. Get Name/Text of the first product displayed on the page.
	WebElement tshirtName=driver.findElement(By.xpath("//a[normalize-space()='Faded Short Sleeve T-shirts']"));
	System.out.println("The text of the first product: "+tshirtName.getText());
	
	//5. Now enter the same product name in the search bar present on top of page and click search button
	 WebElement searchbox=driver.findElement(By.id("search_query_top"));
		searchbox.sendKeys("Faded Short Sleeve T-shirts");
		searchbox.click();
	
		//6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
		
	WebElement afsearch=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a"));
   System.out.println("Afsearch the text: "+afsearch.getText());

if(tshirtName.equals(afsearch)) 
{
		System.out.println("Search product functionality is working.....Testcase paseed!!!!!!!!!!!");
	}else {
		System.out.println("Testcase Failed..");
	}
	driver.close();
	
	}

}
