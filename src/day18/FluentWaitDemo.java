package day18;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//selenium4 - //declaration of Fluent Wait
		 Wait<WebDriver> mywait= new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(10))
			       .pollingEvery(Duration.ofSeconds(2))
			       .ignoring(NoSuchElementException.class); 
		
		//login to the URL*********************
		
		  driver.get("https://www.google.co.uk/");

		  driver.switchTo().frame(0);//to close the google cookie
		  driver.findElement(By.id("introAgreeButton")).click(); 
		  // i dont know how it work....
		  WebElement	kids_toys =driver.findElement(By.name("q"));
		  kids_toys.sendKeys("paint brushes for kids");
		  kids_toys.sendKeys(Keys.RETURN);
		//usage of Fluent Wait*********************
			 WebElement paint = mywait.until(new Function<WebDriver, WebElement>() {
				 public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.xpath("//span[text() ='Paint Brushes For Kids | Hobbycraft']"));
				     }
				   });
				
				 paint.click();
				 System.out.println("Search results found.....");
				 driver.close();

	  }
	}


