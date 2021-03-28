package day15;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RelativeXpathDemo2 {

	public static void main(String[] args) {
System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
WebDriver driver=new EdgeDriver();
driver.get("http://automationpractice.com/index.php");
//driver.findElement(By.xpath("//input[@name=\"search_query\"]")).sendKeys("Dresses");
//driver.findElement(By.xpath("//button[@name='submit_search']")).click();
int sliders=driver.findElements(By.xpath("//a[normalize-space()='Next']")).size();
	System.out.println(sliders);
	int images=driver.findElements(By.tagName("img")).size();
	System.out.println(images);
	//and
	//driver.findElement(By.xpath("//input[@id=\"search_query_top\" and @name=\"search_query\"]")).sendKeys("T-shirts");
	//or
	//driver.findElement(By.xpath("//button[@name=\"submit_search\" or @class=\"btn btn-default button-search\" ] ")).click();
	//contains
	//driver.findElement(By.xpath("//input[contains(@name,'query')]")).sendKeys("Summer dress");
//driver.findElement(By.xpath("//button[contains(@name,'_search')]")).click();
	//starts-with
//driver.findElement(By.xpath("//a[starts-with(@class, 'sf')]")).click();
//text
//driver.findElement(By.xpath("//a[text()='Dresses']")).click();

//chained xpaths

		driver.findElement(By.xpath("//form[@id='searchbox']/input[@id='search_query_top']")).sendKeys("T-shirts");
		driver.findElement(By.xpath("//form[@id='searchbox']/button[@type='submit']")).click();
		
	

	
	
	
	}

}
