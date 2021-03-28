package day27;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee\"");
	driver.manage().window().maximize();
	
	WebElement logo=driver.findElement(By.xpath("//*[@id='btnLogin']"));
		
	File src=logo.getScreenshotAs(OutputType.FILE);
	
	File trg=new File(System.getProperty("user.dir")+"\\screenshot1\\element.jpg");
	
	FileUtils.copyFile(src, trg);
	
	driver.close();
	}

}
