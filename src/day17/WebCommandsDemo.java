package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
/*Navigational commands 
-------------------
navigate().to(URL)
navigate().back()
navigate().forward()
navigate().refresh()*/
public class WebCommandsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.google.co.uk/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("introAgreeButton")).click(); //close the google cookie iframe

		driver.navigate().to("https://www.bing.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id=\"bnp_btn_accept\"]")).click(); // to remove cookie
		driver.close();
		
		
	}

}
