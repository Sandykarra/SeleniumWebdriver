package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
          driver.get("https://jqueryui.com/tooltip/");
		
		driver.switchTo().frame(0);
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='age']"));
		System.out.println("Tool tip text:"+inputbox.getAttribute("title")); //it help to find the tooltip message
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
