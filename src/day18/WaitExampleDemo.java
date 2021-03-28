package day18;
//using wait commands***************************
/* 1. search the elemetn in google.
 * 2. diferrent element find out from the list*/
 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitExampleDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver dri=new ChromeDriver();
		dri.get("https://www.google.co.uk/");
	WebElement	search =dri.findElement(By.name("q"));
	dri.switchTo().frame(0);
	dri.findElement(By.id("introAgreeButton")).click();
	//dri.findElement(By.)
	
	Thread.sleep(3000);
	search.sendKeys("Selenium");
	search.sendKeys(Keys.ENTER); //to enter from keyboard
	//click selenium-wikipedia link
		dri.findElement(By.xpath("//*[@id=\"rso\"]/div[3]/div[2]/div/div[1]/a/h3/span")).click();
//dinamic link to catch other eleemnt 
		dri.close();

	}

}
