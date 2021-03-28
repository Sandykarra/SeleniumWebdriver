package day14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Books for children");
driver.findElement(By.id("nav-search-submit-button")).click();
driver.findElement(By.name("accept")).click(); //accept cookies
List<WebElement> lists=driver.findElements(By.tagName("a")); //tagname
System.out.println("the number of links present on the homepage: "+lists.size());
List<WebElement> numberOfSliders=driver.findElements(By.className("a-carousel-card"));
System.out.println("The number of sliders:"+ numberOfSliders.size());
	driver.close();
	
	}

}
