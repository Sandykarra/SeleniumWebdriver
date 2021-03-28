package day23;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) {
		//headless mode setup
		
				ChromeOptions options=new ChromeOptions();
				options.setHeadless(true);
				//------
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		
	System.out.println("The title of the page: "+driver.getTitle());
	System.out.println("The URL of the page: "+driver.getCurrentUrl());

	}

}
