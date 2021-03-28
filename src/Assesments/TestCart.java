package Assesments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		 driver.get("http://www.flipkart.com/");
		    driver.findElement(By.id("fk-top-search-box")).sendKeys("Asus Zenfone 5");
		    driver.findElement(By.xpath("//input[@value='Search']")).click();

		    // Selecting first product
		    driver.findElement(By
		        .xpath(".//*[@id='products']/div/div[1]/div[1]/div/div[1]/a[1]"));
		    String name = driver.findElement(By.className("title")).getText();
		    String price = driver.findElement(By
		        .xpath("//span[@class='selling-price omniture-field']")).getText();
		    System.out.println("ProductName: "+name + "  ProductPrice: "+price);

		    //Adding selected product to cart
		    driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		    Thread.sleep(3000);

		    //Checking product is available in cart or not
		    driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		    Thread.sleep(5000);
	
	
	
	
	}

}
