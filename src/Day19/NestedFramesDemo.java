package Day19;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* nested frames means one frame inside another frame
 * dont need to use default content until reach the webelement*/
public class NestedFramesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		// i want to intreact with the element but there are in the nested frames 
		// to reach that we have to first swith the frames to webpage
		//select the dual frame
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		
		//to select outer frame**************
		WebElement outerframe=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(outerframe);
		
		// To select inner frame**************
	WebElement Innerframe=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
	driver.switchTo().frame(Innerframe);
	//interacat with webelemt in the webpage
	driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Well done!!");
	
	
	// we dont need to use click when we are switching from frames becz our goal is to enter inside the webpage
	
	}

}
