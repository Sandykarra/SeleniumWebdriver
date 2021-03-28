package Day19;
/* 1. close the alert pop up
 * 2.try to enter the text in the text box*/
 
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click(); //popup source element xpath
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//how to handle****************
	Alert alertpopUp=driver.switchTo().alert();
	System.out.println("Message displayed on the popup window: "+alertpopUp.getText());
	alertpopUp.accept(); // to accept the cookie
	//alertpopUp.dismiss();
	

	
	}

}
