package day23;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefox {

	public static void main(String[] args) {
		
		//headless mode setup
		
				FirefoxOptions options=new FirefoxOptions();
				options.setHeadless(true);
				//------

		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver(options);
		driver.get("https://demo.nopcommerce.com/");
				System.out.println(driver.getTitle());
				System.out.println(driver.getCurrentUrl());
				
	driver.close();
	
	
	
	}

}
