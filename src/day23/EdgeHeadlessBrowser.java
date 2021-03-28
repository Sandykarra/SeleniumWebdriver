package day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeHeadlessBrowser {

	public static void main(String[] args) {
		//headless mode setup
		
		EdgeOptions options=new EdgeOptions();
		options.setHeadless(true);
		//------

System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
EdgeDriver driver=new EdgeDriver(options);
driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
driver.close();
	}

}
