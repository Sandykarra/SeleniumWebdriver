package day27;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class captureFullScreening {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// take full page screen shot we use Takescreenshot webdriver
		TakesScreenshot ts=  (TakesScreenshot)driver; //down casting because we used webdriver object
	// help to take the screen shot
	File source=ts.getScreenshotAs(OutputType.FILE);
	// it will store the screen shot in the source variable
	//File target=new File("C:\\Selenium_java\\SeleniumWebDriver\\screenshot1");
	//instead of writing this much we can use other method ...good practice
	File target=new File(System.getProperty("user.dir")+"\\screenshot1\\homepage.png");
	// System.getProperty("user.dir")...help to get the current project location
	
	FileUtils.copyFile(source, target);
	// it help to copy from source to destionation
	
	
	
	
	}

}
