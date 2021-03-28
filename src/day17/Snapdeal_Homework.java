package day17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Snapdeal_Homework {
	//Homework:day 17th
	/*1) Find Number of links & images on webpage.
https://www.snapdeal.com/ */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("//input[@name=\"keyword\"]")).sendKeys("Smart Phones");
driver.findElement(By.cssSelector("button[class=\"searchformButton col-xs-4 rippleGrey\"]")).click();

//links 
List<WebElement> Tagnames=driver.findElements(By.tagName("a"));
	System.out.println("The number of tags in the webpage:"+Tagnames.size());
	
	for(WebElement links:Tagnames) {
		System.out.println(links.getText());
		Thread.sleep(5000);
		
		//images 
		List<WebElement> images=driver.findElements(By.tagName("img"));
	System.out.println("The number of images in the webpage: "+images.size());
	Thread.sleep(3000);
	driver.close();
	}
	
	}

}
