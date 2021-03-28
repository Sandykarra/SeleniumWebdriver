package day27;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectionOfThePart_screenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/digital-downloads");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;

		// when i tried to capture the picture its not coming full pic so i use mouse operation to drag the browser then i took the picture
		// worked fine now....
		//2. Scroll down page till the element is visible
		
				WebElement flag=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]"));
				js.executeScript("arguments[0].scrollIntoView();",flag);
		
		
//to capture the section of element screen shot
		WebElement screenshot=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]"));
	///html/body/div[6]/div[3]/div[2]/div[2]/div/div[2]/div[3]/div
		Thread.sleep(3000);
		File source=screenshot.getScreenshotAs(OutputType.FILE);
	File target= new File(System.getProperty("user.dir")+"\\screenshot1\\chosen.png");
	
	FileUtils.copyFile(source, target);
	}

}
