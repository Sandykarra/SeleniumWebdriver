package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
	
/*WebElement key=driver.findElement(By.id("target"));
	key.sendKeys("helloworld");*/
	
	Actions act= new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();//enter
	Thread.sleep(3000);
	act.sendKeys(Keys.BACK_SPACE).perform(); //backspace
	Thread.sleep(3000);
	act.sendKeys(Keys.CONTROL+"a").perform(); //for multiple keys 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
