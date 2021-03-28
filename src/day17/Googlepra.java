package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Googlepra {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		
			driver.manage().window().maximize();
			driver.get("https://www.google.co.uk/");
		    Thread.sleep(5000);
			//that pop up in the iframes 
			
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();

			driver.findElement(By.name("q")).sendKeys("Selenium");
			// its working now.........
		}

	


	}


