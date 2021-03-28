package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.facebook.com");
		
		//Tag Id (#)
	//to find elements we use this 
driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
	// we can use tag and name or tag or id(#email)or .name only
//driver.findElement(By.cssSelector("input.inputtext).sendKeys("welcome");
//tag and class we have use .(due to same values for email id and pass it taking email is as its first value)

//tag name attribute combination
driver.findElement(By.cssSelector("input.inputtext[name='pass']")).sendKeys("welcome");




	
	}

}
