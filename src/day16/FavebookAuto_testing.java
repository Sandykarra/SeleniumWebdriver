package day16;
// Author:sandya
/*Test case: Facebook account creation
 * 1. checking all elements
 * 2.verify tc passed/failled*/
 
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FavebookAuto_testing {
	public static void main(String[] args) throws InterruptedException {

		// setting path
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); // instance creation
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// get Url
		driver.get("https://www.facebook.com/");
//login clear
		System.out.println("The Title of the facebook: "+driver.getTitle());
		System.out.println("The URL of the page: "+driver.getCurrentUrl());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[data-cookiebanner='accept_button']")).click(); // remove cookies page
		driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']")).click(); // click on the create account
		Thread.sleep(5000);
		//fristname
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("LadyBug");
	//lastname
		driver.findElement(By.name("lastname")).sendKeys("miraculous");
// email
		driver.findElement(By.xpath("//input[@name=\"reg_email__\"]")).sendKeys("Javaselenium824@gmail.com");
	driver.findElement(By.xpath("//input[@name=\"reg_email_confirmation__\"]")).sendKeys("Javaselenium824@gmail.com");
		
		
		//password
		
		
		driver.findElement(By.cssSelector("input[name=\"reg_passwd__\"]")).sendKeys("Welcome@456");
	//date
		driver.findElement(By.id("day")).sendKeys("15");// shortcut
		//month
	Select month =new Select(driver.findElement(By.name("birthday_month")));
	month.selectByVisibleText("Nov"); 
	//driver.close();
	
	WebElement First_sel=month.getFirstSelectedOption();
	System.out.println(First_sel.getSize());
	
	//year
	Select year=new Select(driver.findElement(By.id("year")));
	year.selectByVisibleText("1984");
	//male Radiobutton
	List<WebElement> MaleRb=driver.findElements(By.xpath("//input[@name=\"sex\" and @value=\"2\"]"));
	//we can use isselected directly as well
	for(WebElement mrb:MaleRb) {
		System.out.println(mrb.isSelected());
		mrb.click();
		System.out.println(mrb.isSelected());
	
	//signup
		driver.findElement(By.cssSelector("button[class=\"_6j mvm _6wk _6wl _58mi _3ma _6o _6v\"]")).click();
	
	if(driver.getTitle().equalsIgnoreCase("https://www.facebook.com/checkpoint/1501092823525282/?next=https%3A%2F%2Fwww.facebook.com%2F&__req=d")) {
		System.out.println("Test case passed!");
	}else {
		System.out.println("Test case failed");
	}
	 driver.close();
	
	}
	
	}
	
	}


