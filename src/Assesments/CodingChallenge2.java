package Assesments;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//Name:Sandya.k
/*Selenium Coding Challenge - 2
Requirments:Automate Buy Product Functionality for dummy E-Commerce Website
***********************************************************************
1. Open link http://automationpractice.com/index.php
2. Login to the website.
3. Move your cursor over Women's link.
4. Click on sub menu 'T-shirts'.
5. Mouse hover on the first product displayed.
6. 'More' button will be displayed, click on 'More' button.
7. Increase quantity to 2.
8. Select size 'L'
9. Select color.
10. Click 'Add to Cart' button.
11. Click 'Proceed to checkout' button.
12. Complete the buy order process till payment.
13. Make sure that Product is ordered.*/
public class CodingChallenge2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//1. Open link http://automationpractice.com/index.php
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//2. Login to the website.
		driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]")).click();
		driver.findElement(By.id("email_create")).sendKeys("bethisandhya.reddy@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']//span")).click();
		Thread.sleep(5000);
	
	//3. Move your cursor over Women's link.
	Actions act= new Actions(driver);
	WebElement women=driver.findElement(By.xpath("//a[@title=\"Women\"]"));
	act.moveToElement(women).perform();
	
	//4. Click on sub menu 'T-shirts'.
	
	WebElement	tshirts=driver.findElement(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']/li[1]/ul/li[1]/a"));
	tshirts.click();
	Thread.sleep(5000);
	
	//5. Mouse hover on the first product displayed.
	WebElement firstpro=driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	act.moveToElement(firstpro).perform();
	
	//6. 'More' button will be displayed, click on 'More' button.
	driver.findElement(By.xpath("//span[contains(text(), 'More')]")).click();
	
	//7. Increase quantity to 2.
WebElement plusbutton=driver.findElement(By.xpath("//i[@class='icon-plus']"));
plusbutton.click();

//8. Select size 'L'
Select size=new Select(driver.findElement(By.xpath("//select[@id='group_1']")));
size.selectByVisibleText("L");

//9. Select color.
driver.findElement(By.xpath("//a[@id='color_13']")).click();

//fine the name of the product for validation
String chosen_product=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1")).getText();
System.out.println("Name of the chosen product: "+chosen_product);
 //Name of the chosen product: Faded Short Sleeve T-shirts

//10. Click 'Add to Cart' button.
driver.findElement(By.xpath("//span[normalize-space()='Add to cart']")).click();

//11. Click 'Proceed to checkout' button.
driver.findElement(By.xpath("//span[contains(text(), 'Proceed to checkout')]")).click();

//12. Complete the buy order process till payment.
//summary
driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
//Sign in
driver.findElement(By.id("email")).sendKeys("bethisandhya.reddy@gmail.com");
driver.findElement(By.id("passwd")).sendKeys("Welcome123");
driver.findElement(By.xpath("//span[normalize-space()='Sign in']")).click();
//address
driver.findElement(By.xpath("//button[@name='processAddress']")).click();
//shipping
driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
Thread.sleep(4000);

//terms and conditions
WebElement Tconditions=driver.findElement(By.xpath("//input[@name='cgv']"));
System.out.println("Before clicking: "+Tconditions.isSelected());
//To click terms and conditions
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", Tconditions);
System.out.println("After clicking: "+Tconditions.isSelected());
//to close the popup
driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();

//click procedure to checkout
driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();

//13. Make sure that Product is ordered.
	 String ordered_Item= driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Faded Short Sleeve T-shirts')]")).getText();
	System.out.println("ordered item in the cart: "+ordered_Item);
	
	if(chosen_product.equals(ordered_Item)) {
		System.out.println("Buy prouct functionality is working...Testcase passed....");
		
	}else { 
		
		System.out.println("Testcase failed.....");
	}
	
	driver.close();
	
	
	 }
	

	}


